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

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Showcases dependency injection with Spring by retrieving an autowired bean
 * and calling a method to retrieve some data.
 * 
 * @author Donato Rimenti
 *
 */
public class Controller {

	/**
	 * Retrieves a bean with its dependency supplied from the Spring context and
	 * calls a method to test it and retrieve some data.
	 * 
	 * @param args
	 *            null
	 */
	public static void main(String[] args) {
		// Initializes the Spring context.
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

		// Retrieves a fully injected bean.
		Service service = context.getBean(Service.class);

		// Tests that the bean's dependencies have been injected by retrieving
		// some data.
		String response = service.handleRequest();
		System.out.println(response);

		// Destroys Spring context to avoid memory leaks.
		context.close();
	}

}