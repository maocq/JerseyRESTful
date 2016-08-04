package com.maocq.restful.exceptions;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	private String message;

	public Message() {
	}

	public Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
