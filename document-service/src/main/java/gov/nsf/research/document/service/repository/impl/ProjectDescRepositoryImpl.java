package gov.nsf.research.document.service.repository.impl;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import gov.nsf.research.document.service.model.proposal.ProjectDesc;
import gov.nsf.research.document.service.repository.ProjectDescRepository;

public class ProjectDescRepositoryImpl implements ProjectDescRepository {

	private static final String PD_COLLECTION = "proj_desc";
	
	MongoTemplate mongoTemplate;
	
	public ProjectDescRepositoryImpl(MongoTemplate mongoTemplate){
		this.mongoTemplate = mongoTemplate;
	}
	
	public void insertProjDesc(ProjectDesc projDesc){
		mongoTemplate.insert(projDesc, PD_COLLECTION);		
	}
	
	public ProjectDesc getProjectDescByTempPropId(String tempPropId){
		Query query = new Query(Criteria.where("tempPropId").is(tempPropId));
		ProjectDesc pd =  mongoTemplate.findOne(query, ProjectDesc.class, PD_COLLECTION);
		return pd;
	}
}
