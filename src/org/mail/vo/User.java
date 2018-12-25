package org.mail.vo;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer userid;
	private String address;
	private String password;
	private Integer sex;
	private Integer age;
	private String username;
	private String qianming;
	private String touxiang;
	@JsonIgnore
	private Set writtingsForToid = new HashSet(0);
	@JsonIgnore
	private Set writtingsForFromid = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Integer userid, String address, String password, Integer sex, Integer age) {
		this.userid = userid;
		this.address = address;
		this.password = password;
		this.sex = sex;
		this.age = age;
	}

	/** full constructor */
	public User(Integer userid, String address, String password, Integer sex, Integer age, String username,
			String qianming, String touxiang, Set writtingsForToid, Set writtingsForFromid) {
		this.userid = userid;
		this.address = address;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.username = username;
		this.qianming = qianming;
		this.touxiang = touxiang;
		this.writtingsForToid = writtingsForToid;
		this.writtingsForFromid = writtingsForFromid;
	}

	// Property accessors

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getQianming() {
		return this.qianming;
	}

	public void setQianming(String qianming) {
		this.qianming = qianming;
	}

	public String getTouxiang() {
		return this.touxiang;
	}

	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}

	public Set getWrittingsForToid() {
		return this.writtingsForToid;
	}

	public void setWrittingsForToid(Set writtingsForToid) {
		this.writtingsForToid = writtingsForToid;
	}

	public Set getWrittingsForFromid() {
		return this.writtingsForFromid;
	}

	public void setWrittingsForFromid(Set writtingsForFromid) {
		this.writtingsForFromid = writtingsForFromid;
	}

}