package com.seed.servlet.listener;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.seed.util.ConnectionUtil;

/**
 * Application Lifecycle Listener implementation class ApplicationContextListner
 *
 */
@WebListener
public class ApplicationContextListner implements ServletContextListener {


    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext context = sce.getServletContext();
		String driver = context.getInitParameter("jdbc.driverClass");
		String url = context.getInitParameter("jdbc.url");
		String username = context.getInitParameter("jdbc.username");
		String password = context.getInitParameter("jdbc.password");
		
		Connection con = ConnectionUtil.getConnection(driver, url, username, password);
		context.setAttribute("connection", con);
    }
	
}
