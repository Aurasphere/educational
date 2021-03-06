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
package co.aurasphere.courseware.java.questions.oca;

/**
 * Can you guess the output of this program without running it?
 * 
 * @author Donato Rimenti
 * 
 */
@SuppressWarnings("all")
public class InitializationOrder1 {

	{
		System.out.println(name);
	}

	{
		System.out.println("Second block");
	}

	static {
		System.out.println("static block");
		name = "Mark";
	}

	public static String name = "Vincent";

	{
		System.out.println("Setting a variable");
		name = "Max";
	}

	public InitializationOrder1() {
		System.out.println("Constructor" + name);
	}

	public static void main(String[] args) {
		System.out.println("Main " + name);
		System.out.println(new InitializationOrder1().name);
	}

}