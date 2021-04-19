package jerin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Pi extends HttpServlet {
	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement preparedStatement;

	public static void connect() throws SQLException {

		System.out.println("Connecting..");
		String url = "jdbc:mysql://localhost:3306/mymusic";
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
	} // disconnect

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String sector = req.getParameter("sector");
		String currency = req.getParameter("currency");
		String revE = req.getParameter("revE");
		String name = null;
		int annualSales = Integer.parseInt(req.getParameter("1.3"));
		int insCost = Integer.parseInt(req.getParameter("2.1"));
		int incidents = Integer.parseInt(req.getParameter("2.2"));
//		try {
////			connect();
////			String queryString = "select * from music_album where id =?";
////			preparedStatement = connection.prepareStatement(queryString);
////			preparedStatement.setString(1, "a20");
////	        ResultSet rs = preparedStatement.executeQuery();
////	        if(rs.next())
////	    	System.out.println(name=rs.getString(2)); 
////	        disconnect();
//	            
//	        
////		} catch (SQLException e) {
//			// TODO Auto-generated catch block
////			e.printStackTrace();
//		}
		
		int vehicles = Integer.parseInt(req.getParameter("2.3"));
		int distance = Integer.parseInt(req.getParameter("2.4"));
		int fleetInsPreAnnual = Integer.parseInt(req.getParameter("2.5"));
		int premiumPerVe = fleetInsPreAnnual/vehicles;
		int excessPC = Integer.parseInt(req.getParameter("2.7"));

//		int i = Integer.parseInt(req.getParameter("annualSales"));

		PrintWriter out = res.getWriter();
		out.println("<HTML>\n" + "<HEAD> </HEAD>\n" + "<BODY>\n" + "<H2> NRSPP Calculator </H2>\n" +

				"<p> Hi, this is the first version of National Road Safety Partnership "
				+ " Program accident cost calculator. The style sheet is pretty basic and"
				+ " a final version will be added later.		        </p>" + "The sector you are in " + sector
				+ " </br>" + "Your chosen currency is " + currency + "</br>" + "And your main revenue earner is " + revE +" "+name
				+ "</br>" 
//				"The annual sale you entered "+annualSales + "</br>" +
//				"The total insurers cost is "+ insCost+ "</br>" +
//				"The total incidents "+ incidents+ "</br>" +
//				"The total vehicles "+ vehicles + "</br>" +
//				"The total distance covered  "+ distance+


				);
		out.println("\nThe sector you are in "+sector +" </br>");
		out.println("\nAnd your main revenue earner is "+revE);
		out.println("\nThe annual sale you entered "+annualSales);
		out.println("\nThe total insurers cost is "+ insCost);
		out.println("\nThe total incidents "+ incidents);
		out.println("\nThe total vehicles "+ vehicles);
		out.println("\nThe total distance covered  "+ distance);
		out.println("\nThe Fleets Annual insurance premium  "+ fleetInsPreAnnual);
		out.println("\nThe premium per vehicle "+ premiumPerVe);
		out.println("\nThe excess amount per claim "+ excessPC+"</BODY>\n" + "</HTML>");
		
		 
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
