package gov.nsf.research.document.service.dao.impl;

import gov.nsf.research.document.service.dao.DocumentServiceDao;
import gov.nsf.research.document.service.model.Document;
import gov.nsf.research.document.service.model.DocumentMetaData;
import gov.nsf.research.document.service.model.SectionType;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;


public class DocumentServiceDaoImpl implements  DocumentServiceDao {
	
	MongoTemplate mongoTemplate;
	GridFsTemplate gridFsTemplate;
	
	private static final String CONTENT_TYPE_PDF = "application/pdf";
	
	
	
	public DocumentServiceDaoImpl(MongoTemplate mongoTemplate, GridFsTemplate gridFsTemplate){
		this.mongoTemplate = mongoTemplate;
		this.gridFsTemplate = gridFsTemplate;
	}
	
	

	@Override
	public DocumentMetaData saveDocument(InputStream inputStream,
			String tempPropId, SectionType sectionType) {

		DBObject metaData = new BasicDBObject();
						
		metaData.put("sectionType", sectionType.toString());
		GridFSFile gridFSfile = gridFsTemplate.store(inputStream, tempPropId,
				CONTENT_TYPE_PDF, metaData);
		System.out.println("Document saved in mongoDB.");
		return setDocmentMetaData(gridFSfile);

	}

	@Override
	public ByteArrayOutputStream viewDocument(String tempPropId, SectionType sectionType) {
		Query query = new Query().addCriteria(Criteria.where("filename").is(tempPropId).and("metadata.sectionType").is(sectionType));
		System.out.println("DAO...Viewdocument..query:"+query.toString());
		List<GridFSDBFile> fileList = gridFsTemplate.find(query);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		int i=0;
		
		for(GridFSDBFile file : fileList){
			try {
								
				i++;				
				file.writeTo(outputStream);
				
				//file.writeTo("C:\\Users\\spendyal\\Desktop\\psm_test_output_files\\"+file.getFilename()+"_"+file.getMetaData().get("sectionType")+"_"+i+".pdf");
				System.out.println("Output Stream: " + outputStream != null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return outputStream;
	}
	

	
	
	private DocumentMetaData setDocmentMetaData(GridFSFile gridFSfile)
	{
		DocumentMetaData documentMetaData = new DocumentMetaData();	
		documentMetaData.setContentType(gridFSfile.getContentType());
		documentMetaData.setFileName(gridFSfile.getFilename());
		documentMetaData.setLength(gridFSfile.getLength());
		documentMetaData.setUploadDate(gridFSfile.getUploadDate());
		documentMetaData.setMD5(gridFSfile.getMD5());
		
		System.out.println("Metadata: " + documentMetaData.toString());
		
		return documentMetaData;
		
		
	}



	@Override
	public List<Document> viewAllFilesFromDB() {
		
		List<GridFSDBFile> fileList = gridFsTemplate.find(null);

		Document doc = null;
		List<Document> list = new ArrayList<Document>();

		for (GridFSDBFile file : fileList) {

			doc = new Document(file.getFilename(), SectionType.valueOf(file
					.getMetaData().get("sectionType").toString()));
			list.add(doc);

		}

		return list;
	}

	

	
			
}
