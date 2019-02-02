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
package co.aurasphere.courseware.java.interview.questions.logic;

/**
 * Question: write a simple linked list implementation which will let you add
 * some elements and then print the whole content of the list.
 * 
 * @author Donato Rimenti
 *
 */
public class CustomStringLinkedList {

	/**
	 * First node of the list.
	 */
	private Node head;

	/**
	 * Adds a string as the last element of the list.
	 * 
	 * @param element
	 *            the string to add
	 */
	public void add(String element) {
		Node newNode = new Node(element);

		// If the head is null, this node will be the first node of the list.
		if (head == null) {
			head = newNode;
			return;
		}

		// Gets the last node.
		Node cursor = head;
		while (cursor.getNext() != null) {
			cursor = cursor.getNext();
		}

		// Sets the new node as the successor of the last node.
		cursor.setNext(newNode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HEAD -> " + head + " -> TAIL";
	}

	/**
	 * Represents a single element of the list.
	 * 
	 * @author Donato Rimenti
	 *
	 */
	private class Node {

		/**
		 * Content of this node.
		 */
		private String content;

		/**
		 * Successor of this node.
		 */
		private Node next;

		/**
		 * Instantiates a new Node.
		 *
		 * @param content
		 *            the {@link #content}
		 */
		public Node(String content) {
			this.content = content;
		}

		/**
		 * Gets the {@link #next}.
		 *
		 * @return the {@link #next}
		 */
		public Node getNext() {
			return next;
		}

		/**
		 * Sets the {@link #next}.
		 *
		 * @param next
		 *            the new {@link #next}
		 */
		public void setNext(Node next) {
			this.next = next;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return content + " -> " + next;
		}

	}

	/**
	 * Tests the list behavior by adding some elements and then printing the
	 * list content.
	 *
	 * @param args
	 *            null
	 */
	public static void main(String[] args) {
		CustomStringLinkedList list = new CustomStringLinkedList();
		list.add("first");
		list.add("second");
		System.out.println(list);
	}

}