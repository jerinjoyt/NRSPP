package jerin;

import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;


  
public class WelcomeServlet extends HttpServlet {  
	
	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement preparedStatement;

	public static void connect() throws SQLException {

		System.out.println("Connecting..");
		String url = "jdbc:mysql://localhost:3306/nrspp";
		String user = "root";
		String password = "root";
		try {
			// Register JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Trying to register..");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Trying to connect..");

		connection = DriverManager.getConnection(url, user, password);
		statement = connection.createStatement();
	} // connect

	public static void disconnect() throws SQLException {
		if (preparedStatement != null)
			preparedStatement.close();
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
		System.out.println("Disconnected");
	} 
	
public void doPost(HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter(); 
    try {
		connect();
		String queryString = "select * from report order by Sector";
//		preparedStatement = connection.prepareStatement(queryString);
//		preparedStatement.setString(1, "a20");
		statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(queryString);
        if (rs != null) {
            // There's a ResultSet to be had
            ResultSet rs1 = statement.getResultSet();
            out.println("<!DOCTYPE html>\r\n" + 
            		"<html lang=\"en\">\r\n" + 
            		"<head>\r\n" + 
            		"  <meta charset=\"UTF-8\">\r\n" + 
            		"  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
            		"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
            		"  <title>Document</title>\r\n" + 
            		"  \r\n" + 
            		"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n" + 
            		"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n" + 
            		"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\r\n" + 
            		"  <link rel=\"stylesheet\" href=\"style.css\">"+
            		"<style> "
            		+ ".centre{\r\n" + 
            		"  margin-left: auto;\r\n" + 
            		"  margin-right: auto;\r\n" + 
            		"}"
            		+ "TABLE, th, td {\r\n" + 
            		"  border: 1px solid black;\r\n" + 
            		"}\r\n" + 
            		"</style>"
            		+ "</head>\r\n" + 
            		"<body>\r\n" + 
            		"  <div class=\"container\">\r\n" + 
            		"    <div class=\"row\" style=\"margin-top:20px\">\r\n" + 
            		"      <div class=\"col-md-4\">\r\n" + 
            		"        <a href=\"index.html\">\r\n" + 
            		"          <img src=\"logo.svg\" class=\"logo\" alt=\"logo\">\r\n" + 
            		"        </a>\r\n" + 
            		"      </div>\r\n" + 
            		"      <div class=\"col-md-8\">\r\n" + 
            		"        <nav>\r\n" + 
            		"          <ul class=\"menu\">\r\n" + 
            		"            <li class=\"active l-item\" type=\"none\"><a href=\"#\">Knowledge Center</a></li>\r\n" + 
            		"            <li class=\"l-item\" type=\"none\"><a href=\"#\">Packages</a></li>\r\n" + 
            		"            <li class=\"l-item\" type=\"none\"><a href=\"#\">Partners</a></li>\r\n" + 
            		"            <li class=\"l-item\" type=\"none\"><a href=\"#\">News</a></li>\r\n" + 
            		"          </ul>\r\n" + 
            		"        </nav>\r\n" + 
            		"      </div>\r\n" + 
            		"    </div>\r\n" + 
            		"    <div class=\"row\">\r\n" + 
            		"      <div class=\"col-md-4\">\r\n" + 
            		"        <button\r\n" + 
            		"         \r\n" + 
            		"          onclick=\"document.getElementById('id01').style.display='block'\"\r\n" + 
            		"          class=\"bg-secondary border-0  btn btn-block\"\r\n" + 
            		"          data-toggle=\"modal\" data-target=\"#myModal\"\r\n" + 
            		"        >\r\n" + 
            		"          Admin\r\n" + 
            		"        </button>\r\n" + 
            		"       \r\n" + 
            		"      </div>\r\n" + 
            		"      <div class=\"col-md-4\">\r\n" + 
            		"        <button\r\n" + 
            		"       \r\n" + 
            		"        class=\"bg-secondary border-0 btn btn-block\"\r\n" + 
            		"        onClick=\"location.href= 'calc.html'\"\r\n" + 
            		"      >\r\n" + 
            		"        User\r\n" + 
            		"      </button>\r\n" + 
            		"      \r\n" + 
            		"      </div>\r\n" + 
            		"      <div class=\"col-md-4\">\r\n" + 
            		"        <button\r\n" + 
            		"       \r\n" + 
            		"        class=\"bg-secondary border-0  btn btn-block\"\r\n" + 
            		"       \r\n" + 
            		"        data-toggle=\"modal\"\r\n" + 
            		"        data-target=\"#myModal1\"\r\n" + 
            		"      >\r\n" + 
            		"        Contributing User\r\n" + 
            		"      </button>\r\n" + 
            		"      </div>\r\n" + 
            		"    </div>\r\n" + 
            		"    </div> ");
//            out.println("<html>\r\n" + 
//            		"  <head>\r\n" + 
//            		"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n" + 
////            		"    <link rel=\"stylesheet\" href=\"cal.css\" />\r\n" + 
//            		"    <title>Welcome Admin</title>\r\n" + 
//            		"  </head>"
//            		+ "<BODY>");
            out.append("<div style=\"table-align:center;\">");
            out.append("<P ALIGN='center'><TABLE BORDER=”1”>");
            out.append("<TABLE class = \"centre\" cellspacing=\"3\" bgcolor=\"#000000\">\n");
            out.append("<caption><B>Incident Cost Calculator Reuslts</B></caption>");

            ResultSetMetaData rsmd = rs.getMetaData();

            int numcols = rsmd.getColumnCount();
        
            // Title the table with the result set's column labels
            out.append("<TR bgcolor=\"#ffffff\">");
            for (int i = 1; i <= numcols; i++)
              out.append("<TH>" + rsmd.getColumnLabel(i));
            out.append("</TR>\n");

            while(rs.next()) {
              out.append("<TR bgcolor=\"#ffffff\">");  // start a new row
              for(int i = 1; i <= numcols; i++) {
                out.append("<TD>");  // start a new data element
                Object obj = rs.getObject(i);
                if (obj != null)
                  out.append(obj.toString());
                else
                  out.append("&nbsp;");
                }
              out.append("</TR>\n");
            }

            // End the table
            out.append("</TABLE>\n");
          }
          else {
            // There's a count to be had
            out.append("<B>Records Affected:</B> " + statement.getUpdateCount());
          }
        if(rs.next())
        System.out.println(rs.getString(2));
        disconnect();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    
    
          
    String n=request.getParameter("username");  
   
	out.println("<br><br>"+
			"<p style=\"text-align:center;\"> Hi Admin, in the above table, estd_tc_mf = Estimated Total cost Managed Fleet <br>"
			+ "estd_tc_av = Estimated total cost All vehicles"+
			
					"</div>"+



			"</BODY>\n" + "</HTML>");
          
    out.close();  
}
}
