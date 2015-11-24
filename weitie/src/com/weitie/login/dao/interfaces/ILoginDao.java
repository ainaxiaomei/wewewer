package com.weitie.login.dao.interfaces;

import java.util.List;

import com.weitie.login.entities.LoginInfo;

public interface ILoginDao {
	public void save(LoginInfo bean);
	public  List<?> get(String colum,String value,String entityName);
}
