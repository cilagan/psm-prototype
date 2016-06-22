package gov.nsf.psm.foundation.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import gov.nsf.psm.foundation.service.UserRepositoryServiceHelper;
import gov.nsf.psm.foundation.model.User;

@Service("userRepositoryService")
public class UserRepositoryServiceImpl implements UserRepositoryService {

	public User findByUsernamePassword(String username, String password) {
		UserRepositoryServiceHelper helper = new UserRepositoryServiceHelper();
		User user = helper.getUser(username, password);
		return user;
	}
	
	public Boolean isAuthorized(String username, String password) {
		UserRepositoryServiceHelper helper = new UserRepositoryServiceHelper();
		return helper.isAuthorized(username, password);
	}
	
	public Map<String,User> getUserMap() {
		UserRepositoryServiceHelper helper = new UserRepositoryServiceHelper();
		return helper.getUserMap();
	}

}
