package org.mail.vo;

import java.sql.Timestamp;

/**
 * SendModel entity. @author MyEclipse Persistence Tools
 */

public class SendModel implements java.io.Serializable {

	// Fields

	private Integer sendid;
	private String fromAddress;
	private String toAddress;
	private Timestamp date;
	private String text;
	private String attachmentLink;
	private String subject;
	private String attachmentName;
	private Integer size;

	// Constructors

	/** default constructor */
	public SendModel() {
	}

	/** minimal constructor */
	public SendModel(Integer sendid, Timestamp date) {
		this.sendid = sendid;
		this.date = date;
	}

	/** full constructor */
	public SendModel(Integer sendid, String fromAddress, String toAddress, Timestamp date, String text,
			String attachmentLink, String subject, String attachmentName, Integer size) {
		this.sendid = sendid;
		this.fromAddress = fromAddress;
		this.toAddress = toAddress;
		this.date = date;
		this.text = text;
		this.attachmentLink = attachmentLink;
		this.subject = subject;
		this.attachmentName = attachmentName;
		this.size = size;
	}

	// Property accessors

	public Integer getSendid() {
		return this.sendid;
	}

	public void setSendid(Integer sendid) {
		this.sendid = sendid;
	}

	public String getFromAddress() {
		return this.fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getToAddress() {
		return this.toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAttachmentLink() {
		return this.attachmentLink;
	}

	public void setAttachmentLink(String attachmentLink) {
		this.attachmentLink = attachmentLink;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAttachmentName() {
		return this.attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public Integer getSize() {
		return this.size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

}