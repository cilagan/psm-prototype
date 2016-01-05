package gov.nsf.research.document.service.dao.impl;

import gov.nsf.research.document.service.dao.DocumentServiceDao;
import gov.nsf.research.document.service.model.Document;
import gov.nsf.research.document.service.model.DocumentMetaData;
import gov.nsf.research.document.service.model.SectionType;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.imageio.ImageIO;

import org.springframework.data.couchbase.core.CouchbaseTemplate;

import com.couchbase.client.CouchbaseClient;


public class DocumentServiceDaoCBImpl implements  DocumentServiceDao {
	
	CouchbaseTemplate couchBaseTemplate;
	
	
	public DocumentServiceDaoCBImpl(CouchbaseTemplate couchBaseTemplate){
		this.couchBaseTemplate = couchBaseTemplate;
	}


	@Override
	public DocumentMetaData saveDocument(InputStream inputStream, String tempPropId,
			SectionType sectionType) {

		CouchbaseClient client = couchBaseTemplate.getCouchbaseClient();

		try {

			BufferedImage image = ImageIO.read(inputStream);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "JPG", baos);
			baos.flush();
			byte[] bytes = baos.toByteArray();
			baos.close();
			try {
				client.set(tempPropId, bytes).get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			

		} catch (Exception e) {
			e.toString();
		}

		return null;
	}
	

	@Override
	public ByteArrayOutputStream viewDocument(String tempPropId, SectionType sectionType) {
		
		CouchbaseClient client = couchBaseTemplate.getCouchbaseClient();
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		
		byte[] bytes = (byte[]) client.get(tempPropId);
		InputStream in = new ByteArrayInputStream(bytes);
		BufferedImage buffImage;
		try {
			buffImage = ImageIO.read(in);
			ImageIO.write(
					buffImage,
					"JPG",
					new File(
							"C:\\Users\\spendyal\\Desktop\\psm_test_input_ files\\"+tempPropId +".JPG"));
			
			ImageIO.write(
					buffImage,
					"JPG",outputStream);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return outputStream;
	}


	@Override
	public List<Document> viewAllFilesFromDB() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isDocumentExists(String tempPropId, SectionType sectionType) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void deleteDocument(String tempPropId, SectionType sectionType) {
		CouchbaseClient client = couchBaseTemplate.getCouchbaseClient();
		
			
		 client.delete(tempPropId);
		
	}	
}
