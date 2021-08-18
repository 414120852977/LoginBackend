package com.equitas.userservice.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity

@Table(name="UserData")
@IdClass(UserPK.class)

public class User {
	@Id
	@Column(name= "USER_ID")
	private String userId;
	@Id
	@Column(name= "APP_ID")
	private String appId;
	@Column(name= "PIN")
	private String pin;
	@Column(name= "USERNAME")
	private String userName;
	@Column(name= "LOGINSTATUS")
	private String loginStatus;
	private String userAdd1;
	private String userAdd2;
	private String userAdd3;
	private String userAdd4;
	private String userEml1;
	private String userEml2;
	private String userPhone1;
	private String userPhone2;
	private String profilePic;
	public boolean isVerified;
	private String password;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public User() {
		super();
	}
	
	public User(String userId, String appId, String pin, String userName, String loginStatus, String userAdd1,
			String userAdd2, String userAdd3, String userAdd4, String userEml1, String userEml2, String userPhone1,
			String userPhone2, String profilePic, boolean isVerified, String password) {
		super();
		this.userId = userId;
		this.appId = appId;
		this.pin = pin;
		this.userName = userName;
		this.loginStatus = loginStatus;
		this.userAdd1 = userAdd1;
		this.userAdd2 = userAdd2;
		this.userAdd3 = userAdd3;
		this.userAdd4 = userAdd4;
		this.userEml1 = userEml1;
		this.userEml2 = userEml2;
		this.userPhone1 = userPhone1;
		this.userPhone2 = userPhone2;
		this.profilePic = profilePic;
		this.isVerified = isVerified;
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", appId=" + appId + ", pin=" + pin + ", userName=" + userName
				+ ", loginStatus=" + loginStatus + ", userAdd1=" + userAdd1 + ", userAdd2=" + userAdd2 + ", userAdd3="
				+ userAdd3 + ", userAdd4=" + userAdd4 + ", userEml1=" + userEml1 + ", userEml2=" + userEml2
				+ ", userPhone1=" + userPhone1 + ", userPhone2=" + userPhone2 + ", profilePic=" + profilePic
				+ ", isVerified=" + isVerified + ", password=" + password + "]";
	}
	
	
	
	//public ArrayList<UserRole> userRole = new ArrayList();
	
	
		
}
