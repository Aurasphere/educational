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
package co.aurasphere.courseware.java.spring.context;

/**
 * Fake service class which delegates data retrieval to a fake database injected
 * by Spring.
 * 
 * @author Donato Rimenti
 * 
 */
public class Service {

	/**
	 * Represents a fake database injected by Spring.
	 */
	private Dao dao;

	/**
	 * Simulates a request handling by delegating a fake database.
	 *
	 * @return a generic message
	 */
	public String handleRequest() {
		return dao.fetchMessageFromDb();
	}

	/**
	 * Gets the {@link #dao}.
	 *
	 * @return the {@link #dao}
	 */
	public Dao getDao() {
		return dao;
	}

	/**
	 * Sets the {@link #dao}.
	 *
	 * @param dao
	 *            the new {@link #dao}
	 */
	public void setDao(Dao dao) {
		this.dao = dao;
	}

}