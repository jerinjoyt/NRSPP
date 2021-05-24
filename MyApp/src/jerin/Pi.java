package jerin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Pi extends HttpServlet {
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
//		
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
	} // disconnect

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException 
	{
		try {
			String sector = req.getParameter("sector");
			int profit = Integer.parseInt(req.getParameter("2.10"));
			int directCost = Integer.parseInt(req.getParameter("3.4"));
			int indirectC = Integer.parseInt(req.getParameter("3.7"));
			int mfCost = Integer.parseInt(req.getParameter("3.10"));
			int avCost = Integer.parseInt(req.getParameter("3.13"));
			connect();
			System.out.println(sector+profit+" "+directCost+" "+indirectC+" "+mfCost);
			String query = "insert into report values ('"+sector+"', "+profit+", "+directCost+", "+indirectC+", "
					+mfCost+", "+avCost+")"; 
			int i =statement.executeUpdate(query);
			if(i>0)
			{
				PrintWriter out = res.getWriter();
				out.println("<HTML>\n" + "<HEAD> </HEAD>\n" + "<BODY>\n" + "<H2> NRSPP Calculator </H2>\n" +

						"<p> Hi, this is the first version of National Road Safety Partnership "
						+ " Program accident cost calculator. The style sheet is pretty basic and"
						+ " a final version will be added later.		        </p>" + "The sector you are in " + sector
						+ "</br>" 
						);
				out.println("<p> <B> Succesfully inserted the values into the database for future reference</B></p> </BODY>\n" + "</HTML>");
			}
			} 
		catch (Exception e) 
		{
			
			System.out.println(" \n"+e.getMessage());

			PrintWriter out = res.getWriter();
			out.println("<HTML>\n" + "<HEAD> </HEAD>\n" + "<BODY>\n" + "<H2> NRSPP Calculator </H2>\n" );
			out.println("<H2><B> An Error occured while trying to save your result to the database."
					+ " Please check you have entered all the values </B></H2>"
					+ "Cause: "+e.toString()
					+ " </BODY>\n" + "</HTML>");
		
		}
		
		
		 
		System.out.println("We got the number you entered " + "annualSales");
		
        
        
	}
	public static void main (String [] args)
	{
		try {
			connect();
			String queryString = "select * from music_album where id = ?";
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setString(1, "a20");
	        ResultSet rs = preparedStatement.executeQuery();
	        if(rs.next())
	        System.out.println(rs.getString(2));
	        disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
