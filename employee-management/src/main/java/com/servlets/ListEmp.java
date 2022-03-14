package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.datacollection.EOAHelperClass;

/**
 * Servlet implementation class ListEmp
 */

@WebServlet("/list")
public class ListEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EOAHelperClass eo = new EOAHelperClass();
		response.setContentType("text/html");
		PrintWriter pr=response.getWriter();
		
		for(String s: eo.listAllEmp()) {
			pr.write("<h2>"+s+"</h2>");
		}
		pr.write("<a href=\"index.jsp\"></a>");
		
	}

}
