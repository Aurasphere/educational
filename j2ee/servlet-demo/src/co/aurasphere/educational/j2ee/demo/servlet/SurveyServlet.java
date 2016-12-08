package co.aurasphere.educational.j2ee.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation for the Survey demo.
 * 
 * @author Donato Rimenti
 */
@WebServlet("/SurveyServlet")
public class SurveyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Handles the HTTP POST method.
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Prints the page.
		out.println("<?xml version = \" 1.0\"?>");
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<head><title>Servlet Demo - Thank you!</title></head>");
		out.println("<body><h1>Thank you</h1><p>Thank you for your time!</p></body></html>");

	}

}
