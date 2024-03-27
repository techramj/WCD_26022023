package com.seed.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
public class LogTimeFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println(getClass().getName());
		long intialTime = System.currentTimeMillis();
		chain.doFilter(request, response);
		long finalTime = System.currentTimeMillis();
		long timetaken = finalTime -intialTime;
		HttpServletRequest req = (HttpServletRequest) request;
		System.out.println("Time taken to execute request:  "+ req.getRequestURL()+" = " +timetaken+" ms");

	}

}
