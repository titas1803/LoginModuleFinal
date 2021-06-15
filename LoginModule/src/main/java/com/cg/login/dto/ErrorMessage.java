package com.cg.login.dto;

import java.util.List;

public class ErrorMessage {
	private String status;
	private String msg;
	private List<String> messages;
	public ErrorMessage(String status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}
	
	public ErrorMessage(String status, List<String> messages) {
		super();
		this.status = status;
		this.messages = messages;
	}

	
	public List<String> getMessages() {
		return messages;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
