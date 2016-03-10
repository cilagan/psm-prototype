package gov.nsf.research.document.service.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

public interface PDFService {
	
	public boolean validatePDFDocument(ByteArrayInputStream inputStream,
			String tempPropId);

	public ByteArrayOutputStream createPDF(String text);

	public ByteArrayOutputStream CreateEntireProposal(String tempPropId,
			List<ByteArrayOutputStream> outputStreamList);
			

}
