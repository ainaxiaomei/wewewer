package com.weitie.listenner;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import com.weitie.common.util.CommonUtil;

@WebListener
public class ServletContextListenner extends ContextLoaderListener {
	public static final String SESSION_FACTORY="sessionFactory";
    /**
     * Default constructor. 
     */
	public ServletContextListenner() {
		super();
	}
    public ServletContextListenner(WebApplicationContext context) {
       super(context);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         super.contextDestroyed(sce);
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	super.contextInitialized(sce);
    	ServletContext servletContext=sce.getServletContext();
    	ApplicationContext ac=(ApplicationContext)servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
    	SessionFactory sessionFactory=(SessionFactory)ac.getBean("sessionFactory");
    	//将sessionFactory保存到ServletContext中
    	if(sessionFactory!=null){
    		servletContext.setAttribute(SESSION_FACTORY, sessionFactory);
    	}else{
    		//生成sessionFactory
    		sessionFactory = new Configuration()
            .configure() // configures settings from hibernate.cfg.xml
            .buildSessionFactory();
    		servletContext.setAttribute(SESSION_FACTORY, sessionFactory);
    	}
    	//获取需要初始化的类
    	init( sessionFactory);
    	
    }
    public void init(SessionFactory sessionFactory){
    	CommonUtil.init(sessionFactory);
    }
	
}
