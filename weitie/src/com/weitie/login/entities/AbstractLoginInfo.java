package com.weitie.login.entities;

/**
 * AbstractLoginInfo entity provides the base persistence definition of the
 * LoginInfo entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractLoginInfo implements java.io.Serializable {

	// Fields

	private String custId;
	private String custName;
	private String password;
	private String ext1;
	private String ext2;
	private String ext5;
	private String ext3;
	private String ext4;

	// Constructors

	/** default constructor */
	public AbstractLoginInfo() {
	}

	/** minimal constructor */
	public AbstractLoginInfo(String custId, String custName, String password) {
		this.custId = custId;
		this.custName = custName;
		this.password = password;
	}

	/** full constructor */
	public AbstractLoginInfo(String custId, String custName, String password,
			String ext1, String ext2, String ext5, String ext3, String ext4) {
		this.custId = custId;
		this.custName = custName;
		this.password = password;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.ext5 = ext5;
		this.ext3 = ext3;
		this.ext4 = ext4;
	}

	// Property accessors

	public String getCustId() {
		return this.custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getExt1() {
		return this.ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public String getExt2() {
		return this.ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}

	public String getExt5() {
		return this.ext5;
	}

	public void setExt5(String ext5) {
		this.ext5 = ext5;
	}

	public String getExt3() {
		return this.ext3;
	}

	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}

	public String getExt4() {
		return this.ext4;
	}

	public void setExt4(String ext4) {
		this.ext4 = ext4;
	}

}