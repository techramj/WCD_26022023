package com.seed.servlet.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FilterA
 */
@WebFilter("*")
public class FilterA extends HttpFilter implements Filter {
       

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println(getClass().getName());
		HttpServletRequest req = (HttpServletRequest) request;
		System.out.println("Servlet path: "+req.getServletPath());
		
		if(!(req.getServletPath().equals("/index.jsp") || req.getServletPath().equals("/login"))) {
			HttpSession session = req.getSession(false);
			if(session == null || session.getAttribute("username") == null) {
				((HttpServletResponse)response).sendRedirect("index.jsp");
			}else {
				chain.doFilter(request, response);
			}
		}else {
			chain.doFilter(request, response);
		}
		
	}


}
