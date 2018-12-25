package org.mail.vo;

/**
 * Friend entity. @author MyEclipse Persistence Tools
 */

public class Friend implements java.io.Serializable {

	// Fields

	private Integer friendid;
	private String friendAddress;
	private String friendName;
	private String userAddress;

	// Constructors

	/** default constructor */
	public Friend() {
	}

	/** minimal constructor */
	public Friend(Integer friendid, String friendAddress) {
		this.friendid = friendid;
		this.friendAddress = friendAddress;
	}

	/** full constructor */
	public Friend(Integer friendid, String friendAddress, String friendName, String userAddress) {
		this.friendid = friendid;
		this.friendAddress = friendAddress;
		this.friendName = friendName;
		this.userAddress = userAddress;
	}

	// Property accessors

	public Integer getFriendid() {
		return this.friendid;
	}

	public void setFriendid(Integer friendid) {
		this.friendid = friendid;
	}

	public String getFriendAddress() {
		return this.friendAddress;
	}

	public void setFriendAddress(String friendAddress) {
		this.friendAddress = friendAddress;
	}

	public String getFriendName() {
		return this.friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

}