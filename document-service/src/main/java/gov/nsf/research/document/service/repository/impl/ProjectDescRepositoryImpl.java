package gov.nsf.research.document.service.repository.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bson.BSONObject;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;

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
	
	public void saveProjectDescDocument(){
		InputStream inputStream = null;
		DBObject metaData = new BasicDBObject();
		
		try {
			inputStream = new FileInputStream("C:\\Apps\\mongo.pdf");
			metaData.put("length", "dummy");
			metaData.put("pages", "6");
			gridFsTemplate.store(inputStream, "test.pdf", "application/pdf", metaData);
			
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
	
	public void getProjDescDocument(){
		Query query = new Query().addCriteria(Criteria.where("filename").is("test.pdf"));
		List<GridFSDBFile> fileList = gridFsTemplate.find(query);
		
		for(GridFSDBFile file : fileList){
			try {
				System.out.println(file.getFilename());
				System.out.println(file.getLength());
				System.out.println(file.getContentType());
				System.out.println(file.getMD5());
				System.out.println(file.getUploadDate());
				
				
					file.writeTo("C:\\Apps\\mongo_result.pdf");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
			
}
