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
package co.aurasphere.courseware.j2ee.axis.server;

/**
 * Simple SOAP-based Web Service server example with Apache Axis. To generate
 * the WSDL from this class, right click on this file and select Web Services ->
 * Create Web Service. From there, follow the wizard by selecting a server
 * runtime and Axis as the web service runtime and clicking on Finish. This will
 * generate the WSDL file.
 * 
 * @author Donato Rimenti
 *
 */
public class AxisSoapServerDemo {

	/**
	 * Method to greet a user.
	 * 
	 * @param name
	 *            the name of the user to greet
	 * @return a greeting to that user
	 */
	public String sayHi(String name) {
		return "Hi " + name;
	}

}