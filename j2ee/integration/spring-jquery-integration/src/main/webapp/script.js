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

/**
 * Hides messages after page loading.
 */
$(document).ready(function() {
	$("#error").hide();
	$("#success").hide();
});

/**
 * Checks if a name is available for registration by invoking a web service
 * asynchronously through AJAX and jQuery.
 * 
 * @returns the username that will be checked for availability asynchronously
 */
function checkNameAvailable() {
	// Gets the value inserted by the user.
	var inputName = $("#input-name").val();

	// Invokes the availability check web service asynchronously.
	$.ajax({
		url : "courseware/register/checkNameAvailable",
		type : "GET",
		data : {
			username : inputName
		},
		success : function(data) {
			// Shows or hides the messages accordingly to the server
			// outcome.
			if (data.outcome == false) {
				$("#error").show();
				$("#success").hide();
			} else {
				$("#error").hide();
				$("#success").show();
			}
		}
	});

	return inputName;
}