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
package co.aurasphere.courseware.java.hibernate.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import co.aurasphere.courseware.java.hibernate.model.Film;

/**
 * Hibernate controller which gets and prints data from database. The connection
 * is configured through the <code>src/main/resources/hibernate.cfg.xml</code>
 * file. <br/>
 * <br/>
 * This example uses annotations mappings and Criteria API queries.
 * 
 * @author Donato Rimenti
 *
 */
public class Controller {

	/**
	 * Gets and prints a film with the given title from the database using
	 * Hibernate.
	 * 
	 * @param args
	 *            null
	 */
	public static void main(String[] args) {
		// The film to find.
		String filmTitle = "ACADEMY DINOSAUR";

		// Loads the configuration.
		Configuration c = new Configuration();
		c.configure("hibernate.cfg.xml");

		// Connects to the database.
		SessionFactory sf = c.buildSessionFactory();
		Session session = sf.openSession();

		// Executes a query using the Criteria API.
		Film film = (Film) session.createCriteria(Film.class).add(Restrictions.eq("title", filmTitle)).uniqueResult();

		// Closes the session. If this isn't done, the program will not
		// terminate.
		session.close();
		sf.close();

		// Prints the list of films.
		System.out.println(film);
	}

}