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
 * Response class for
 * {@link co.aurasphere.courseware.j2ee.integration.controller.RegistrationController#checkNameAvailable(String)}.
 * 
 * @author Donato Rimenti
 * 
 */
public class RegistrationResponse {

	/**
	 * The outcome of the operation.
	 */
	private boolean outcome;

	/**
	 * Instantiates a new RegistrationResponse.
	 *
	 * @param outcome
	 *            the {@link #outcome}
	 */
	public RegistrationResponse(boolean outcome) {
		this.outcome = outcome;
	}

	/**
	 * Checks if is outcome.
	 *
	 * @return true, if is outcome
	 */
	public boolean isOutcome() {
		return outcome;
	}

	/**
	 * Sets the {@link #outcome}.
	 *
	 * @param outcome
	 *            the new {@link #outcome}
	 */
	public void setOutcome(boolean outcome) {
		this.outcome = outcome;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (outcome ? 1231 : 1237);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistrationResponse other = (RegistrationResponse) obj;
		if (outcome != other.outcome)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RegistrationResponse [outcome=" + outcome + "]";
	}

}