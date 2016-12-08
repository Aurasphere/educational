package co.aurasphere.educational.j2ee.demo.jstl.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.aurasphere.educational.j2ee.demo.jstl.model.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation.
 * 
 * @author Donato Rimenti
 */
@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Handles the HTTP POST method.
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<Person> people = new ArrayList<Person>();
		Person p1 = new Person("John", "Doe");
		Person p2 = new Person("Sally", "Housecoat");
		Person p3 = new Person("Larry", "Page");
		Person p4 = new Person("Brad", "Pitt");
		people.add(p1);
		people.add(p2);
		people.add(p3);
		people.add(p4);
		request.setAttribute("people", people);
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

}
