/*
 * MIT License
 *
 * Copyright (c) 2019 Donato Rimenti
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
package co.aurasphere.courseware.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC demo which connects to a MySQL instance with the given parameters and
 * prints the titles of all the films available on the Sakila DB.
 * 
 * This program needs an underlying MySQL database server to be executed.
 * 
 * @author Donato Rimenti
 *
 */
public class JdbcDemo {

	/**
	 * Database host.
	 */
	private final static String DB_HOST = "localhost";

	/**
	 * Database port.
	 */
	private final static String DB_PORT = "3306";

	/**
	 * Database name (Sakila is a sample MySQL DB present by default).
	 */
	private final static String DB_NAME = "sakila";

	/**
	 * Database username.
	 */
	private final static String DB_USER = "root";

	/**
	 * Database password.
	 */
	private final static String DB_PASS = "admin";

	/**
	 * Connects to a MySQL instance with the given configuration parameters and
	 * prints the titles of all the movie available on the Sakila DB.
	 * 
	 * @param args
	 *            null
	 * @throws SQLException
	 *             if a DB connection could not be established
	 */
	public static void main(String[] args) throws SQLException {
		// Connects to the database.
		String jdbcString = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;
		Connection connection = DriverManager.getConnection(jdbcString, DB_USER, DB_PASS);

		// Executes the query.
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM FILM");

		// Prints the results.
		while (resultSet.next()) {
			String title = resultSet.getString("title");
			System.out.println(title);
		}
	}

}