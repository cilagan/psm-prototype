package gov.nsf.research.document.service.repository.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;

import gov.nsf.research.document.service.model.proposal.ProjectDesc;
import gov.nsf.research.document.service.repository.ProjectDescRepository;

public class ProjectDescRepositoryImpl implements ProjectDescRepository {

	private static final String PD_COLLECTION = "proj_desc";
	
	MongoTemplate mongoTemplate;
	GridFsTemplate gridFsTemplate;
	
	public ProjectDescRepositoryImpl(MongoTemplate mongoTemplate, GridFsTemplate gridFsTemplate){
		this.mongoTemplate = mongoTemplate;
		this.gridFsTemplate = gridFsTemplate;
	}
	
	public void insertProjDesc(ProjectDesc projDesc){
		mongoTemplate.insert(projDesc, PD_COLLECTION);		
	}
	
	public ProjectDesc getProjectDescByTempPropId(String tempPropId){
		Query query = new Query(Criteria.where("tempPropId").is(tempPropId));
		ProjectDesc pd =  mongoTemplate.findOne(query, ProjectDesc.class, PD_COLLECTION);
		return pd;
	}
	
	public void saveProjectDescDocument(String filename){
		InputStream inputStream = null;
		DBObject metaData = new BasicDBObject();
		
		try {
			inputStream = new FileInputStream("C:\\Apps\\mongo.pdf");
			metaData.put("length", "dummy");
			metaData.put("pages", "6");
			GridFSFile gfsFile = gridFsTemplate.store(inputStream, filename , "application/pdf", metaData);
			
			System.out.println(gfsFile.getId());
			System.out.println(gfsFile.getChunkSize());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public ByteArrayOutputStream getProjDescDocument(){
		//Query query = new Query().addCriteria(Criteria.where("length").is(new Long(1870557)));
		Query query = new Query().addCriteria(Criteria.where("_id").is("565434fa02bdf28ea773816a"));
		List<GridFSDBFile> fileList = gridFsTemplate.find(query);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		int i=0;
		
		for(GridFSDBFile file : fileList){
			try {
				System.out.println(file.getFilename());
				System.out.println(file.getLength());
				System.out.println(file.getContentType());
				System.out.println(file.getMD5());
				System.out.println(file.getUploadDate());
				
				i++;
				file.writeTo("C:\\Apps\\mongo_result_" + i +".pdf");
				file.writeTo(outputStream);
				System.out.println("Output Stream: " + outputStream != null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return outputStream;
	}
			
}
