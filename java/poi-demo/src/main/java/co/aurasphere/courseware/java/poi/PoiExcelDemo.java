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
package co.aurasphere.courseware.java.poi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.BorderStyle;

/**
 * Shows how to build an Excel using Apache POI.
 * 
 * @author Donato Rimenti
 * 
 */
public class PoiExcelDemo {

	/**
	 * Builds an Excel and saves it to a file.
	 *
	 * @param args null
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {

		// Builds an excel.
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet();

		// Cell font.
		HSSFFont font = wb.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setFontHeightInPoints((short) 20);
		font.setColor(HSSFColorPredefined.BLUE.getIndex());

		// Cell style
		HSSFCellStyle style = wb.createCellStyle();
		style.setBorderTop(BorderStyle.MEDIUM_DASH_DOT_DOT);
		style.setBorderBottom(BorderStyle.MEDIUM_DASH_DOT_DOT);
		style.setFont(font);

		// Creates some rows.
		for (int i = 0; i < 9; i++) {
			HSSFRow row = sheet.createRow(i);
			for (int j = 0; j < 6; j++) {
				HSSFCell cell = row.createCell(j);
				cell.setCellValue(new HSSFRichTextString("row= " + i + " col= " + j));
				cell.setCellStyle(style);
				sheet.autoSizeColumn(j);
			}
		}

		// Writes the file.
		FileOutputStream fos = null;
		fos = new FileOutputStream(new File("ExcelDemo.xls"));
		wb.write(fos);
		wb.close();

		System.out.println("End of file generation");
	}
}