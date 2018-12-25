package org.mail.model;

import java.util.Date;

public class ReceiveModel {
	private String subject;
	private String  fromAddress;
	private String date;
	private int size;
	private String text;
	private String attachmentLink;
	private int id;
	private String attachmentName;
	
	
	public String getAttachmentName() {
		return attachmentName;
	}
	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getFromAddress() {
		return fromAddress;
	}
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getText() {
		return text;
	}
	public void setText(String textLink) {
		this.text = textLink;
	}
	public String getAttachmentLink() {
		return attachmentLink;
	}
	public void setAttachmentLink(String attachmentLink) {
		this.attachmentLink = attachmentLink;
	}
	
	

}
