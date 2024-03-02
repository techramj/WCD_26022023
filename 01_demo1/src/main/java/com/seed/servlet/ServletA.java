package com.seed.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletA extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		String str = getInitParameter("a");
		System.out.println("a= "+str);
		

		ServletContext context = getServletContext();
		String j = context.getInitParameter("j");
		System.out.println("j= "+j);
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("ServetA");
	}

}
