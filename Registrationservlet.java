package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registrationservlet
 */
@WebServlet("/Registrationservlet")
public class Registrationservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registrationservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String Name=request.getParameter("nm");
		 String Email=request.getParameter("em");
		 String Username=request.getParameter("un");
		 String Address=request.getParameter("add");
		 String Contact=request.getParameter("cont");
		 String Password=request.getParameter("pw");
		response.setContentType("text/html"); 
		try {
			Class.forName("oracle.jdbc.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","12345678");
				//Statement st=con.createStatement();
				
				PreparedStatement st=con.prepareStatement("insert into studs values(?,?,?,?,?,?)");	
				st.setString(1, Name);
				st.setString(2, Email);
				st.setString(3, Username);
				st.setString(4, Address);
				st.setString(5, Contact);
				st.setString(6, Password);
				
				int ex=st.executeUpdate();
				if(ex!=0) 
				{
					response.sendRedirect("Login.html"); 
					
	}
	con.close();
	}
	catch (Exception e) 
	{
		System.out.println(e);
	}
		out.close();
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String Name=request.getParameter("nm");
		 String Email=request.getParameter("em");
		 String Username=request.getParameter("un");
		 String Address=request.getParameter("add");
		 String Contact=request.getParameter("cont");
		 String Password=request.getParameter("pw");
		response.setContentType("text/html"); 
		try {
			Class.forName("oracle.jdbc.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","12345678");
				//Statement st=con.createStatement();
				
				PreparedStatement st=con.prepareStatement("insert into stud values(?,?,?,?,?,?)");	
				st.setString(1, Name);
				st.setString(2, Email);
				st.setString(3, Username);
				st.setString(4, Address);
				st.setString(5, Contact);
				st.setString(6, Password);
				
				int ex=st.executeUpdate();
				if(ex!=0) 
				{
					response.sendRedirect("Login.html"); 
	}
	con.close();
	}
	catch (Exception e) 
	{
		System.out.println(e);
	}
		out.close();
	}
}

	




