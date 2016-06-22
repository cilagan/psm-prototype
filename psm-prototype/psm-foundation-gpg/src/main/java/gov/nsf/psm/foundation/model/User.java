package gov.nsf.psm.foundation.model;

import javax.xml.bind.annotation.XmlAttribute;

import org.apache.commons.lang.builder.ToStringBuilder;

public class User extends AbstractTransferObject {
	
  private static final long serialVersionUID = -1591715666837394029L;
  
  @XmlAttribute
  private boolean isEnabled;
  
  private String username;
  
  private String password;
  private String role;
  
  public User(){}
  
  public User(String username, String password, String role, boolean isEnabled) {
    this.username = username;
    this.password = password;
    this.role = role;
    this.isEnabled = isEnabled;
  }
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getRole() {
	return role;
  }
  public void setRole(String role) {
	this.role = role;
  }
  
  public boolean getIsEnabled() {
	return isEnabled;
  }

  public void setIsEnabled(boolean isEnabled) {
	 this.isEnabled = isEnabled;
  }
  
  public String toString() {
      return new ToStringBuilder(this)
              .append("username",username)
              .append("passsword", password)
              .append("role", role)
              .append("isEnabled", isEnabled)
              .toString();
  }

}
