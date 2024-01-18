package com.project;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String emailID, password;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		emailID=request.getParameter("em");
		password=request.getParameter("pw"); 
		try {
			Class.forName("oracle.jdbc.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","12345678");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from stud where email='"+emailID+"'");
				while(rs.next()) {
					if((rs.getString(6)).equals(password)) {
						RequestDispatcher rd=request.getRequestDispatcher("Welcome.html");  				  
					    rd.forward(request, response);
					}
					else {
						RequestDispatcher rd=request.getRequestDispatcher("Error.html");  				  
					    rd.forward(request, response);
					}
				}
				con.close();
				
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}



