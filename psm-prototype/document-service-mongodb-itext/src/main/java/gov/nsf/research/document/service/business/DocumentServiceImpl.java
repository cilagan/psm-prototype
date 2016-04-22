package gov.nsf.research.document.service.business;

import gov.nsf.research.document.service.dao.DocumentServiceDao;
import gov.nsf.research.document.service.dao.ProposalDao;
import gov.nsf.research.document.service.model.DocumentMetaData;
import gov.nsf.research.document.service.model.SectionType;
import gov.nsf.research.document.service.model.proposal.ProjectSummary;
import gov.nsf.research.document.service.pdf.PDFService;
import gov.nsf.research.document.service.repository.ProjectDescRepository;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

public class DocumentServiceImpl implements DocumentService {

	@Autowired
	DocumentServiceDao docServiceDao;
	
	@Autowired
	PDFService pDFService;
	
	@Autowired
	ProjectDescRepository pdr;
	
	@Autowired
	ProposalDao proposalDao;
	
	@Override
	public DocumentMetaData uploadPropSection(ByteArrayInputStream inputStream, String tempPropId, SectionType sectionType) {
			
		return docServiceDao.saveDocument(inputStream, tempPropId, sectionType);
	}

	@Override
	public ByteArrayOutputStream getPropSection(String tempPropId, SectionType sectionType) {
		return docServiceDao.viewDocument(tempPropId, sectionType);
	}

	@Override
    public ByteArrayOutputStream getEntirePropSection(String tempPropId) {
           ByteArrayOutputStream baos =  new ByteArrayOutputStream();
           List<ByteArrayOutputStream> baosList = new ArrayList<ByteArrayOutputStream>();
           ByteArrayOutputStream projDesc = docServiceDao.viewDocument(tempPropId, SectionType.PROJECT_DESCRIPTION);
           ByteArrayOutputStream dmpPlan = docServiceDao.viewDocument(tempPropId, SectionType.DATA_MANAGEMENT_PLAN);
           ByteArrayOutputStream caps = docServiceDao.viewDocument(tempPropId, SectionType.CURR_PEND_SUPPORT);
           ByteArrayOutputStream  bs= docServiceDao.viewDocument(tempPropId, SectionType.BIO_SKETCHES);
           ByteArrayOutputStream ment = docServiceDao.viewDocument(tempPropId, SectionType.MENTOR_PLAN);
           ByteArrayOutputStream projsumm = getProjectSummaryText(tempPropId);
           
//         baosList.add(toc);
           baosList.add(projDesc);
           baosList.add(dmpPlan);
           baosList.add(caps);
           baosList.add(bs);
           baosList.add(ment);
           baosList.add(projsumm);
          
          Map<String, PdfReader> filesToMerge = new TreeMap<String, PdfReader>();
          
          try {
			filesToMerge.put("01.Project Description", new PdfReader(projDesc.toByteArray()));
			filesToMerge.put("02.Data Management Plan", new PdfReader(dmpPlan.toByteArray()));
			filesToMerge.put("03.Current and Pending", new PdfReader(caps.toByteArray()));
			filesToMerge.put("04.Bio Sketches", new PdfReader(bs.toByteArray()));
			filesToMerge.put("05.Mentoring Plan", new PdfReader(ment.toByteArray()));
			filesToMerge.put("06.Project Summary", new PdfReader(projsumm.toByteArray()));
		} catch (IOException e) {
			e.printStackTrace();
		}
           
          Map<SectionType, ByteArrayOutputStream> files = new TreeMap<SectionType, ByteArrayOutputStream>();
         	  files.put(SectionType.PROJECT_DESCRIPTION, projDesc);
        	  files.put(SectionType.DATA_MANAGEMENT_PLAN, dmpPlan);
        	  files.put(SectionType.CURR_PEND_SUPPORT, caps);
        	  files.put(SectionType.BIO_SKETCHES, bs);
        	  files.put(SectionType.MENTOR_PLAN, ment);
        	  files.put(SectionType.PROJ_SUMM, projsumm);

//          baos =  pDFService.CreateEntireProposal(tempPropId, baosList);
          
//          baos =  pDFService.CreateEntireProposal(filesToMerge);
          
          baos = pDFService.CreateEntireProposalWithBookMarks(files);

          //TODO: Confirm this is correct placement or if we need a new function to specifically stamp PDFs
          baos = pDFService.stampPDF(baos, proposalDao.getStampPDFTimeStamp(tempPropId));

          return baos;
    }

	private void savetoLocal(List<ByteArrayOutputStream> baosList) {
		Document document = new Document();
		System.out.println("DocumentServiceImpl.savetoLocal()"
				+ baosList.size());

		try {

			FileOutputStream outputStream = new FileOutputStream(
					"C:\\Users\\spendyal\\Desktop\\Test\\itext.pdf");
			PdfWriter writer = PdfWriter.getInstance(document, outputStream);
			document.open();
			PdfContentByte cb = writer.getDirectContent();
			PdfReader reader = null;
			for (ByteArrayOutputStream ba : baosList) {

				reader = new PdfReader(ba.toByteArray());

				for (int i = 1; i <= reader.getNumberOfPages(); i++) {
					document.newPage();
					PdfImportedPage page = writer.getImportedPage(reader, i);
					cb.addTemplate(page, 0, 0);
				}
			}

			outputStream.flush();
			document.close();
			outputStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deletePropSection(String tempPropId, SectionType sectionType) {
		//System.out.println("deleting - " + tempPropId +" | " + sectionType);
		docServiceDao.deleteDocument(tempPropId, sectionType);
	}

	@Override
	public ByteArrayOutputStream getProjectSummaryText(String tempPropId) {

		ProjectSummary projSummText = proposalDao.getProjectSummary(tempPropId);
		System.out.println("DocumentServiceImpl.getProjectSummaryText()"
				+ tempPropId);

		System.out.println("**text:" + projSummText);

		ByteArrayOutputStream outputstream = new ByteArrayOutputStream();

		outputstream = pDFService.createPDF(projSummText.getOverView());

		return outputstream;

	}
}
