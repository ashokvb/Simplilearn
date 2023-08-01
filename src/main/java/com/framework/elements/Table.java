package com.framework.elements;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

import com.framework.driver.WebUIDriver;
import com.framework.elements.BaseElement;
import com.framework.util.TestReportsLog;
import com.relevantcodes.extentreports.LogStatus;

public class Table extends BaseElement {

	private List<WebElement> rows = null;
	private List<WebElement> columns = null;
	private String elementPath = "";
	/* /* intializes the parent class(Base Element) variables */

	public Table(final String label, final By by) {
		super(label, by);
		elementPath = by.toString();
	}

	public boolean isTextPresent(String text) {

		for (int i = 1; i <= getRowCount(); i++) {

			for (int j = 1; j <= getColumnCount(); j++) {
				if (text.equals(getContent(i, j))) {
					return true;
				}
			}
		}

		return false;
	}

	/*
	 * This method is used to find the element To get no.of rows in a Table
	 */

	public void findElement() {
		super.findElement();
		try {
			rows = element.findElements(By.tagName("tr"));
		} catch (NotFoundException e) {
		}

	}

	/*
	 * This method is used to get column count of each row in table
	 * 
	 * @return -column.size()-->it return column count of each row in table
	 */

	public int getColumnCount() {
		if (rows == null) {
			findElement();
		}

		// Need to check whether rows is null AND whether or not the list of
		// rows is
		// empty
		if (rows != null && !rows.isEmpty()) {
			try {
				columns = rows.get(0).findElements(By.tagName("td"));
			} catch (NotFoundException e) {
			}

			if (columns == null || columns.size() == 0) {

				try {
					if (rows.size() > 1) {
						columns = rows.get(1).findElements(By.tagName("td"));
					} else {
						columns = rows.get(0).findElements(By.tagName("th"));
					}
				} catch (NotFoundException e) {
				}
			}
		}

		if (columns != null) {
			return columns.size();
		}

		return 0;
	}

	/*
	 * This method is used to return no.of columns in a table as list
	 * 
	 * @return-columns
	 */
	public List<WebElement> getColumns() {
		return columns;
	}

	/*
	 * This method is used to get table cell content by passing row and column
	 * number dynamically
	 * 
	 * @param-row,column
	 * 
	 * @return-cellcontent
	 */
	public String getContent(final int row, final int column) {
		if (rows == null) {
			findElement();
		}
		if (rows != null && !rows.isEmpty()) {
			int start = elementPath.indexOf("//");
			int end = elementPath.length();
			elementPath = elementPath.substring(start, end);

			String xpath = elementPath + "/tr[%1$d]/td[%2$d]";
			xpath = String.format(xpath, row, column);
			return WebUIDriver.getWebDriver().findElement(By.xpath(xpath)).getText();
		}
		return null;
	}

	/*
	 * This method is used to find the Table element and get no.of rows in it
	 * 
	 * @return-rows.size()-->returns no.of.rows in a table
	 * 
	 */
	public int getRowCount() {
		if (rows == null) {
			findElement();
		} else {
			return rows.size();
		}

		int count = element.findElements(By.xpath("tbody/tr")).size();
		if (count == 0) {
			count = element.findElements(By.xpath("tr")).size();
		}

		return count;
	}

	/*
	 * This method is used to get no.of.rows in table as list
	 * 
	 * @return-rows
	 */
	public List<WebElement> getRows() {
		return rows;
	}

	/*
	 * This method is used to verify row count>0 or not
	 * 
	 * @return-true(If row count>0);false(if row count<0)
	 */
	public boolean isHasBody() {
		return getRows().size() > 0;
	}

	/*
	 * public int isRowPresent(List<String> rowData) { >>>>>>>
	 * ecf5f1a81afecf31396500e3b064ba53f71ad2fc int k; int i; boolean result =
	 * false; int listCount = rowData.size(); int rowCount = getRowCount(); int
	 * columnCount = getColumnCount(); int rowStart = 1;
	 * 
	 * if (!checkHeader) { rowStart = 2; }
	 * 
	 * outer: for (i = rowStart; i <= rowCount; i++) { k = 0; for (int j = 1; j
	 * <= columnCount; j++) { String value = rowData.get(k); if
	 * (value.equals(getContent(i, j))) { k++;
	 * 
	 * if (k == listCount) { TestReportsLog.log(LogStatus.PASS,
	 * "Verfied all the table elements sucessfully" +
	 * Arrays.toString(rowData.toArray()) + toHTML());
	 * 
	 * result = true; break outer;
	 * 
	 * } } } } if (result == false) { TestReportsLog.log(LogStatus.FAIL,
	 * "Unable to verify the record in the table - " +
	 * Arrays.toString(rowData.toArray()) + toHTML()); } return i; }
	 */

	public int isRowPresent(List<String> rowData) {

		Boolean checkHeader = true;
		return isRowPresent(rowData, checkHeader);
	}

	public int isRowPresent(List<String> rowData, Boolean checkHeader) {
		int k;
		int i;
		boolean result = false;
		int listCount = rowData.size();
		int rowCount = getRowCount();
		int columnCount = getColumnCount();
		int rowStart = 1;
		String tableVeriLog = "", Log ="";
		String cellValue = "";

		if (!checkHeader) {
			rowStart = 2;
		}
		outer: for (i = rowStart; i <= rowCount; i++) {
			k = 0;
			for (int j = 1; j <= columnCount; j++) {
				String value = rowData.get(k);
				cellValue = getContent(i, j);
				if (value.equals(cellValue.trim())) {
					Log = "Matched - Comparing Values Actual - '" + cellValue + "' Expected Value - '" + value + "'";
					System.out.println(Log);

					k++;

					if (k == listCount) {
						TestReportsLog.log(LogStatus.PASS, "Verfied all the table elements sucessfully"
								+ Arrays.toString(rowData.toArray()) + toHTML());

						result = true;
						break outer;
					}
				} else {
					Log = "No Match- Comparing Values Actual - '" + cellValue + "' Expected Value - '" + value + "'";
					System.out.println(Log);
				}
				
				tableVeriLog = tableVeriLog + "<br>" + Log;

			}
		}
		if (result == false) {
			TestReportsLog.log(LogStatus.FAIL,
					"Unable to verify the record in the table - " + Arrays.toString(rowData.toArray()) + toHTML());
			TestReportsLog.log(LogStatus.INFO,
					"Comparison Summary - " + tableVeriLog + toHTML());
		}
		return i;
	}

	public int verifyRowNotPresent(List<String> rowData) {
		int k;
		int i;
		boolean result = false;
		int listCount = rowData.size();
		int rowcount = getRowCount();
		outer: for (i = 1; i <= getRowCount(); i++) {
			k = 0;
			for (int j = 1; j <= getColumnCount(); j++) {

				String value = rowData.get(k);

				if (value.equals(getContent(i, j))) {
					k++;

					if (k == listCount) {
						TestReportsLog.log(LogStatus.FAIL, "All the elements are present int the table"
								+ Arrays.toString(rowData.toArray()) + toHTML());

						// result = true;
						break outer;

					}
				}
			}
			if (i == rowcount) {
				result = true;
				TestReportsLog.log(LogStatus.INFO,
						"Record not present in the table - " + Arrays.toString(rowData.toArray()) + toHTML());
			}

		}
		return i;
	}

	public void verifyColumnData(String columnData) {
		int k;
		int j;
		boolean result = false;
		int listCount = getRowCount();

		outer: for (j = 1; j <= getColumnCount(); j++) {
			k = 0;
			for (int i = 1; i <= getRowCount(); i++) {

				if (columnData.equals(getContent(i, j))) {
					k++;

					if (k == listCount - 1) {
						TestReportsLog.log(LogStatus.INFO,
								"All the Columns have been Filtered Correctly -" + columnData + toHTML());

						result = true;
						break outer;

					}
				}

				else {
					TestReportsLog.log(LogStatus.ERROR,
							"Not Filtered Correctly as per the Searched Data ,as the Column data doesnot Match -"
									+ getContent(i, j) + toHTML());
					break outer;
				}
			}
		}

	}

	public void searchandClickColumn(String columndata) {

		int i;
		int j;
		int k = 0;

		outer: for (i = 1; i <= getRowCount(); i++) {

			for (j = 1; j <= getColumnCount(); j++) {

				if (columndata.equals(getContent(i, j))) {

					k++;
					columns.get(j).click();
					TestReportsLog.log(LogStatus.INFO, "Clicked on Required Subject");
					break outer;

				}

			}

		}

		if (k == 0) {

			TestReportsLog.log(LogStatus.INFO, "Required Subject Not Found");

		}

	}

}