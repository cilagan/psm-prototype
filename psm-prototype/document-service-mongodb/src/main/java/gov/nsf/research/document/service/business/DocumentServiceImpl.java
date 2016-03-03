package gov.nsf.research.document.service.business;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.springframework.beans.factory.annotation.Autowired;

import gov.nsf.research.document.service.dao.DocumentServiceDao;
import gov.nsf.research.document.service.dao.ProposalDao;
import gov.nsf.research.document.service.model.DocumentMetaData;
import gov.nsf.research.document.service.model.SectionType;
import gov.nsf.research.document.service.pdf.PDFUtility;
import gov.nsf.research.document.service.repository.ProjectDescRepository;

public class DocumentServiceImpl implements DocumentService {

	@Autowired
	DocumentServiceDao docServiceDao;
	
	@Autowired
	ProjectDescRepository pdr;
	
	@Autowired
	ProposalDao proposalDao;
	
	@Override
	public DocumentMetaData uploadPropSection(ByteArrayInputStream inputStream, String tempPropId, SectionType sectionType) {
		System.out.println("saving doc on service layer.");
		return docServiceDao.saveDocument(inputStream, tempPropId, sectionType);
	}

	@Override
	public ByteArrayOutputStream getPropSection(String tempPropId, SectionType sectionType) {
		return docServiceDao.viewDocument(tempPropId, sectionType);
	}

	@Override
	public ByteArrayOutputStream getEntirePropSection(String tempPropId) {
		List<ByteArrayOutputStream> baosList = new ArrayList<ByteArrayOutputStream>();
				
//		baosList.add(docServiceDao.viewDocument(tempPropId, SectionType.PROJECT_DESCRIPTION));
//		baosList.add(docServiceDao.viewDocument(tempPropId, SectionType.DATA_MANAGEMENT_PLAN));
		//baosList.add(docServiceDao.viewDocument(tempPropId, SectionType.BIO_SKETCHES));
		//baosList.add(docServiceDao.viewDocument(tempPropId, SectionType.CURR_PEND_SUPPORT));
		//baosList.add(docServiceDao.viewDocument(tempPropId, SectionType.MENTOR_PLAN));
		
		ByteArrayOutputStream projDesc = docServiceDao.viewDocument(tempPropId, SectionType.PROJECT_DESCRIPTION);
		ByteArrayOutputStream dmpPlan = docServiceDao.viewDocument(tempPropId, SectionType.DATA_MANAGEMENT_PLAN);
		ByteArrayOutputStream caps = docServiceDao.viewDocument(tempPropId, SectionType.CURR_PEND_SUPPORT);
		ByteArrayOutputStream  bs= docServiceDao.viewDocument(tempPropId, SectionType.BIO_SKETCHES);
		ByteArrayOutputStream ment = docServiceDao.viewDocument(tempPropId, SectionType.MENTOR_PLAN);
		
		//Create TOC
		ByteArrayOutputStream toc =  new ByteArrayOutputStream();
		try {
			toc = PDFUtility.createTOC(tempPropId, projDesc, dmpPlan, caps, bs, ment);
		} catch (COSVisitorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		baosList.add(toc);
		baosList.add(projDesc);
		baosList.add(dmpPlan);
		baosList.add(caps);
		baosList.add(bs);
		baosList.add(ment);
		
		
		ByteArrayOutputStream baos = (ByteArrayOutputStream)PDFUtility.concatenateDocuments(baosList);
		ByteArrayOutputStream ba = PDFUtility.CreateEntireProposal(tempPropId, toc, baos, projDesc, dmpPlan, caps, bs, ment);
//		System.out.println("DocumentServiceImpl.getEntirePropSection() Size of the out file : "+ba.toByteArray().length);
		return ba;
	}

	@Override
	public void deletePropSection(String tempPropId, SectionType sectionType) {
		System.out.println("deleting - " + tempPropId +" | " + sectionType);
		docServiceDao.deleteDocument(tempPropId, sectionType);
	}

	@Override
	public ByteArrayOutputStream getProjectSummaryText(String tempPropId) {
       
		String projSummText = proposalDao.getProjectSummary(tempPropId);
				
		ByteArrayOutputStream  outputstream  = PDFUtility.createPDFDocumentFromText(projSummText);
		
		return outputstream;
		

		
	}
}
