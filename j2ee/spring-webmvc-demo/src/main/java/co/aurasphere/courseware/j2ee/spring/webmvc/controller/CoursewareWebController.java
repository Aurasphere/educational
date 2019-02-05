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
package co.aurasphere.courseware.j2ee.spring.webmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import co.aurasphere.courseware.j2ee.spring.webmvc.service.CoursewareService;

/**
 * Web controller which delegates requests processing to a service component and
 * then changes the view component accordingly to the outcome. The service
 * component is injected by Spring.
 * 
 * @author Donato Rimenti
 *
 */
@Controller
public class CoursewareWebController {

	/**
	 * Service component which handles requests.
	 */
	@Autowired
	private CoursewareService service;

	/**
	 * Processes a form by delegating the service component and then changing
	 * the current view.
	 * 
	 * @param modelMap
	 *            the view scope, used to put data to show
	 * @param request
	 *            the current request from the view
	 * @return the name of the next view to be shown to the user
	 */
	@GetMapping("/processForm")
	public String processForm(ModelMap modelMap, HttpServletRequest request) {
		// Gets the submitted data.
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		
		// Processes the data.
		service.processRequest(name, surname);

		// Puts some parameters into the jsp scope.
		modelMap.addAttribute("name", name);
		modelMap.addAttribute("surname", surname);

		// Returns a new page (outcome.jsp).
		return "outcome";
	}
}