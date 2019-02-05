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

// Creates an AngularJS app.
var app = angular.module("coursewareApp", []);

// Creates an AngularJS controller.
app.controller("coursewareController", function($scope, $http) {

	// Loads a list of items from a REST service.
	$scope.loadItemsList = function() {
		var url = "rest/controller/getItemsList";
		$http.get(url).then(function(response) {
			$scope.itemsList = response.data;
		});
	}

	// Invokes the throw dice REST service.
	$scope.throwDice = function() {
		var url = "rest/controller/throwDice";

		// Pass the number of dice sides if not null or empty.
		if ($scope.numSides) {
			url += "?sides=" + $scope.numSides;
		}

		$http.get(url).then(function(response) {
			$scope.diceResult = response.data;
		});
	}
	
	// Gets an object from the server.
	$scope.getResponse = function() {
		var url = "rest/controller/getResponse";
		$http.get(url).then(function(response) {
			$scope.serverResponse = response.data.message;
		});
	}

});
