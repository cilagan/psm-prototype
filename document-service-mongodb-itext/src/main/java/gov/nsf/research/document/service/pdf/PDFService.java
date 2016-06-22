package gov.nsf.research.document.service.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.itextpdf.text.pdf.PdfReader;

import gov.nsf.research.document.service.model.EditorText;
import gov.nsf.research.document.service.model.PDFDocument;
import gov.nsf.research.document.service.model.SectionType;
import gov.nsf.research.document.service.model.proposal.ProjectSummary;

public interface PDFService {
	
	public PDFDocument validatePDFDocument(ByteArrayInputStream inputStream,
			String tempPropId);

	public ByteArrayOutputStream createPDF(ProjectSummary text);
	
	public ByteArrayOutputStream createProjectSummaryPDF(Set<EditorText> overView, Set<EditorText> brodImpt, Set<EditorText> intellectual );

	public ByteArrayOutputStream CreateEntireProposal(String tempPropId,
			List<ByteArrayOutputStream> outputStreamList);
			
	public ByteArrayOutputStream CreateEntireProposal(Map<String, PdfReader> filesToMerge);
	
	public ByteArrayOutputStream CreateEntireProposalWithBookMarks(Map<SectionType, ByteArrayOutputStream> filesToMerge);

	public ByteArrayOutputStream stampPDF(ByteArrayOutputStream srcDocStream, String sampText);
	
	public int pageCount( ByteArrayOutputStream baos);
}
