package org.mail.vo;

/**
 * Receive entity. @author MyEclipse Persistence Tools
 */

public class Receive implements java.io.Serializable {

	// Fields

	private Integer receiveid;
	private String fromAddress;
	private String toAddress;
	private String sendtime;
	private Integer isread;

	// Constructors

	/** default constructor */
	public Receive() {
	}

	/** minimal constructor */
	public Receive(Integer receiveid, String sendtime, Integer isread) {
		this.receiveid = receiveid;
		this.sendtime = sendtime;
		this.isread = isread;
	}

	/** full constructor */
	public Receive(Integer receiveid, String fromAddress, String toAddress, String sendtime, Integer isread) {
		this.receiveid = receiveid;
		this.fromAddress = fromAddress;
		this.toAddress = toAddress;
		this.sendtime = sendtime;
		this.isread = isread;
	}

	// Property accessors

	public Integer getReceiveid() {
		return this.receiveid;
	}

	public void setReceiveid(Integer receiveid) {
		this.receiveid = receiveid;
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

	public String getSendtime() {
		return this.sendtime;
	}

	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

	public Integer getIsread() {
		return this.isread;
	}

	public void setIsread(Integer isread) {
		this.isread = isread;
	}

}