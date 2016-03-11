package gov.nsf.research.document.service.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.pdf.PdfReader;

import gov.nsf.research.document.service.model.SectionType;

public class PDFServicePdfBoxImpl implements PDFService {

	@Override
	public boolean validatePDFDocument(ByteArrayInputStream inputStream,
			String tempPropId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ByteArrayOutputStream createPDF(String text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ByteArrayOutputStream CreateEntireProposal(String tempPropId,
			List<ByteArrayOutputStream> outputStreamList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ByteArrayOutputStream CreateEntireProposal(Map<String, PdfReader> filesToMerge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ByteArrayOutputStream CreateEntireProposalWithBookMarks(
			Map<SectionType, ByteArrayOutputStream> filesToMerge) {
		// TODO Auto-generated method stub
		return null;
	}


}
