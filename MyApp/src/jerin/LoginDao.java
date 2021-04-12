package jerin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginDao extends HttpServlet {

	static ServletContext context;
	static String fname;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		context = getServletContext();
		context.setAttribute("name",fname); 
		request.setAttribute("sharedId", fname); // add to request
	    request.getSession().setAttribute("sharedId", fname); // add to session
	    this.getServletConfig().getServletContext().setAttribute("sharedId", fname); // add to application context
	    request.getRequestDispatcher("/login").forward(request, response);

	}

	public static boolean validate(String name, String pass) {
		boolean status = false;
		try {
			String url = "jdbc:mysql://localhost:3306/nrspp";
			String user = "root";
			String password = "root";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
//	statement = con.createStatement();

			PreparedStatement ps = con.prepareStatement(" Select * from users where email =? and pword=? ");
			ps.setString(1, name);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();
			status = rs.next();
			fname = rs.getString(2);

			System.out.println(fname);
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
//public static void main (String [] args)
//{
////	System.out.println(validate(null, null));
//}
}