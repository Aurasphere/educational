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

// Defines the angular app.
var app = angular.module("myApp", []);

// Defines the app controller.
app.controller("myController", function($scope, $http) {

	// Variables in scope.
	$scope.title = "Page title from Javascript";
	$scope.myList = [ "one", "two", "three" ];

	// Toggles the label value.
	var labelOne = "Click me!";
	var labelTwo = "Click me again!";
	$scope.changeLabel = function() {
		if ($scope.label === "" || $scope.label === labelTwo) {
			$scope.label = labelOne;
		} else {
			$scope.label = labelTwo;
		}
	}

	// This ajax call will be performed once the controller is loaded and will
	// put the result into scope and then rendered.
	$http.get("data.json").then(function(response) {
		$scope.ajaxResult = response.data.message;
	}, function(response) {
		$scope.ajaxResult = "Data not found";
	});

});