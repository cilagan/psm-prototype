package gov.nsf.psm.foundation.service;

import java.util.Map;

import gov.nsf.psm.foundation.model.User;

public interface UserRepositoryService {
	Boolean isAuthorized(String username, String password);
    User findByUsernamePassword(String username, String password);
    Map<String,User> getUserMap();
}