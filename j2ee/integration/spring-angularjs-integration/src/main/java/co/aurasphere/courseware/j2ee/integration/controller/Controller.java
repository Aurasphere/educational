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
package co.aurasphere.courseware.j2ee.integration.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.aurasphere.courseware.j2ee.integration.model.Response;

/**
 * REST controller which offers generic services.
 * 
 * @author Donato Rimenti
 * 
 */
@RestController
@RequestMapping("/controller")
public class Controller {

	/**
	 * REST service which returns a generic list of items.
	 *
	 * @return a generic list of items
	 */
	@GetMapping("/getItemsList")
	public List<String> getItemsList() {
		return Arrays.asList("Apple", "Orange", "Banana", "Lemon");
	}

	/**
	 * REST service which throws a dice with a given number of sides and returns
	 * the result.
	 *
	 * @param diceSides
	 *            the number of sides of the dice to throw
	 * @return the resulting face from throwing the dice
	 */
	@GetMapping("/throwDice")
	public Integer throwDice(@RequestParam(name = "sides", defaultValue = "6") Integer diceSides) {
		Random r = new Random();
		return r.nextInt(diceSides) + 1;
	}

	/**
	 * REST service which returns a generic POJO.
	 * 
	 * @return a generic POJO
	 */
	@GetMapping("/getResponse")
	public Response getResponse() {
		return new Response("Response from server");
	}

}