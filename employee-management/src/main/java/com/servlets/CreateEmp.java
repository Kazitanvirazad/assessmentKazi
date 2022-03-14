package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.datacollection.EOAHelperClass;
import com.datacollection.Emp;

/**
 * Servlet implementation class CreateEmp
 */
@WebServlet("create")
public class CreateEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		EOAHelperClass helper=new EOAHelperClass();
		String id=request.getParameter("id");
		int eid=Integer.parseInt(id);
		String name=request.getParameter("name");
		String city=request.getParameter("city");
		String sal=request.getParameter("sal");
		double salE=Double.parseDouble(sal);
		
		Emp emp=new Emp(eid,name,city,salE);
		String res=helper.createEmployee(emp);
		
		out.write("<h1>"+res+"</h1>");
		out.write("<h4><a href=\"index.jsp\">Home</a></h4>");
		
	}

}
