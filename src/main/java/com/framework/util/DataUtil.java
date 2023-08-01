package com.framework.util;

import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.collections.iterators.ArrayIterator;
import org.testng.ITestContext;
import org.testng.SkipException;

import com.framework.base.constants.FrameworkConstants;
import com.relevantcodes.extentreports.LogStatus;

/*This method is used to retrieve complete set of Test Data to parameterize the Test Case
 * Get required TestData Sheet and Test Case Name
 * Get number of rows of Test data available to parameterize the Test Case
 * Get number of Columns of Test data available to execute the Test Case
 * Retrieve Cell data of Test Case by passing row number and column number dynamically
 * Put each Cell data in Hash Table in the form of key and value
 * @param: xls,testCaseName
 * @return: data(Set of test data to parameterize Test Case)
 */
public class DataUtil {

	Xls_Reader xls;
	String testCaseName;

	public DataUtil(Xls_Reader xls, String testCaseName) {
		this.xls = xls;
		this.testCaseName = testCaseName;
	}

	public static Xls_Reader getXlsReader(String dataFileName) {
		String filePath = System.getProperty("user.dir") + "//data//" + dataFileName;
		Xls_Reader xls = new Xls_Reader(filePath);
		return xls;
	}

	public static Object[][] getData(Xls_Reader xls, String testCaseName) {
		String sheetName = FrameworkConstants.TESTDATA_SHEET;
		Object[][] data = null;
		// reads data for only testCaseName
		int rows = xls.getRowCount(sheetName);
		int testStartRowNum = 1;

		if (!DataUtil.isTestExecutable(xls, testCaseName)) {
			System.out.println("Skipping Test Case as Runmode is N or TestCase Name - " + testCaseName
					+ " not found in Sheet - " + FrameworkConstants.TESTDATA_SHEET);
			data = new Object[0][0];
			return data;
			// throw new SkipException("Skipping the reportLog as Runmode is N or TestCase
			// Name not found in Sheet - " + FrameworkConstants.TESTDATA_SHEET);
		}
		while (!xls.getCellData(sheetName, 0, testStartRowNum).equals(testCaseName) || testStartRowNum > rows) {
			testStartRowNum++;
		}
		// System.out.println("Test starts from row - "+ testStartRowNum);
		int colStartRowNum = testStartRowNum + 1;
		int dataStartRowNum = testStartRowNum + 2;

		// calculate rows of data
		int rowsWithRunmodeN = 0;
		rows = 0;
		while (!xls.getCellData(sheetName, 0, dataStartRowNum + rows).equals("")) {
			if (xls.getCellData(sheetName, 0, dataStartRowNum + rows).equals("N"))
				rowsWithRunmodeN++;
			rows++;
		}

		// System.out.println("Total rows are - "+rows );

		// calculate total cols
		int cols = 0;
		while (!xls.getCellData(sheetName, cols, colStartRowNum).equals("")) {
			cols++;
		}
		// System.out.println("Total cols are - "+cols );
		// finding the rows with runmode as N
		data = new Object[rows - rowsWithRunmodeN][1];
		// read the data
		int dataRow = 0;
		StringHash table = null;
		for (int rNum = dataStartRowNum; rNum < dataStartRowNum + rows; rNum++) {
			table = new StringHash();
			for (int cNum = 0; cNum < cols; cNum++) {
				String key = xls.getCellData(sheetName, cNum, colStartRowNum);
				String value = xls.getCellData(sheetName, cNum, rNum);
				table.put(key, value);
			}

			if (table.get("Runmode").equals("Y")) {
				data[dataRow][0] = table;
				dataRow++;
			} else {
				System.out.println("Skiping Test Case - " + table);
				// throw new SkipException("Skipping the reportLog as Runmode is N or TestCase
				// Name not found in Sheet - " + FrameworkConstants.TESTDATA_SHEET);
			}
		}
		return data;
	}

	public Object[][] getData() {
		String sheetName = FrameworkConstants.TESTDATA_SHEET;
		// reads data for only testCaseName

		int testStartRowNum = 1;
		while (!this.xls.getCellData(sheetName, 0, testStartRowNum).equals(this.testCaseName)) {
			testStartRowNum++;
		}

		// System.out.println("Test starts from row - "+ testStartRowNum);
		int colStartRowNum = testStartRowNum + 1;
		int dataStartRowNum = testStartRowNum + 2;

		// calculate rows of data
		int rows = 0, rowsWithRunmodeN = 0;
		while (!this.xls.getCellData(sheetName, 0, dataStartRowNum + rows).equals("")) {
			if (this.xls.getCellData(sheetName, 0, dataStartRowNum + rows).equals("N"))
				rowsWithRunmodeN++;
			rows++;
		}

		int cols = 0;
		while (!this.xls.getCellData(sheetName, cols, colStartRowNum).equals("")) {
			cols++;
		}
		// System.out.println("Total cols are - "+cols );
		// finding the rows with runmode as N
		Object[][] data = new Object[rows - rowsWithRunmodeN][1];
		// read the data
		int dataRow = 0;
		StringHash table = null;
		for (int rNum = dataStartRowNum; rNum < dataStartRowNum + rows; rNum++) {
			table = new StringHash();
			for (int cNum = 0; cNum < cols; cNum++) {
				String key = this.xls.getCellData(sheetName, cNum, colStartRowNum);
				String value = this.xls.getCellData(sheetName, cNum, rNum);
				table.put(key, value);
			}

			if (table.get("Runmode").equals("Y")) {
				data[dataRow][0] = table;
				dataRow++;
			} else {
				// TestReportsLog.getTest().log(LogStatus.SKIP, "Skipping:- " + table + " as
				// Runmode is N");
				// System.out.println("Skiping Test Case - " + table);
				TestReportsLog.getTest().log(LogStatus.INFO, "Skiping Test Case - " + table + " as Runmode is N");
			}
		}
		return data;
	}

	public static Object[][] getDataFromSheet(Xls_Reader xls, String dataStartPoint) {
		String sheetName = FrameworkConstants.TESTDATABASE_SHEET;
		// reads data for only testCaseName

		int testStartRowNum = 1;

		while (!xls.getCellData(sheetName, 0, testStartRowNum).equals(dataStartPoint)) {
			testStartRowNum++;
		}
		// System.out.println("Test starts from row - "+ testStartRowNum);
		int colStartRowNum = testStartRowNum + 1;
		int dataStartRowNum = testStartRowNum + 2;

		// calculate rows of data
		int rows = 0;
		while (!xls.getCellData(sheetName, 0, dataStartRowNum + rows).equals("")) {
			rows++;
		}

		// calculate total cols
		int cols = 0;
		while (!xls.getCellData(sheetName, cols, colStartRowNum).equals("")) {
			cols++;
		}

		Object[][] data = new Object[rows][1];
		// read the data
		int dataRow = 0;
		StringHash table = null;
		for (int rNum = dataStartRowNum; rNum < dataStartRowNum + rows; rNum++) {
			table = new StringHash();
			for (int cNum = 0; cNum < cols; cNum++) {
				String key = xls.getCellData(sheetName, cNum, colStartRowNum);
				String value = xls.getCellData(sheetName, cNum, rNum);
				if (value.equals("null")) {
					value = "";
				}
				table.put(key, value);
			}
			data[dataRow][0] = table;
			dataRow++;
		}
		return data;
	}

	public static Object[][] getTestCases(Xls_Reader xls) {
		String sheetName = FrameworkConstants.TESTCASES_SHEET;

		int rows = xls.getRowCount(sheetName);

		int rowsWithRunmodeN = 0, dataStartRowNum = 2, rowCount = 0;
		while (!xls.getCellData(sheetName, 0, dataStartRowNum + rowCount).equals("")) {
			if (xls.getCellData(sheetName, "Runmode", dataStartRowNum + rowCount).equals("N"))
				rowsWithRunmodeN++;

			rowCount++;
		}

		Object[][] testCaseNames = new Object[rowCount - rowsWithRunmodeN][1];
		int dataRow = 0;

		for (int rNum = 2; rNum <= rows; rNum++) {
			String tcid = xls.getCellData(FrameworkConstants.TESTCASES_SHEET, "TCID", rNum);
			String runmode = xls.getCellData(FrameworkConstants.TESTCASES_SHEET, "Runmode", rNum);

			if (runmode.equals("Y")) {
				testCaseNames[dataRow][0] = tcid;
				dataRow++;
			}
		}
		return testCaseNames;
	}

	/*
	 * This method is used to verify whether the test execution status is yes or not
	 * Retrieves the test sheet required Get cell data of each Test case Verify
	 * execution status is Yes or Not
	 * 
	 * @return: true (If Test execution status is Yes);false(If Test execution
	 * Status is No)
	 */
	public static boolean isTestExecutable(Xls_Reader xls, String testCaseName) {
		int rows = xls.getRowCount(FrameworkConstants.TESTCASES_SHEET);
		for (int rNum = 2; rNum <= rows; rNum++) {
			String tcid = xls.getCellData(FrameworkConstants.TESTCASES_SHEET, "TCID", rNum);
			if (tcid.equals(testCaseName)) {
				String runmode = xls.getCellData(FrameworkConstants.TESTCASES_SHEET, "Runmode", rNum);
				if (runmode.equals("Y"))
					return true;
				else
					return false;

			}
		}
		return false;
	}

	@SuppressWarnings("rawtypes")
	public static HashMap getDataAsHashMap(Object[][] data) {
		HashMap<String, Object> param = new HashMap<String, Object>();

		if (data.length > 0) {
			@SuppressWarnings("unchecked")
			Iterator<Object[]> iterator = new ArrayIterator(data);

			while (iterator.hasNext()) {
				StringHash sheetData = (StringHash) iterator.next()[0];

				param.put(sheetData.get("Field"), sheetData.get("Value"));
			}
		}
		return param;
	}

	public static long getRandomNumber(long min, long max) {
		return (long) Math.floor(Math.random() * (max - min + 1)) + min;
	}

	public static void getContextValue(StringHash data, ITestContext context, String dataFieldName,
			String attributeName) throws Exception {
		String dataStr;
		if (data.get(dataFieldName).equals("")) {
			try {
				dataStr = context.getAttribute(attributeName).toString();
				if (dataStr != "") {
					data.replace(dataFieldName, dataStr);
					TestReportsLog.log(LogStatus.INFO, "Value for: " + dataFieldName + "found in ITestContext: " + dataStr);
				} else
					TestReportsLog.log(LogStatus.FAIL, "Value is Blank in ITestContext");
			} catch (Exception e) {
				TestReportsLog.log(LogStatus.FAIL, "Unable to fetch value from ITestContext");
			}
		}

	}

}
