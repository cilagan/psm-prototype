package gov.nsf.research.document.service.config;

import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;

public class GridFSConfiguration extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mongo mongo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
