package gov.nsf.psm.foundation.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import gov.nsf.psm.foundation.model.User;

@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryServiceImplTest {
    
    @Mock
    private UserRepositoryService svc = new UserRepositoryServiceImpl();
    
    private Map<String, User> users;

    @Before
    public void setUp() {
    	initUsers();
    }
    
    @Test
    public void testIsAuthorized() {

    	when(svc.isAuthorized("user1", "12345678")).thenReturn(true);
        Assert.assertTrue(svc.isAuthorized("user1", "12345678"));
        verify(svc).isAuthorized("user1", "12345678");
        
        when(svc.isAuthorized("user2", "87654321")).thenReturn(false);
        Assert.assertFalse(svc.isAuthorized("user2", "87654321"));
        verify(svc).isAuthorized("user2", "87654321");
        
    }
    
    @Test
    public void testFindByUsernamePassword() {

    	User user1 = users.values().iterator().next();
    	when(svc.findByUsernamePassword("user1", "12345678")).thenReturn(user1);
        Assert.assertTrue(svc.findByUsernamePassword("user1", "12345678").equals(user1));
        verify(svc).findByUsernamePassword("user1", "12345678");
        
        User user2 = users.values().iterator().next();
    	when(svc.findByUsernamePassword("user2", "87654321")).thenReturn(user2);
        Assert.assertTrue(svc.findByUsernamePassword("user2", "87654321").equals(user2));
        verify(svc).findByUsernamePassword("user2", "87654321");
        
    }
    
    @Test
    public void testGetUserMap() {

    	User user1 = users.get(0);
    	when(svc.getUserMap()).thenReturn(users);
        Assert.assertTrue(svc.getUserMap().equals(users));
        verify(svc).getUserMap();
        
    }
    
    private void initUsers() {
    	users = new HashMap<String, User>();
        
        User usr1 = new User("user1","12345678","ROLE_USER",true);
        User usr2 = new User("user2","87654321","ROLE_USER",false);
        
        users.put("usr1",usr1);
        users.put("usr2",usr2);
    }

}
