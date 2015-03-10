package com.weitie.login.entities;

/**
 * LoginInfo entity. @author MyEclipse Persistence Tools
 */
public class LoginInfo extends AbstractLoginInfo implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public LoginInfo() {
	}

	/** minimal constructor */
	public LoginInfo(String custId, String custName, String password) {
		super(custId, custName, password);
	}

	/** full constructor */
	public LoginInfo(String custId, String custName, String password,
			String ext1, String ext2, String ext5, String ext3, String ext4) {
		super(custId, custName, password, ext1, ext2, ext5, ext3, ext4);
	}

}
