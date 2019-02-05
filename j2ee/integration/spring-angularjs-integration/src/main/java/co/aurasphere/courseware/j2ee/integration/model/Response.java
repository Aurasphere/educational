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
package co.aurasphere.courseware.j2ee.integration.model;

/**
 * Simple response returned from
 * {@link co.aurasphere.courseware.j2ee.integration.controller.Controller#getResponse()}.
 * 
 * @author Donato Rimenti
 *
 */
public class Response {

	/**
	 * Response message.
	 */
	private String message;

	/**
	 * Instantiates a new Response.
	 *
	 * @param message
	 *            the {@link #message}
	 */
	public Response(String message) {
		this.message = message;
	}

	/**
	 * Gets the {@link #message}.
	 *
	 * @return the {@link #message}
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the {@link #message}.
	 *
	 * @param message
	 *            the new {@link #message}
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}