package gov.nsf.research.document.service.pdf.impl;

import gov.nsf.research.document.service.model.SectionType;
import gov.nsf.research.document.service.pdf.PDFService;
import gov.nsf.research.psm.proposal.transfer.proposals.BioSketches;
import gov.nsf.research.psm.proposal.transfer.proposals.GetProposalResponse;
import gov.nsf.research.psm.proposal.webservice.client.ProposalDataServiceClient;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

public class ITextPDFServiceImpl implements PDFService {

	@Autowired
	public ProposalDataServiceClient proposalDataServiceClient;
	
	
	/**
	 * NFS mount 
	 */
	public static final String NFS_MOUNT = "/mnt/pdfs";
	
	
	/**
	 * 
	 */
	@Override
	public ByteArrayOutputStream createPDF(SectionType sectionType,
			String tempPropId) {
		System.out.println("ITextPDFServiceImpl.createPDF()[SectionType ="
				+ sectionType + ":Temp Prop ID =" + tempPropId + "]");

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		if (SectionType.PROJ_SUMM.equals(sectionType)) {

			baos = generateProjectSummaryPDF(tempPropId);

		} else if (SectionType.REF_CITED.equals(sectionType)) {

			baos = generateRefCitedPDF(tempPropId);

		} else if (SectionType.BIO_SKETCHES.equals(sectionType)) {

			baos = generateBiographicalSketchesPDF(tempPropId);
		}

		else if (SectionType.FAC_EQUP.equals(sectionType)) {

			baos = generateFacEquipmentPDF(tempPropId);
		}

		return baos;
	}
	
	

	@Override
	public ByteArrayOutputStream CreateEntireProposalPDF(String tempPropId) {

		System.out.println("ITextPDFServiceImpl.CreateEntireProposalPDF()[Temp Prop ID =" + tempPropId + "]");

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		List<ByteArrayOutputStream> baosList = new ArrayList<ByteArrayOutputStream>();
		
		//Project Summary
		ByteArrayOutputStream projsumm = createPDF(SectionType.PROJ_SUMM, tempPropId);
		GetProposalResponse proposal = proposalDataServiceClient.getProposal(tempPropId);
		//XMLGregorianCalendar xmlDate = proposal.getProposal().getProposalHeader().getSubmitTimeStamp();
		//java.util.Date date = xmlDate.toGregorianCalendar().getTime();
		//projsumm = stampPDF(projsumm, SectionType.PROJ_SUMM, "Corrected : "+new SimpleDateFormat("MM/dd/yyyy").format(date));
		
		//Reference Cited
		ByteArrayOutputStream refcited = createPDF(SectionType.REF_CITED,	tempPropId);
		String stampText ="Place Holder for PI Transfer/Revised Budget PDF Stamp";
		refcited = stampPDF(refcited, SectionType.REF_CITED,stampText);
		
		//Biographical Sketches
		ByteArrayOutputStream bs = createPDF(SectionType.BIO_SKETCHES,	tempPropId);
		
		//Facilities Equipment
		ByteArrayOutputStream fac = createPDF(SectionType.FAC_EQUP,	tempPropId);
				
				
		//add Proposal Sections to the list
		baosList.add(projsumm);
		baosList.add(refcited);
		baosList.add(bs);
		baosList.add(fac);

		//Concatenate PDF
		baos = concatentePDF(baosList);

		return baos;

	}

	
	

	private ByteArrayOutputStream generateProjectSummaryPDF(String tempPropId) {

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		GetProposalResponse proposal = proposalDataServiceClient
				.getProposal(tempPropId);

		String filepath = proposal.getProposal().getProposalSections()
				.getProjectSummary().getFilePath();
		System.out.println("ITextPDFServiceImpl.generateProjectSummaryPDF()..Filepath="+filepath);

		// If file path is not empty , then read PDF from NFS mount
		if (filepath != null) {
			filepath = NFS_MOUNT + filepath;
			outputStream = getPdfFromNfsMount(filepath);
			return outputStream;
		}

		// Read the text from database and generate PDF
		// Project Summary template
		Document document = new Document(PageSize.A4, 72, 72, 72, 72);

		Paragraph overViewParagraph = null;
		Paragraph brodrImptParagraph = null;
		Paragraph intulMeritParagraph = null;
		Paragraph mainHeader = null;

		try {
			PdfWriter.getInstance(document, outputStream);

			document.open();

			// Proposal section Title format
			mainHeader = new Paragraph("PROJECT SUMMARY", getTitleFont());
			mainHeader.setAlignment(Element.ALIGN_CENTER);
			document.add(mainHeader);
			Chunk linebreak = new Chunk(new LineSeparator());
			document.add(linebreak);

			// Overview Paragraph set up
			overViewParagraph = new Paragraph("Overview :", getSectioinFont());
			document.add(overViewParagraph);
			document.add(new Paragraph(proposal.getProposal()
					.getProposalSections().getProjectSummary()
					.getProjSummaryText(), getTextFont()));

			// BrodrImpt Paragraph set up
			brodrImptParagraph = new Paragraph("Broader Impacts :",
					getSectioinFont());
			document.add(brodrImptParagraph);
			document.add(new Paragraph(proposal.getProposal()
					.getProposalSections().getProjectSummary()
					.getBroaderImpacts(), getTextFont()));

			// IntulMerit Paragraph set up
			intulMeritParagraph = new Paragraph("Intellectual Merit :",
					getSectioinFont());
			document.add(intulMeritParagraph);
			document.add(new Paragraph(proposal.getProposal()
					.getProposalSections().getProjectSummary()
					.getIntellectualMerit(), getTextFont()));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			document.close();
		}
		return outputStream;

	}

	private ByteArrayOutputStream generateRefCitedPDF(String tempPropId) {
		System.out.println("ITextPDFServiceImpl.generateRefCitedPDF()");

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		GetProposalResponse proposal = proposalDataServiceClient
				.getProposal(tempPropId);

		String filepath = null;

		filepath = proposal.getProposal().getProposalSections()
				.getReferencesCited().getFilePath();
		System.out.println("ITextPDFServiceImpl.generateRefCitedPDF()..filepath"+filepath);

		// If file path is not empty , then read PDF from NFS mount
		if (filepath != null) {
			filepath = NFS_MOUNT + filepath;
			outputStream = getPdfFromNfsMount(filepath);

			return outputStream;
		}

		// Read the text from database and generate PDF
		// Reference Cited template

		// page size
		Document document = new Document(PageSize.A4, 72, 72, 72, 72);

		Paragraph mainHeader = null;

		try {
			PdfWriter.getInstance(document, outputStream);

			document.open();

			// Proposal Section Title format
			mainHeader = new Paragraph("REFERENCES CITED", getTitleFont());
			mainHeader.setAlignment(Element.ALIGN_CENTER);
			document.add(mainHeader);
			Chunk linebreak = new Chunk(new LineSeparator());
			document.add(linebreak);

			document.add(new Paragraph(proposal.getProposal()
					.getProposalSections().getReferencesCited()
					.getRefCitedTxt(), getTextFont()));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			document.close();
		}
		return outputStream;

	}
	
	private ByteArrayOutputStream generateBiographicalSketchesPDF(String tempPropId) {
		System.out.println("ITextPDFServiceImpl.generateBiographicalSketchesPDF()");

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		GetProposalResponse proposal = proposalDataServiceClient
				.getProposal(tempPropId);
		
		String filepath = null;
		
		List<BioSketches> nrList = new ArrayList<BioSketches>();
		nrList = proposal.getProposal().getProposalSections().getBioSketches();
		
	
		List<ByteArrayOutputStream> baosList = new ArrayList<ByteArrayOutputStream>();
		for (BioSketches nr : nrList) {
			System.out.println(nr.getFilePath());
			filepath = nr.getFilePath();
			System.out
					.println("ITextPDFServiceImpl.generateBiographicalSketchesPDF()..filepath="+filepath);
			//If file path is not empty , then read PDF from NFS mount
			if (filepath != null) {	
				filepath = NFS_MOUNT +filepath;
				System.out.println("Filepath is ........"+filepath);
				baosList.add( getPdfFromNfsMount(filepath));	
				}
			
		}
		
		if(baosList.size()>0)
		{
			return concatentePDF(baosList);
		}
		
		return outputStream;
	
	}
	
	
	private ByteArrayOutputStream generateFacEquipmentPDF(String tempPropId) {
		System.out.println("ITextPDFServiceImpl.generateFacEquipmentPDF()");

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		GetProposalResponse proposal = proposalDataServiceClient
				.getProposal(tempPropId);

		String filepath = null;

		filepath = proposal.getProposal().getProposalSections()
				.getFacilitiesEquipmentResources().getFilePath();
		System.out.println("ITextPDFServiceImpl.generateFacEquipmentPDF()..filepath="+filepath);

		// If file path is not empty , then read PDF from NFS mount
		if (filepath != null) {
			filepath = NFS_MOUNT + filepath;
			System.out.println("Filepath is ........" + filepath);
			outputStream = getPdfFromNfsMount(filepath);

		}

		return outputStream;

	}
	
	
	@Override
	public ByteArrayOutputStream stampPDF(ByteArrayOutputStream srcDocStream,SectionType sectionType,String stampText) {
		PdfReader reader = null;
		PdfStamper stamper = null;
		try {
			reader = new PdfReader(srcDocStream.toByteArray());
			int n = reader.getNumberOfPages();
			System.out.println("ITextPDFServiceImpl.stampPDF() No of Pages : "+n);
			stamper = new PdfStamper(reader, srcDocStream);

			if(SectionType.PROJ_SUMM.equals(sectionType)){
				Rectangle rect = reader.getPageSize(1);
				PdfContentByte canvas = stamper.getOverContent(1);
				Phrase stampPhrase = new Phrase(stampText, new Font(FontFamily.TIMES_ROMAN, 12, 0, BaseColor.BLUE));
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, stampPhrase,rect.getLeft(72), rect.getTop(45), 0);
			}else{
				for(int i=1; i <= n;i++){
    				Rectangle rect = reader.getPageSize(i);
					PdfContentByte canvas = stamper.getOverContent(i);
					Phrase stampPhrase = new Phrase(stampText, new Font(FontFamily.TIMES_ROMAN, 12, 0, BaseColor.RED));
					ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, stampPhrase,rect.getLeft(72), rect.getBottom(30), 0);	
				}
			}

			stamper.close();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		if(SectionType.PROJ_SUMM.equals(sectionType)){
//			srcDocStream = stampOnSinglePage(srcDocStream, stampText);
//		}else{
//			srcDocStream = stampOnMultiplePages(srcDocStream, stampText);
//		}

		return srcDocStream;

	}
	
	private ByteArrayOutputStream getPdfFromNfsMount(String filepath) {

		System.out.println("ITextPDFServiceImpl.getPdfFromNfsMount()"
				+ filepath);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			File file = new File(filepath);

			byte b[] = FileCopyUtils.copyToByteArray(file);
			System.out.println("*****file length:" + b.length);

			outputStream = new ByteArrayOutputStream(b.length);

			outputStream.write(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return outputStream;
	}
	
	

	@Override
	public ByteArrayOutputStream stampPDF(ByteArrayOutputStream srcDocStream, SectionType sectionType) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private ByteArrayOutputStream concatentePDF( List<ByteArrayOutputStream> baosList) {
		System.out.println("ITextPDFServiceImpl.concatentePDF()....");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		Document document = new Document();

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
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		document.close();

		return baos;
	}
	
	
	private Font getTitleFont() {
		Font font = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD);
		return font;
	}

	private Font getSectioinFont() {
		Font font = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD);
		return font;
	}
	
	private Font getTextFont() {
		Font font = new Font(Font.FontFamily.TIMES_ROMAN, 11);
		return font;
	}
	
	

}
