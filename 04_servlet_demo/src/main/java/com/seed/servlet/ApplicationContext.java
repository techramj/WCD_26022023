package com.seed.servlet;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.seed.util.ConnectionUtil;

public class ApplicationContext implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContextListener.super.contextInitialized(sce);
		System.out.println("contextInitialized");
		ServletContext context = sce.getServletContext();
		String driver = context.getInitParameter("jdbc.driverClass");
		String url = context.getInitParameter("jdbc.url");
		String username = context.getInitParameter("jdbc.username");
		String password = context.getInitParameter("jdbc.password");
		
		Connection con = ConnectionUtil.getConnection(driver, url, username, password);
		context.setAttribute("connection", con);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContextListener.super.contextDestroyed(sce);
		System.out.println("contextDestroyed");
	}

}
