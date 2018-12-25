package org.mail.vo;

/**
 * Writting entity. @author MyEclipse Persistence Tools
 */

public class Writting implements java.io.Serializable {

	// Fields

	private Integer idwritting;

	// Constructors

	/** default constructor */
	public Writting() {
	}

	/** full constructor */
	public Writting(Integer idwritting) {
		this.idwritting = idwritting;
	}

	// Property accessors

	public Integer getIdwritting() {
		return this.idwritting;
	}

	public void setIdwritting(Integer idwritting) {
		this.idwritting = idwritting;
	}

}