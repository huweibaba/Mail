package org.mail.vo;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private String username;
	private String pwdHash;
	private String pwdAlgorithm;
	private Short useForwarding;
	private String forwardDestination;
	private Short useAlias;
	private String alias;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String username) {
		this.username = username;
	}

	/** full constructor */
	public Users(String username, String pwdHash, String pwdAlgorithm, Short useForwarding, String forwardDestination,
			Short useAlias, String alias) {
		this.username = username;
		this.pwdHash = pwdHash;
		this.pwdAlgorithm = pwdAlgorithm;
		this.useForwarding = useForwarding;
		this.forwardDestination = forwardDestination;
		this.useAlias = useAlias;
		this.alias = alias;
	}

	// Property accessors

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwdHash() {
		return this.pwdHash;
	}

	public void setPwdHash(String pwdHash) {
		this.pwdHash = pwdHash;
	}

	public String getPwdAlgorithm() {
		return this.pwdAlgorithm;
	}

	public void setPwdAlgorithm(String pwdAlgorithm) {
		this.pwdAlgorithm = pwdAlgorithm;
	}

	public Short getUseForwarding() {
		return this.useForwarding;
	}

	public void setUseForwarding(Short useForwarding) {
		this.useForwarding = useForwarding;
	}

	public String getForwardDestination() {
		return this.forwardDestination;
	}

	public void setForwardDestination(String forwardDestination) {
		this.forwardDestination = forwardDestination;
	}

	public Short getUseAlias() {
		return this.useAlias;
	}

	public void setUseAlias(Short useAlias) {
		this.useAlias = useAlias;
	}

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

}