package gov.nsf.research.document.service.pdf.impl;

import gov.nsf.research.document.service.model.SectionType;
import gov.nsf.research.document.service.pdf.PDFService;
import gov.nsf.research.psm.proposal.transfer.proposals.GetProposalResponse;
import gov.nsf.research.psm.proposal.webservice.client.ProposalDataServiceClient;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class ITextPDFServiceImpl implements PDFService {

	@Autowired
	public ProposalDataServiceClient proposalDataServiceClient;

	@Override
	public ByteArrayOutputStream CreateEntireProposalPDF(String tempPropId) {

		System.out.println("ITextPDFServiceImpl.CreateEntireProposalPDF()");

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		List<ByteArrayOutputStream> baosList = new ArrayList<ByteArrayOutputStream>();
		ByteArrayOutputStream projsumm = createPDF(SectionType.PROJ_SUMM,
				tempPropId);

		projsumm = stampPDF(projsumm, SectionType.PROJ_SUMM);

		ByteArrayOutputStream biosketches = createPDF(SectionType.BIO_SKETCHES,
				tempPropId);

		baosList.add(projsumm);
		baosList.add(biosketches);

		Map<String, PdfReader> filesToMerge = new TreeMap<String, PdfReader>();

		try {
			filesToMerge.put("01.Project Summary",
					new PdfReader(projsumm.toByteArray()));
			filesToMerge.put("02.Bio Sketches",
					new PdfReader(biosketches.toByteArray()));

		} catch (IOException e) {
			e.printStackTrace();
		}

		Map<SectionType, ByteArrayOutputStream> files = new TreeMap<SectionType, ByteArrayOutputStream>();
		files.put(SectionType.PROJ_SUMM, projsumm);
		files.put(SectionType.BIO_SKETCHES, biosketches);

		baos = CreateEntireProposalInternal(tempPropId, baosList);

		return baos;

	}

	private ByteArrayOutputStream CreateEntireProposalInternal(
			String tempPropId, List<ByteArrayOutputStream> baosList) {
		System.out
				.println("ITextPDFServiceImpl.CreateEntireProposalInternal()");
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

	@Override
	public ByteArrayOutputStream createPDF(SectionType sectionType,
			String tempPropId) {
		System.out.println("ITextPDFServiceImpl.createPDF()");

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		if (SectionType.PROJ_SUMM.equals(sectionType)) {

			baos = generateProjectSummaryPDF(tempPropId);
		} else if (SectionType.BIO_SKETCHES.equals(sectionType)) {

			baos = generateBioSketchesPDF(tempPropId);
		}

		return baos;
	}

	private ByteArrayOutputStream generateProjectSummaryPDF(String tempPropId) {

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		GetProposalResponse proposal = proposalDataServiceClient
				.getProposal(tempPropId);
		System.out.println("ITextPDFServiceImpl.generateProjectSummaryPDF()");

		if (proposal.getProposal().getProposalSections().getProjectSummary()
				.getFilePath() != null) {

			// String filepath =
			// proposal.getProposal().getProposalSections().getProjectSummary().getFilePath();
			String filepath = "C:/Users/spendyal/Desktop/ps_mathematical_symbol.pdf";
			try {
				File file = new File(filepath);

				byte b[] = FileCopyUtils.copyToByteArray(file);

				outputStream = new ByteArrayOutputStream(b.length);

				outputStream.write(b);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return outputStream;
		}

		// page size
		Document document = new Document(PageSize.A4, 50, 50, 50, 0);

		Paragraph overViewParagraph = null;
		Paragraph brodrImptParagraph = null;
		Paragraph intulMeritParagraph = null;
		Paragraph mainHeader = null;

		try {
			PdfWriter.getInstance(document, outputStream);

			document.open();

			// Proposal Sectioin Title format
			mainHeader = new Paragraph("Project Summary", getTitleFont());
			mainHeader.setAlignment(Element.ALIGN_CENTER);
			document.add(mainHeader);

			// Overview Paragraph set up
			overViewParagraph = new Paragraph("Overview :", getSectioinFont());
			document.add(overViewParagraph);
			document.add(new Paragraph(proposal.getProposal()
					.getProposalSections().getProjectSummary()
					.getProjSummaryText()));

			// BrodrImpt Paragraph set up
			brodrImptParagraph = new Paragraph("Broader Impacts :",
					getSectioinFont());
			document.add(brodrImptParagraph);
			document.add(new Paragraph(proposal.getProposal()
					.getProposalSections().getProjectSummary()
					.getBroaderImpacts()));

			// IntulMerit Paragraph set up
			intulMeritParagraph = new Paragraph("Intellectual Merit :",
					getSectioinFont());
			document.add(intulMeritParagraph);
			document.add(new Paragraph(proposal.getProposal()
					.getProposalSections().getProjectSummary()
					.getIntellectualMerit()));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			document.close();
		}
		return outputStream;

	}

	private ByteArrayOutputStream generateBioSketchesPDF(String tempPropId) {

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		GetProposalResponse proposal = proposalDataServiceClient
				.getProposal(tempPropId);

		// page size
		Document document = new Document(PageSize.A4, 50, 50, 50, 0);

		Paragraph mainHeader = null;

		try {
			PdfWriter.getInstance(document, outputStream);

			document.open();

			// Proposal Section Title format
			mainHeader = new Paragraph("BIOGRAPHICAL SKETCH", getTitleFont());
			mainHeader.setAlignment(Element.ALIGN_CENTER);
			document.add(mainHeader);

			// BioSketches Paragraph set up

			document.add(new Paragraph(proposal.getProposal()
					.getProposalSections().getBioSketches().get(0).toString()));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			document.close();
		}
		return outputStream;

	}

	private Font getTitleFont() {
		Font font = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
		return font;
	}

	private Font getSectioinFont() {
		Font font = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD);
		return font;
	}

	@Override
	public ByteArrayOutputStream stampPDF(ByteArrayOutputStream srcDocStream,
			SectionType sectionType) {
		PdfReader reader = null;
		PdfStamper stamper = null;
		String stampText = "Supplement TimeStamp .....";
		try {
			reader = new PdfReader(srcDocStream.toByteArray());
			stamper = new PdfStamper(reader, srcDocStream);

			Rectangle rect = reader.getPageSize(1);
			PdfContentByte canvas = stamper.getOverContent(1);

			// TODO: Formatting options should be standardized/read from
			// property file
			Phrase stampPhrase = new Phrase(stampText, new Font(
					FontFamily.HELVETICA, 12, 0, BaseColor.RED));
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, stampPhrase,
					rect.getLeft(35), rect.getTop(30), 0);

			stamper.close();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return srcDocStream;

	}

}
