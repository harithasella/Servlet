package com.pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.pept.transport.Connection;

/**
 * Servlet implementation class PetServlet
 */
@WebServlet("/PetServlet")
public class PetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html"); 
		        PrintWriter pw=response.getWriter(); 
		        String fname=request.getParameter("n1"); 
		         String lname=request.getParameter("n2"); 
		        String addr=request.getParameter("add"); 
		         String mail=request.getParameter("email"); 
		          
		         String city=request.getParameter("c"); 
		         String state=request.getParameter("s"); 
		        String petname=request.getParameter("pn"); 
		        int phone=Integer.parseInt(request.getParameter("pno")); 
		        String ptype=request.getParameter("ptype");  
		        int pAge=Integer.parseInt(request.getParameter("page"));
		        pw.println(fname + lname + addr + mail + city + state + petname + phone + ptype + pAge);
		        
	          
		         
		         Connection con=null; 
		         try{ 
		             Class.forName("com.mysql.jdbc.Driver"); 
		             con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/PetRegistration", "root","root"); 
		             PreparedStatement ps=((java.sql.Connection) con).prepareStatement("insert into pet(fname,lname,addr,email,city,state,petname,phone,pettype,petage)values(?,?,?,?,?,?,?,?,?,?)"); 
		             ps.setString(1, fname); 
		             ps.setString(2, lname); 
		             ps.setString(3, addr); 
		             ps.setString(4, mail); 
		            ps.setString(5, city); 
		             ps.setString(6, state); 
		             ps.setString(7, petname); 
		             ps.setInt(8, phone); 
		            ps.setString(9, ptype); 
		            ps.setInt(10, pAge); 
		              
	              
		             int i = ps.executeUpdate(); 
		            if(i==1){ 
		                         System.out.println("firstname:"+fname); 
		                         System.out.println("lastname:"+lname); 
		                         System.out.println("address:"+addr); 
		                         System.out.println("email:"+mail); 
		                         System.out.println("city:"+city); 
		                         System.out.println("state:"+state); 
		                         System.out.println("petname:"+petname); 
		                         System.out.println("phone:"+phone); 
		                         System.out.println("pet type:"+ptype); 
		                         System.out.println("Pet Age:"+pAge); 
		                         
		             } 
		         } 
		        catch(Exception e){ 
		                         System.out.println(e); 
		         } 
		 } 
		
		 
		 	

		 
		 

	}


