package org.mail.vo;

import java.sql.Timestamp;

/**
 * Draft entity. @author MyEclipse Persistence Tools
 */

public class Draft implements java.io.Serializable {

	// Fields

	private Integer writtingid;
	private String fromAddress;
	private String toAddress;
	private Timestamp date;
	private String text;
	private String attachmentName;
	private String attachmentLink;
	private String subject;
	private Integer size;

	// Constructors

	/** default constructor */
	public Draft() {
	}

	/** minimal constructor */
	public Draft(Integer writtingid) {
		this.writtingid = writtingid;
	}

	/** full constructor */
	public Draft(Integer writtingid, String fromAddress, String toAddress, Timestamp date, String text,
			String attachmentName, String attachmentLink, String subject, Integer size) {
		this.writtingid = writtingid;
		this.fromAddress = fromAddress;
		this.toAddress = toAddress;
		this.date = date;
		this.text = text;
		this.attachmentName = attachmentName;
		this.attachmentLink = attachmentLink;
		this.subject = subject;
		this.size = size;
	}

	// Property accessors

	public Integer getWrittingid() {
		return this.writtingid;
	}

	public void setWrittingid(Integer writtingid) {
		this.writtingid = writtingid;
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

	public String getAttachmentName() {
		return this.attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
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

	public Integer getSize() {
		return this.size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

}