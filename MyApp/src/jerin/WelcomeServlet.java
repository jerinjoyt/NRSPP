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
		String queryString = "select * from report";
//		preparedStatement = connection.prepareStatement(queryString);
//		preparedStatement.setString(1, "a20");
		statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(queryString);
        if (rs != null) {
            // There's a ResultSet to be had
            ResultSet rs1 = statement.getResultSet();
            out.println("<html>\r\n" + 
            		"  <head>\r\n" + 
            		"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n" + 
//            		"    <link rel=\"stylesheet\" href=\"cal.css\" />\r\n" + 
            		"    <title>Welcome Admin</title>\r\n" + 
            		"  </head>"
            		+ "<BODY>");
            out.append("<P ALIGN='center'><TABLE BORDER=”1”>");
            out.append("<TABLE cellspacing=\"3\" bgcolor=\"#000000\">\n");
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
   
	out.println(
			"<p> Hi, this is the first version of National Road Safety Partnership "+
			"<h> We inted to display previous results saved in the database "+



			"</BODY>\n" + "</HTML>");
          
    out.close();  
}
}
