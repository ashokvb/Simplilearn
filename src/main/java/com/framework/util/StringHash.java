package com.framework.util;

import java.util.Hashtable;
import com.framework.util.TestReportsLog;
import com.relevantcodes.extentreports.LogStatus;

public class StringHash extends Hashtable<String , String>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public synchronized String get(Object key) {
		// TODO Auto-generated method stub
		try {
			return super.get(key).toString();
		}
		catch(NullPointerException e) {
			   TestReportsLog.log(LogStatus.ERROR, "Data with the name - " + key.toString() +" not Found in the Excel");
			   System.out.println(key.toString() + " - Data not found");
			   org.testng.Assert.fail(key.toString() + " - Data not found");
		}
		return "null";
	}
	
	/*public static Object strBuffer(String val) {
		
		StringBuffer sB = new StringBuffer(val);
		
		return sB;
		
	}*/
}
