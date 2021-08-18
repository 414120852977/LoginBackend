package com.equitas.userservice.entity;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class UserPK implements Serializable {
	private String userId;
	private String appId;
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
	public UserPK(String userId, String appId) {
		super();
		this.userId = userId;
		this.appId = appId;
	}
	public UserPK() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(appId, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserPK other = (UserPK) obj;
		return Objects.equals(appId, other.appId) && Objects.equals(userId, other.userId);
	}
	
	
}
