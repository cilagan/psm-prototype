package gov.nsf.research.document.service.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.pdf.PdfReader;

import gov.nsf.research.document.service.model.PDFDocument;
import gov.nsf.research.document.service.model.SectionType;

public interface PDFService {
	
	public PDFDocument validatePDFDocument(ByteArrayInputStream inputStream,
			String tempPropId);

	public ByteArrayOutputStream createPDF(String text);

	public ByteArrayOutputStream CreateEntireProposal(String tempPropId,
			List<ByteArrayOutputStream> outputStreamList);
			
	public ByteArrayOutputStream CreateEntireProposal(Map<String, PdfReader> filesToMerge);
	
	public ByteArrayOutputStream CreateEntireProposalWithBookMarks(Map<SectionType, ByteArrayOutputStream> filesToMerge);

	public ByteArrayOutputStream stampPDF(ByteArrayOutputStream srcDocStream, String sampText);
}
