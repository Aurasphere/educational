/*
 * MIT License
 * 
 * Copyright (c) 2016 Donato Rimenti
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
package co.aurasphere.courseware.j2ee.jstl.model;

/**
 * Model class for Person object.
 *
 * @author Donato Rimenti
 */
public class Person {

	/**
	 * The first name.
	 */
	private String firstName;

	/**
	 * The last name.
	 */
	private String lastName;

	/**
	 * Instantiates a new Person.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 */
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Gets the {@link #firstName}.
	 *
	 * @return the {@link #firstName}
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the {@link #firstName}.
	 *
	 * @param firstName the new {@link #firstName}
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the {@link #lastName}.
	 *
	 * @return the {@link #lastName}
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the {@link #lastName}.
	 *
	 * @param lastName the new {@link #lastName}
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
