/*
* MIT License
* 
* Copyright (c) 2015 Donato Rimenti
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
package co.aurasphere.courseware.java.questions.interview;

/**
 * Question: write a program that swaps two variable without using a third
 * temporary variable.
 * 
 * @author Donato Rimenti
 *
 */
public class XorSwap {

	/**
	 * Swaps two variables using the XOR operation and then swaps them back
	 * using arithmetic without a third variable.
	 * 
	 * @param args null
	 */
	public static void main(String[] args) {
		int a = 5;
		int b = 10;

		// XOR variable swap.
		System.out.printf("Before xor swap > a: %d, b: %d \n", a, b);
		a ^= b;
		b ^= a;
		a ^= b;

		// Aithmetic variable swap.
		System.out.printf("After xor swap > a: %d, b: %d \n", a, b);
		a = a + b;
		b = a - b;
		a = a - b;

		System.out.printf("After arithmetic swap > a: %d, b: %d", a, b);
	}

}