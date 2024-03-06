# project structure
	webapp
		WEB-INF
			lib
			web.xml
			
		.html, .jsp => directly access to client
		
		

		
# servlet is used to generate response at runtime

			Servlet
			  service();
			
			GenericServlet implements Servlet
			
			abstract HttpServlet extends GenericServlet
			   service();
			   doGet
			   doPost
			
			MyServlet extends HttpServlet
			mapped with the url
			
			http://localhost:9090/01_Demo1/login
			
			LoginServlet
			
			
		   <servlet>
			  	<servlet-name>abc</servlet-name>
			  	<servlet-class>com.seed.servlet.LoginServlet</servlet-class>
		   </servlet>
		  
		  <servlet-mapping>
		  	<servlet-name>abc</servlet-name>
		  	<url-pattern>/login</url-pattern>
		  </servlet-mapping>
			
			
## Lifecycle of servlet

   	instantiation <load-on-startup>
		when you make the first request -ve(by default)
		when the server deployed  +ve 0 or any positive number
   	init
   	service
   	destroy
   	
   	
## get vs post method
	

	