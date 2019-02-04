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
package co.aurasphere.courseware.java.questions.interview;

/**
 * Question: write a simple implementation of the prototype design pattern.
 * 
 * @author Donato Rimenti
 *
 */
public class PrototypePattern {

	/**
	 * Generic data of this class.
	 */
	private String data;

	/**
	 * Instantiates a new PrototypePattern.
	 */
	public PrototypePattern() {
		// Constructor which performs very expensive operations to retrieve the
		// data field.
		// this.data = veryExpensiveOperation();
	}

	/**
	 * Instantiates a new PrototypePattern.
	 *
	 * @param data
	 *            the {@link #data}
	 */
	public PrototypePattern(String data) {
		this.data = data;
	}

	/**
	 * Gets the {@link #data}.
	 *
	 * @return the {@link #data}
	 */
	public String getData() {
		return data;
	}

	/**
	 * Sets the {@link #data}.
	 *
	 * @param data
	 *            the new {@link #data}
	 */
	public void setData(String data) {
		this.data = data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	public PrototypePattern clone() {
		return new PrototypePattern(this.data);
	}

}