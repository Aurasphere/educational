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

/**
 * Toggle visibility of an HTML element with a given ID.
 * 
 * @param id
 *            the ID of the element to toggle
 * @returns true if the element is now visible, false otherwise
 */
function toggleVisibility(id) {
	// Gets the element style.
	var elementStyle = document.getElementById(id).style;

	// Note: the first time the display property will be an empty string since
	// it's defined in an external CSS file and thus it will be available only
	// with the computed style property which won't work on IE.
	if (elementStyle.display == "none" || elementStyle.display == "") {
		// Element is currently hidden, show it.
		elementStyle.display = "block";
		return true;
	}

	// Element is currently visible, hide it.
	elementStyle.display = "none";
	return false;
}

/**
 * Loads an HTML page inside the content section with AJAX.
 * 
 * @param page
 *            the name of the page to load
 * @returns null
 */
function loadContent(page) {
	// Builds an XMLHttpRequest if supported otherwise defaults to an
	// ActiveXObject.
	var xmlhttp;
	if (window.XMLHttpRequest)
		xmlhttp = new XMLHttpRequest();
	else
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");

	// Sets a callback that shows the response inside the content section.
	xmlhttp.onreadystatechange = function() {
		if ((xmlhttp.readyState == 4) && (xmlhttp.status == 200))
			document.getElementById("content").innerHTML = xmlhttp.responseText;
	}

	// Builds the destination URL and sends the AJAX request.
	var page = "content/" + page + ".html";
	xmlhttp.open("GET", page, true);
	xmlhttp.send();
}