package com.equitas.userservice.dto;

import java.util.Objects;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserLoginDTO {
	
	
	@NotBlank(message = "password cannot be null")
	private String password;
	
	
	@NotBlank(message = "userEml1 cannot be null")
	private String userEml1;


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserEml1() {
		return userEml1;
	}


	public void setUserEml1(String userEml1) {
		this.userEml1 = userEml1;
	}


	public UserLoginDTO(@NotBlank(message = "password cannot be null") String password,
			@NotBlank(message = "userEml1 cannot be null") String userEml1) {
		super();
		this.password = password;
		this.userEml1 = userEml1;
	}


	@Override
	public String toString() {
		return "UserLoginDTO [password=" + password + ", userEml1=" + userEml1 + "]";
	}


	public UserLoginDTO() {
		super();
	}


	@Override
	public int hashCode() {
		return Objects.hash(password, userEml1);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserLoginDTO other = (UserLoginDTO) obj;
		return Objects.equals(password, other.password) && Objects.equals(userEml1, other.userEml1);
	}
	


	
}
