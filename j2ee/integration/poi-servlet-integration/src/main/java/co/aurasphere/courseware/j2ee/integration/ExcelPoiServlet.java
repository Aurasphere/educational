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
package co.aurasphere.courseware.j2ee.integration;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Sample servlet which returns an Excel generated using Apache POI.
 * 
 * @author Donato Rimenti
 * 
 */
@WebServlet("/")
public class ExcelPoiServlet extends HttpServlet {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		replyWithExcel(req, res);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		replyWithExcel(req, res);
	}

	/**
	 * Populates a response with a sample Excel file.
	 *
	 * @param req the current request
	 * @param res the current response
	 */
	private void replyWithExcel(HttpServletRequest req, HttpServletResponse res) {
		// Creates a sample Excel.
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet();
		HSSFRow row = sheet.createRow(0);
		row.createCell(1).setCellValue(1.5);
		row.createCell(2).setCellValue("A string");
		row.createCell(3).setCellValue(true);

		// Sets the MIME and the file name.
		res.setContentType("application/msexcel");
		res.setHeader("Content-disposition", "attachment; filename=GeneratedExcel.xls");

		// Adds the workbook to the response.
		try {
			wb.write(res.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// Very important, always free the resources.
			try {
				wb.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}