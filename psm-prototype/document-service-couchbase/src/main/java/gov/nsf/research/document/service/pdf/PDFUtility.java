package gov.nsf.research.document.service.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.apache.pdfbox.pdmodel.common.function.type4.Parser;
import org.apache.pdfbox.util.PDFMergerUtility;
import org.apache.pdfbox.util.PDFTextStripper;

import gov.nsf.research.document.service.model.DocumentMetaData;
import gov.nsf.research.document.service.model.SectionType;

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
	
	public static DocumentMetaData extractMetaData(InputStream inputStream, DocumentMetaData docMetaData){
		
		try {
			
			PDDocument document = PDDocument.load(inputStream);
			
			docMetaData.setPages(document.getNumberOfPages());
//			document.close();
//			PDFParser pdfParser = new PDFParser(inputStream);
//			pdfParser.parse();
//			
//			COSDocument cosDoc = pdfParser.getDocument();
//			PDDocument pdDoc = new PDDocument(cosDoc);
//			System.out.println(pdDoc.getNumberOfPages());
//			PDDocumentCatalog catalog = pdDoc.getDocumentCatalog();
//			PDMetadata meta = catalog.getMetadata();
			
//			PDFTextStripper pts = new PDFTextStripper();
//			pts.setStartPage(1);
//			pts.setEndPage(pdDoc.getNumberOfPages());
//			System.out.println(pts.getText(pdDoc));
//			docMetaData.setPages(pdDoc.getNumberOfPages());
//			docMetaData.setContent(pts.getText(pdDoc));
//			cosDoc.close();
//			pdDoc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return docMetaData;
	}	
}
