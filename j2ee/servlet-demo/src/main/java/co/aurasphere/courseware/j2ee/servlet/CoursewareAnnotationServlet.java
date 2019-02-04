/*
 * MIT License
 *
 * Copyright (c) 2018 Donato Rimenti
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package co.aurasphere.courseware.j2ee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Simple servlet which handles HTTP GET and POST methods. The server is
 * registered under the <code>/courseware</code> path using annotations instead
 * of the deployment descriptor.
 * 
 * @author Donato Rimenti
 * 
 */
@WebServlet("/courseware")
public class CoursewareAnnotationServlet extends HttpServlet {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Gets the first query parameter.
		String firstParameterName = null;
		String firstParameterValue = null;
		String queryString = req.getQueryString();
		if (queryString != null) {
			String[] firstParameter = queryString.split("=");
			if (firstParameter.length > 1) {
				firstParameterName = firstParameter[0];
				firstParameterValue = firstParameter[1];
			}
		}

		// Prints the response.
		PrintWriter out = resp.getWriter();
		out.append("<head><title>Courseware</title></head>");
		out.append("<body><h1>GET received!</h1>");

		// Prints a custom message if there's any parameter in the query string.
		if (firstParameterValue != null) {
			out.append("<p>Also received a parameter named " + firstParameterName + " with value " + firstParameterValue
					+ "</p>");
		} else {
			out.append("<p>Try sending a parameter in the query string (e.g. append ?myPar=10 to the URL)</p>");
		}

		// Closes the HTML.
		out.append("</body></html>");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Sets the content type of the response.
		resp.setContentType("text/html");

		// Sets an header on the response with the same value of the one in
		// the request.
		String header = req.getHeader("User-Agent");
		resp.addHeader("User-Agent", header);

		// Prints the response.
		PrintWriter out = resp.getWriter();
		out.append("<head><title>Courseware</title></head>");
		out.append("<body><h1>POST received!</h1></body></html>");
	}

}