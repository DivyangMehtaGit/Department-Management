package com.learn.dto;

public class SuccessResponseDTO {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "SuccessResponseDTO [message=" + message + "]";
	}

	public SuccessResponseDTO(String message) {
		super();
		this.message = message;
	}

}
