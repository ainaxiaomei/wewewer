package com.weitie.common.util;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.catalina.ha.session.SessionMessage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;

public class CommonUtil {
	public static  SessionFactory sessoinFactory=null;
	public static void init(SessionFactory sessoinFactory){
		CommonUtil.sessoinFactory=sessoinFactory;
	}
	public static String generateId(Class<?> beanClass)throws Exception{
		if(sessoinFactory!=null){
			//为什么不能使用getCurrentSession?
			Session session=sessoinFactory.openSession();
			//获取主键
			//Map<String,ClassMetadata> map=CommonUtil.sessoinFactory.getAllClassMetadata();
			//ClassMetadata classMetadata=map.get(beanClass.getSimpleName());
			//String IdentityName=classMetadata.getIdentifierPropertyName();
			//为什么下面的方法无效,因为*.hbm.xml没有加package,导致类名不是全程限定名
			String IdentityName=CommonUtil.sessoinFactory.getClassMetadata(beanClass).getIdentifierPropertyName();
			String sql="SELECT max("+IdentityName+") FROM "+beanClass.getSimpleName();
			Query query=session.createQuery(sql);
			List<String> list=query.list();
			if(list!=null&&!list.isEmpty()){
				//如何更好的将string转换为long
				long id=Long.parseLong(list.get(0))+1;
				return String.valueOf(id);
			}
		}
		return "";
		
	}
}
