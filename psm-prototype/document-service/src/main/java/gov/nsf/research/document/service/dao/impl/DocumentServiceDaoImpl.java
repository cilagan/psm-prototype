package gov.nsf.research.document.service.dao.impl;

import gov.nsf.research.document.service.dao.DocumentServiceDao;
import gov.nsf.research.document.service.model.Document;
import gov.nsf.research.document.service.model.DocumentMetaData;
import gov.nsf.research.document.service.model.SectionType;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
		
		Query query = new Query().addCriteria(Criteria.where("filename")
				.is(tempPropId).and("metadata.sectionType").is(sectionType));
		List<GridFSDBFile> fileList = gridFsTemplate.find(query);

		if (fileList.size() > 0) {
			deleteDocument(tempPropId, sectionType);
			System.out.println("Found one document and deleted from DB:"
					+ query.toString());
		}

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
		
		for(GridFSDBFile file : fileList){
			try {			
					file.writeTo(outputStream);
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
		
		List<SectionType> listOfDocs = new ArrayList<SectionType>();
		
		listOfDocs.add(SectionType.DATA_MANAGEMENT_PLAN);
		listOfDocs.add(SectionType.PROJECT_DESCRIPTION);		

		Query query = new Query().addCriteria(Criteria.where("metadata.sectionType").in(listOfDocs));
		
		List<GridFSDBFile> fileList = gridFsTemplate.find(query);

		Document doc = null;
		List<Document> list = new ArrayList<Document>();
		
		for (GridFSDBFile file : fileList) {

			doc = new Document(file.getFilename(), SectionType.valueOf(file.getMetaData().get("sectionType").toString()));
			list.add(doc);

		}
		return list;
	}

	@Override
	public void deleteDocument(String tempPropId, SectionType sectionType) {
		Query query = new Query().addCriteria(Criteria.where("filename").is(tempPropId).and("metadata.sectionType").is(sectionType));
		System.out.println("DAO...deleteDocument..query:"+query.toString());
				
		gridFsTemplate.delete(query);
	}	
}
