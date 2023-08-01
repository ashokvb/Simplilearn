package com.framework.common;

public class WebHelper {
	
	  /**
	   * Returns the test environment (defaulting to uat)
	   *
	   * @return testEnvironment
	   */
	  public static String getTestEnvironment() {
	    return System.getProperty("environment", "uat").toLowerCase();
	  }

}
