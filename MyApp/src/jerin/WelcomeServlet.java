package jerin;

import java.io.IOException;  
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
public class WelcomeServlet extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter(); 
    
    
          
    String n=request.getParameter("username");  
    out.print("Welcome Admin"+n);  
	out.println("<HTML>\n" + "<HEAD> </HEAD>\n" + "<BODY>\n" + "<H2> NRSPP Calculator </H2>\n" +

			"<p> Hi, this is the first version of National Road Safety Partnership "+
			"<h> We inted to display previous results saved in the database "+



			"</BODY>\n" + "</HTML>");
          
    out.close();  
}
}
