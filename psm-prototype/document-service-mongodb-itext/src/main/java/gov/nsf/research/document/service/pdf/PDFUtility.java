package gov.nsf.research.document.service.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.FilteredTextRenderListener;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.RegionTextRenderFilter;
import com.itextpdf.text.pdf.parser.RenderFilter;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;


public class PDFUtility {

	public static OutputStream concatenateDocuments(List<ByteArrayOutputStream> outputStreamList){

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		/*PDFMergerUtility pmUtility = new PDFMergerUtility();
		

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
		}*/
		//prepareBookMarksForPDF(convertToInputStream(output));
		return output;
	}

	private static ByteArrayInputStream convertToInputStream(ByteArrayOutputStream outputStream){
		return new ByteArrayInputStream(outputStream.toByteArray());
	}



	public static String printPDFMetaData(ByteArrayInputStream stream)

	{

		/*PDDocument document = null;


		try {
			document = PDDocument.load(stream);

			PDMetadata metadata = new PDMetadata(document);

			//System.out.println("**"+metadata.toString());


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				document.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally
		{
			try {
				document.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		return null;

	}



	public static boolean validatePDFDocument(ByteArrayInputStream stream,
			String tempPropId)

	{
		boolean isValidPDF = true;

		PdfReader reader = null;
		
		int length =0;

		try {
			reader = new PdfReader(stream);
			length = PdfTextExtractor.getTextFromPage(reader, 1).length();
			
			if( length<=1)
			{
				isValidPDF = false;
				System.out.println(" PDF Document is empty:"+length);
			}
			System.out.println("iText PDF Extractor: "
					+ PdfTextExtractor.getTextFromPage(reader, 1).length());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isValidPDF;

	}



	public static ByteArrayOutputStream createPDFDocumentFromText( String text)
	{
		//file.writeTo(outputStream);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		
		 Document document = new Document();
		 		
	        // step 2
	        try {
				PdfWriter.getInstance(document,outputStream );
			
	        // step 3
	        document.open();
	        // step 4
	        document.add(new Paragraph(text));
	        } catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       finally
	       {
	    	   document.close();
	       }
		return outputStream;
	}
}


	

	




