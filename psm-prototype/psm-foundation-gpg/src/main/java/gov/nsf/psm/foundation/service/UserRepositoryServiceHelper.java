package gov.nsf.psm.foundation.service;

import java.util.Map;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ImportResource;

import gov.nsf.psm.foundation.model.User;

@ImportResource("security.xml")
public class UserRepositoryServiceHelper {
	
	public UserRepositoryServiceHelper() {
		// TODO Auto-generated constructor stub
	}
	
	public User getUser(String username, String password) {
		
		AnnotationConfigApplicationContext ctx = null;
		User selectedUser = null;
		
		try {
			ctx = new AnnotationConfigApplicationContext(
	               this.getClass());
			Map<String, User> users = ctx.getBeansOfType(User.class);
			for(User user: users.values()) {
				if(user.getIsEnabled() 
					&& user.getUsername().equalsIgnoreCase(username) 
						&& user.getPassword().equals(password))
							selectedUser = user;
			}
		}
		catch(Exception e) {
			throw new RuntimeException("UserRepositoryException");
		}
		finally {
			ctx.close();
		}
		
		return selectedUser;
		
	}
	
	public Boolean isAuthorized(String username, String password) {
		return (getUser(username, password) == null?false:true);
	}
	
	public Map<String,User> getUserMap() {
		
		AnnotationConfigApplicationContext ctx = null;
		Map<String, User> users = null;
		
		try {
			ctx = new AnnotationConfigApplicationContext(
					this.getClass());
			users = ctx.getBeansOfType(User.class);
		} catch(Exception e) {
				throw new RuntimeException("UserRepositoryException");
		}
		finally {
			ctx.close();
		}
		
		return users;
		
	}
	 

}
