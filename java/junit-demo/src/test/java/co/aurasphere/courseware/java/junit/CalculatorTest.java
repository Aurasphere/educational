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

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link Calculator}. The methods of this class will be executed
 * either by running this class as jUnit test or by running a Maven build.
 * 
 * For each <code>@Test</code> annotated methods, the following methods will be
 * invoked in order:
 * 
 * <ol>
 * <li><code>@Before</code> annotated method</li>
 * <li>the current <code>@Test</code> annotated method</li>
 * <li><code>@After</code> annotated method</li>
 * </ol>
 * 
 * In contrast, <code>@Test</code> annotated methods won't necessarily preserve
 * their relative order (in fact, unit tests should be atomic and not rely on
 * their execution order).
 * 
 * @author Donato Rimenti
 *
 */
public class CalculatorTest {

	/**
	 * Object to be tested.
	 */
	private Calculator calculator;

	/**
	 * Sets up the test environment.
	 */
	@Before
	public void setup() {
		System.out.println("Setting up test environment");
		this.calculator = new Calculator();
	}

	/**
	 * Tests {@link Calculator#multiply(int, int)}.
	 */
	@Test
	public void testMultiplication() {
		System.out.println("Testing multiplication");
		int result = calculator.multiply(10, 5);
		Assert.assertEquals("Multiplication doesn't work!", 50, result);
	}

	/**
	 * Tests {@link Calculator#subtract(int, int)}.
	 */
	@Test
	public void testSubtraction() {
		System.out.println("Testing subtraction");
		int result = calculator.subtract(10, 5);
		Assert.assertEquals("Subtraction doesn't work!", 5, result);
	}

	/**
	 * Tests {@link Calculator#add(int, int)}.
	 */
	@Test
	public void testAddition() {
		System.out.println("Testing addition");
		int result = calculator.add(10, 5);
		Assert.assertEquals("Addition doesn't work!", 15, result);
	}

	/**
	 * Tests {@link Calculator#divide(int, int)}.
	 */
	@Test
	public void testDivision() {
		System.out.println("Testing division");
		int result = calculator.divide(10, 5);
		Assert.assertEquals("Division doesn't work!", 2, result);
	}

	/**
	 * Cleans up the test environment.
	 */
	@After
	public void teardown() {
		System.out.println("Cleaning up test environment");
		this.calculator = null;
	}

}