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
package co.aurasphere.courseware.java.junit;

/**
 * Simple calculator with basic operations.
 * 
 * @author Donato Rimenti
 */
public class Calculator {

	/**
	 * Performs multiplication between two numbers.
	 *
	 * @param a
	 *            the first operand
	 * @param b
	 *            the second operand
	 * @return the result of the operation
	 */
	public int multiply(int a, int b) {
		return a * b;
	}

	/**
	 * Performs division between two numbers.
	 *
	 * @param a
	 *            the first operand
	 * @param b
	 *            the second operand
	 * @return the result of the operation
	 */
	public int divide(int a, int b) {
		return a / b;
	}

	/**
	 * Performs addition between two numbers.
	 *
	 * @param a
	 *            the first operand
	 * @param b
	 *            the second operand
	 * @return the result of the operation
	 */
	public int add(int a, int b) {
		return a + b;
	}

	/**
	 * Performs subtraction between two numbers.
	 *
	 * @param a
	 *            the first operand
	 * @param b
	 *            the second operand
	 * @return the result of the operation
	 */
	public int subtract(int a, int b) {
		return (a - b);
	}

}