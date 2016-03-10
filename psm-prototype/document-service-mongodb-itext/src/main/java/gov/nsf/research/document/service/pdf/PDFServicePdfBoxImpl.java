package gov.nsf.research.document.service.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

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

}
