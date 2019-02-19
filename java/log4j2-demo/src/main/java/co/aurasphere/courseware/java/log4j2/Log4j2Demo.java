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
package co.aurasphere.courseware.java.log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Log4j2 demo which shows how to log with different levels.
 * 
 * @author Donato Rimenti
 *
 */
public class Log4j2Demo {

	/**
	 * Gets a logger and logs at different levels. What is visible and where is
	 * printed can be configured in the log4j2.xml file.
	 * 
	 * @param args null
	 */
	public static void main(String[] args) {
		// In practice the logger is usually defined as an instance variable.
		Logger logger = LoggerFactory.getLogger(Log4j2Demo.class);

		// Logs with different levels.
		logger.trace("This is a really verbose TRACE.");
		logger.debug("Less verbose but still kinda annoying, this is DEBUG.");
		logger.info("This is just a regular INFO.");
		logger.warn("Pay attention, this is a WARN.");
		logger.error("Watch out, this is an ERROR.");
	}
}