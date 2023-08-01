package com.framework.util;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.framework.base.constants.FrameworkConstants;

public class Xls_Reader {
	public static String filename = System.getProperty("user.dir") + "\\src\\config\\testcases\\TestData.xlsx";
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;
	private DataFormatter fmt = null;

	/*
	 * This Constructor is used to provide path of excel file and to invoke/get
	 * required sheet of excel.
	 * 
	 * @param:path
	 */
	public Xls_Reader(String path) {
		this.path = path;
		fmt = new DataFormatter();
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * This method is used to get no.of rows available in excel sheet. Verify sheet
	 * available or not, if available get no.of rows in sheet
	 * 
	 * @param:sheetName
	 * 
	 * @return:number
	 */
	public int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return 0;
		else {
			sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum() + 1;
			return number;
		}

	}

	/*
	 * This method is used to retrieve Cell data by passing sheetName,row number and
	 * column Name Get required sheet Get Column count of given row number Get cell
	 * data of given row and compare it with given Column Name,if it matches
	 * retrieve Column Number Get Cell data by providing row and column number Get
	 * Cell Type and finally covert it into String form
	 * 
	 * @param:sheetname,columnName,rownNumber
	 * 
	 * @return:cellText
	 * 
	 */
	public String getCellData(String sheetName, String colName, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";

			int index = workbook.getSheetIndex(sheetName);
			int col_Num = -1;
			if (index == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				// System.out.println(row.getCell(i).getStringCellValue().trim());
				if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num = i;
			}
			if (col_Num == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				return "";
			cell = row.getCell(col_Num);

			if (cell == null)
				return "";
			// System.out.println(cell.getCellType());
			if (cell.getCellType() == CellType.STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {

				String cellText = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					// format in form of M/D/YY
					double d = cell.getNumericCellValue();

					Calendar cal = Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;

					// System.out.println(cellText);

				}

				return cellText;
			} else if (cell.getCellType() == CellType.BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());

		} catch (Exception e) {

			e.printStackTrace();
			return "row " + rowNum + " or column " + colName + " does not exist in xls";
		}
	}

	/*
	 * This method is used to retrieve Cell data by passing sheetName,row number and
	 * column number Get required sheet Get Cell data by passing row and column
	 * numbers Get Cell type and finally covert it into String form
	 * 
	 * @param:sheetName,ColumnNumber,rowNumber
	 * 
	 * @return:cellText
	 * 
	 */
	public String getCellData(String sheetName, int colNum, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";

			int index = workbook.getSheetIndex(sheetName);

			if (index == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				return "";
			cell = row.getCell(colNum);
			if (cell == null)
				return "";

			if (cell.getCellType() == CellType.STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {

				String cellText = fmt.formatCellValue(cell);// String.valueOf(cell.getNumericCellValue());

				/*
				 * if (HSSFDateUtil.isCellDateFormatted(cell)) { // format in form of M/D/YY
				 * double d = cell.getNumericCellValue();
				 * 
				 * Calendar cal =Calendar.getInstance();
				 * cal.setTime(HSSFDateUtil.getJavaDate(d)); cellText =
				 * (String.valueOf(cal.get(Calendar.YEAR))).substring(2); cellText =
				 * cal.get(Calendar.MONTH)+1 + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" +
				 * cellText;
				 * 
				 * // System.out.println(cellText);
				 * 
				 * }
				 * 
				 */

				return cellText;
			} else if (cell.getCellType() == CellType.BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {

			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exist  in xls";
		}
	}

	/*
	 * This method is used to set required data in required cell(row,column) and
	 * returns true if data is set successfully else false Get required sheet Get
	 * Column count of given row number Get cell data of given row and compare it
	 * with given Column Name,if it matches retrieve Column Number Get Cell by
	 * passing row and column numbers Set Cell Value by providing path through
	 * FileOutputStream
	 * 
	 * @param:sheetName,columnName,rowNumber,data
	 * 
	 * @return:true (if data is set successfully) else :false
	 */
	public boolean setCellData(String sheetName, String colName, int rowNum, String data) {
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);

			if (rowNum <= 0)
				return false;

			int index = workbook.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1)
				return false;

			sheet = workbook.getSheetAt(index);

			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				// System.out.println(row.getCell(i).getStringCellValue().trim());
				if (row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum = i;
			}
			if (colNum == -1)
				return false;

			sheet.autoSizeColumn(colNum);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				row = sheet.createRow(rowNum - 1);

			cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);

			// cell style
			CellStyle cs = workbook.createCellStyle();
			cs.setWrapText(true);
			cell.setCellStyle(cs);
			cell.setCellValue(data);

			fileOut = new FileOutputStream(path);

			workbook.write(fileOut);

			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// returns true if data is set successfully else false

	/*
	 * This method is used to set required data(hyperlink) in required
	 * cell(row,column name) and returns true if data is set successfully else false
	 * Get required sheet Get Column count of given row number Get cell data of
	 * given row and compare it with given Column Name,if it matches retrieve Column
	 * Number Get Cell by passing row and column numbers Create font,undeline and
	 * colour to the cell Set Cell Value by providing path through FileOutputStream
	 * 
	 * @param:sheetName,columnName,rowNumber,data
	 * 
	 * @return:true (if data is set successfully) else :false
	 */
	public boolean setCellData(String sheetName, String colName, int rowNum, String data, String url) {
		// System.out.println("setCellData setCellData******************");
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);

			if (rowNum <= 0)
				return false;

			int index = workbook.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1)
				return false;

			sheet = workbook.getSheetAt(index);
			// System.out.println("A");
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				// System.out.println(row.getCell(i).getStringCellValue().trim());
				if (row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName))
					colNum = i;
			}

			if (colNum == -1)
				return false;
			sheet.autoSizeColumn(colNum); // ashish
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				row = sheet.createRow(rowNum - 1);

			cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);

			cell.setCellValue(data);
			XSSFCreationHelper createHelper = workbook.getCreationHelper();

			// cell style for hyperlinks
			// by default hypelrinks are blue and underlined
			CellStyle hlink_style = workbook.createCellStyle();
			XSSFFont hlink_font = workbook.createFont();
			hlink_font.setUnderline(XSSFFont.U_SINGLE);
			hlink_font.setColor(IndexedColors.BLUE.getIndex());
			hlink_style.setFont(hlink_font);
			// hlink_style.setWrapText(true);

			XSSFHyperlink link = createHelper.createHyperlink(HyperlinkType.FILE);
			link.setAddress(url);
			cell.setHyperlink(link);
			cell.setCellStyle(hlink_style);

			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);

			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/*
	 * This method is used to add required sheet and returns true if sheet is
	 * created successfully else false
	 * 
	 * @param:sheetname
	 * 
	 * @return:true(if sheet is created successfully else false)
	 */
	/*
	 * public boolean addSheet(String sheetname){
	 * 
	 * FileOutputStream fileOut; try { workbook.createSheet(sheetname); fileOut =
	 * new FileOutputStream(path); workbook.write(fileOut); fileOut.close(); } catch
	 * (Exception e) { e.printStackTrace(); return false; } return true; }
	 */

	/*
	 * This method is used to remove the sheet from excel and it returns true if
	 * sheet is removed successfully else false if sheet does not exist
	 * 
	 * @param:sheetName
	 * 
	 * @return:true(if sheet is removed successfully else false if sheet does not
	 * exist)
	 */
	/*
	 * public boolean removeSheet(String sheetName){ int index =
	 * workbook.getSheetIndex(sheetName); if(index==-1) return false;
	 * 
	 * FileOutputStream fileOut; try { workbook.removeSheetAt(index); fileOut = new
	 * FileOutputStream(path); workbook.write(fileOut); fileOut.close(); } catch
	 * (Exception e) { e.printStackTrace(); return false;
	 * 
	 * } return true; }
	 */

	/*
	 * This method is used to create new column in Sheet with required Column Name
	 * Create Work book and get required sheet Creat new Cell Set Cell data by
	 * providing path through FileOutputStream
	 * 
	 * @param:sheetName,colName
	 * 
	 * @return:true(if new column created successfully else false)
	 */
	public boolean addColumn(String sheetName, String colName) {
		// System.out.println("**************addColumn*********************");

		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			int index = workbook.getSheetIndex(sheetName);
			if (index == -1)
				return false;

			XSSFCellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(new XSSFColor(Color.LIGHT_GRAY));
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

			sheet = workbook.getSheetAt(index);

			row = sheet.getRow(0);
			if (row == null)
				row = sheet.createRow(0);

			// cell = row.getCell();
			// if (cell == null)
			// System.out.println(row.getLastCellNum());
			if (row.getLastCellNum() == -1)
				cell = row.createCell(0);
			else
				cell = row.createCell(row.getLastCellNum());

			cell.setCellValue(colName);
			cell.setCellStyle(style);

			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	/*
	 * This method is used to remove required column from excel
	 * 
	 * @param:sheetName,columnNumber
	 * 
	 * @return:true(if column removed successfully else false)
	 */
	public boolean removeColumn(String sheetName, int colNum) {
		try {
			if (!isSheetExist(sheetName))
				return false;
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			XSSFCellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(new XSSFColor(Color.LIGHT_GRAY));
			XSSFCreationHelper createHelper = workbook.getCreationHelper();
			style.setFillPattern(FillPatternType.NO_FILL);

			for (int i = 0; i < getRowCount(sheetName); i++) {
				row = sheet.getRow(i);
				if (row != null) {
					cell = row.getCell(colNum);
					if (cell != null) {
						cell.setCellStyle(style);
						row.removeCell(cell);
					}
				}
			}
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	/*
	 * This method is used to verify given sheet exist in excel or not
	 * 
	 * @param:sheetName
	 * 
	 * @return:true(if sheet exists else false)
	 */
	public boolean isSheetExist(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1) {
			index = workbook.getSheetIndex(sheetName.toUpperCase());
			if (index == -1)
				return false;
			else
				return true;
		} else
			return true;
	}

	/*
	 * This method is used to retrieve Column count for the sheet provided
	 * 
	 * @param:sheetName
	 * 
	 * @return: columncount
	 */
	public int getColumnCount(String sheetName) {
		// check if sheet exists
		if (!isSheetExist(sheetName))
			return -1;

		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);

		if (row == null)
			return -1;

		return row.getLastCellNum();

	}

	/*
	 * This method is used to add hyperlink in required coulmn
	 * 
	 * @param:sheetName,screenShotColName,testCaseName,index,url,message
	 * 
	 * @return:true(hyperlink added successfully else false)
	 */
	public boolean addHyperLink(String sheetName, String screenShotColName, String testCaseName, int index, String url,
			String message) {
		// System.out.println("ADDING addHyperLink******************");

		url = url.replace('\\', '/');
		if (!isSheetExist(sheetName))
			return false;

		sheet = workbook.getSheet(sheetName);

		for (int i = 2; i <= getRowCount(sheetName); i++) {
			if (getCellData(sheetName, 0, i).equalsIgnoreCase(testCaseName)) {
				// System.out.println("**caught "+(i+index));
				setCellData(sheetName, screenShotColName, i + index, message, url);
				break;
			}
		}

		return true;
	}

	/*
	 * This method is used to retrieve row number if specified cell data matches Get
	 * required sheet Get row count of given sheet Compare each cell value of row
	 * with given cell data,if matches return row number
	 * 
	 * @param:sheetName,columnName,cellValue
	 * 
	 * @return:rownumber
	 */
	public int getCellRowNum(String sheetName, String colName, String cellValue) {

		for (int i = 2; i <= getRowCount(sheetName); i++) {
			if (getCellData(sheetName, colName, i).equalsIgnoreCase(cellValue)) {
				return i;
			}
		}
		return -1;

	}

	/*
	 * This is the main method to run excel as stand alone
	 */
	public static void main(String arg[]) throws IOException {

		System.out.println(filename);
		Xls_Reader datatable = null;

		datatable = new Xls_Reader(FrameworkConstants.PS_DATA_XLS_PATH);
		for (int col = 0; col < datatable.getColumnCount("TC5"); col++) {
			System.out.println(datatable.getCellData("TC5", col, 1));
		}
	}

}
