package gov.nsf.research.document.service.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.util.PDFMergerUtility;

public class PDFUtility {

	public static OutputStream concatenateDocuments(List<ByteArrayOutputStream> outputStreamList){
		
		PDFMergerUtility pmUtility = new PDFMergerUtility();
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		pmUtility.setDestinationStream(output);
		
		for(ByteArrayOutputStream baos : outputStreamList){
			pmUtility.addSource(convertToInputStream(baos));
		}
		
		try {
			pmUtility.mergeDocuments();
		} catch (COSVisitorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}
	
	private static ByteArrayInputStream convertToInputStream(ByteArrayOutputStream outputStream){
		return new ByteArrayInputStream(outputStream.toByteArray());
	}
	
}
