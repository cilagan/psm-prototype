package gov.nsf.research.document.service.business;

import gov.nsf.research.document.service.dao.DocumentServiceDao;
import gov.nsf.research.document.service.dao.ProposalDao;
import gov.nsf.research.document.service.model.DocumentMetaData;
import gov.nsf.research.document.service.model.SectionType;
import gov.nsf.research.document.service.pdf.PDFUtility;
import gov.nsf.research.document.service.repository.ProjectDescRepository;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

public class DocumentServiceImpl implements DocumentService {

	@Autowired
	DocumentServiceDao docServiceDao;
	
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
           
           Document document = new Document();
           //savetoLocal(baosList);

           PdfWriter writer = null;
           PdfReader reader = null; 
           try {
                  writer = PdfWriter.getInstance(document, baos);

                  document.open();
                  PdfContentByte cb = writer.getDirectContent();
                  for (ByteArrayOutputStream ba : baosList) {

                        reader = new PdfReader(ba.toByteArray());
                 
                  for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                        document.newPage();
                        PdfImportedPage page = writer.getImportedPage(reader, i);
                        cb.addTemplate(page, 0, 0);
                  }
                  }
           }      catch (DocumentException e) {
                  e.printStackTrace();
           }catch (IOException e) {
                  e.printStackTrace();
           }
           //outputStream.flush();
           document.close();
           //outputStream.close();
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

		String projSummText = proposalDao.getProjectSummary(tempPropId);
		System.out.println("DocumentServiceImpl.getProjectSummaryText()"
				+ tempPropId);

		System.out.println("**text:" + projSummText);

		ByteArrayOutputStream outputstream = new ByteArrayOutputStream();

		outputstream = PDFUtility.createPDFDocumentFromText(projSummText);

		return outputstream;

	}
}
