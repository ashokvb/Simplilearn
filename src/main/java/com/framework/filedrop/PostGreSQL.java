package com.framework.filedrop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import org.apache.commons.collections.iterators.ArrayIterator;

import com.framework.util.StringHash;
import com.framework.util.TestReportsLog;
import com.relevantcodes.extentreports.LogStatus;

public class PostGreSQL {

	private Connection conn;
	private String host;
	private String dbName;
	private String user;
	private String password;

	public PostGreSQL() {
	}

	public PostGreSQL(String host, String dbName, String user, String password) {
		this.host = host;
		this.dbName = dbName;
		this.user = user;
		this.password = password;
	}

	public ResultSet execQuery(String query) {
		ResultSet rs = null;

		if (connect()) {
			TestReportsLog.log(LogStatus.INFO, "Executing Query:- " + query);

			try {
				@SuppressWarnings("resource")
				PreparedStatement st = this.conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
				rs = st.executeQuery();
				TestReportsLog.log(LogStatus.INFO, "Query execution successful:- "+ query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());

				TestReportsLog.log(LogStatus.ERROR, "PostGreSQL ::- execQuery " + e.getMessage());
			}
		}

		return rs;
	}
	
	public int execUpdateQuery(String query) {
		int count = 0;

		if (connect()) {
			TestReportsLog.log(LogStatus.INFO, "Executing Update Query:- " + query);

			try {
				PreparedStatement st = this.conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				count = st.executeUpdate();
				st.close();

				TestReportsLog.log(LogStatus.INFO, "Update query execution successful:- "+ query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());

				TestReportsLog.log(LogStatus.ERROR, "PostGreSQL ::- execQuery " + e.getMessage());
			}
		}

		return count;
	}

	public int getCount(ResultSet rs) {
		int count = 0;

		TestReportsLog.log(LogStatus.INFO, "Getting resultset count");
		if (rs != null) {
			try {
				rs.last();
				count = rs.getRow();
				TestReportsLog.log(LogStatus.INFO, "Resultset counting successfull");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				TestReportsLog.log(LogStatus.ERROR, "PostGreSQL ::- getCount " + e.getMessage());
			}

		}
		return count;
	}

	private boolean connect() {

		TestReportsLog.log(LogStatus.INFO, "Connecting to Database");

		if (host.isEmpty() || dbName.isEmpty() || user.isEmpty() || password.isEmpty()) {
			TestReportsLog.log(LogStatus.ERROR, 
					"PostGreSQL ::- connect " + "Credentials missing to connect to Database");

			return false;
		}

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			TestReportsLog.log(LogStatus.INFO, "PostGreSQL ::- connect " + e.getMessage());

			return false;
		}

		try {
			String url=this.host+this.dbName;			
			this.conn = DriverManager.getConnection(url, this.user, this.password);	
			
			
			
			
			TestReportsLog.log(LogStatus.INFO, "Connected to Database" + this.host + this.dbName);
		} catch (SQLException e) {
			TestReportsLog.log(LogStatus.ERROR, "PostGreSQL ::- connect " + e.getMessage());

			return false;
		}
		return true;
	}

	public void close() {
		try {
			this.conn.close();

			TestReportsLog.log(LogStatus.INFO, "Database connection closed: " + this.host + this.dbName);
		} catch (SQLException e) {
			TestReportsLog.log(LogStatus.ERROR, "PostGreSQL ::- close " + e.getMessage());
		}
	}

	public boolean executeBulkQueries(Object[][] data) {
		int count = 0;
	
		if (data.length > 0) {
			@SuppressWarnings("unchecked")
			Iterator<Object[]> iterator = new ArrayIterator(data);

			while (iterator.hasNext()) {
				StringHash sheetData = (StringHash) iterator.next()[0];

				this.dbName = sheetData.get("DBName");
				
				count = this.execUpdateQuery(sheetData.get("Query"));
				this.close();
				
				if (count ==  0) {
					//return false;
					
				}
			}
		}
		return true;
	}

	public Object[][] getDBDataAsArray(ResultSet rs, Object[] keys) {

		TestReportsLog.log(LogStatus.INFO, "Converting ResultSet data to Array");
		int rows = getCount(rs);
		Object[][] data = new Object[rows][1];
		try {
			int cols = keys.length;

			// read the data
			int dataRow = 0;
			StringHash table = null;
			
			rs.beforeFirst();
			while (rs.next()) {
				table = new StringHash();
				for (int cNum = 0; cNum < cols; cNum++) {

					String key = keys[cNum].toString();
					String value = rs.getString(key);
					if (value == null) {
						value = "";
					}
					table.put(key, value);

				}
				data[dataRow][0] = table;
				dataRow++;
			}
		} catch (SQLException e) {
			TestReportsLog.log(LogStatus.ERROR, "PostGreSQL ::- getDBDataAsArray" + e.getMessage());
		}

		TestReportsLog.log(LogStatus.INFO, "Data conversion from ResultSet to Array completed");
		return data;
	}
}
