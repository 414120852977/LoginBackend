package com.equitas.userservice.dto;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



public class UserDTO {
	@Id
	@Column(name= "USER_ID")
	@NotEmpty(message="userId should be non empty")
	private String userId;
	@Id
	@Column(name= "APP_ID")
	@NotEmpty(message="appId should be non empty")
	private String appId;
	@NotEmpty(message="pin should be non empty")
	@Column(name= "PIN")
	private String pin;
	@NotEmpty(message="userName should be non empty")
	@Column(name= "USERNAME")
	private String userName;
	
	@Column(name= "LOGINSTATUS")
	private String loginStatus;
	@NotEmpty(message="userAdd1 should be non empty")
	private String userAdd1;
	@NotEmpty(message="userAdd2 should be non empty")
	private String userAdd2;
	@NotEmpty(message="userAdd3 should be non empty")
	private String userAdd3;
	@NotEmpty(message="userAdd4 should be non empty")
	private String userAdd4;
	@NotEmpty(message="userEml1 should be non empty")
	private String userEml1;
	
	private String userEml2;
	@NotEmpty(message="userPhone1 should be non empty")
	private String userPhone1;
	private String userPhone2;
	private String profilePic;
	private boolean isVerified;
	private String password;
	public String getUserId() {
		return userId;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	public String getUserAdd1() {
		return userAdd1;
	}
	public void setUserAdd1(String userAdd1) {
		this.userAdd1 = userAdd1;
	}
	public String getUserAdd2() {
		return userAdd2;
	}
	public void setUserAdd2(String userAdd2) {
		this.userAdd2 = userAdd2;
	}
	public String getUserAdd3() {
		return userAdd3;
	}
	public void setUserAdd3(String userAdd3) {
		this.userAdd3 = userAdd3;
	}
	public String getUserAdd4() {
		return userAdd4;
	}
	public void setUserAdd4(String userAdd4) {
		this.userAdd4 = userAdd4;
	}
	public String getUserEml1() {
		return userEml1;
	}
	public void setUserEml1(String userEml1) {
		this.userEml1 = userEml1;
	}
	public String getUserEml2() {
		return userEml2;
	}
	public void setUserEml2(String userEml2) {
		this.userEml2 = userEml2;
	}
	public String getUserPhone1() {
		return userPhone1;
	}
	public void setUserPhone1(String userPhone1) {
		this.userPhone1 = userPhone1;
	}
	public String getUserPhone2() {
		return userPhone2;
	}
	public void setUserPhone2(String userPhone2) {
		this.userPhone2 = userPhone2;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", appId=" + appId + ", pin=" + pin + ", userName=" + userName
				+ ", loginStatus=" + loginStatus + ", userAdd1=" + userAdd1 + ", userAdd2=" + userAdd2 + ", userAdd3="
				+ userAdd3 + ", userAdd4=" + userAdd4 + ", userEml1=" + userEml1 + ", userEml2=" + userEml2
				+ ", userPhone1=" + userPhone1 + ", userPhone2=" + userPhone2 + ", profilePic=" + profilePic
				+ ", isVerified=" + isVerified + ", password=" + password + "]";
	}


	
	
//	public ArrayList<UserRole> userRole = new ArrayList();
}
