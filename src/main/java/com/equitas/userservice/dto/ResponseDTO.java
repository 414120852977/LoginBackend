package com.equitas.userservice.dto;


import java.util.Objects;

import lombok.Data;
import lombok.RequiredArgsConstructor;


public class ResponseDTO {
	
	private String message;
	private Object data;
	
	public ResponseDTO(String message, Object data) {
		this.message = message;
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseDTO [message=" + message + ", data=" + data + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, message);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponseDTO other = (ResponseDTO) obj;
		return Objects.equals(data, other.data) && Objects.equals(message, other.message);
	}

	public ResponseDTO() {
		super();
	}

	
	
}