package com.framework.common;

public class Constants {


	  /** Test Groups */
	  public static final class TestNGGroups {

	    public static final String SMOKE = "smoke";

	  }
	  
	  public enum TestEnvironment {
		    dev("http://9901dwebnhv01:93/login"),
		    qa("http://9901twebhznv01:93/"),
		    uat("https://sisclientweb-tst-300924.campusnexus.cloud");
				 
		    private String environment;

		    TestEnvironment(String env) {
		      this.environment = env;
		    }

		    public String getEnvironment() {
		      return environment;
		    }
		  }
	  
	  
	  public enum DOBOffset {
		    MINOR(-5475),
		    ABOVE55(-21170),
		    LESSTHAN55(-13650);
				 
		    private int offset;

		    DOBOffset(int ageType) {
		      this.offset = ageType;
		    }

		    public int getDOBOffset() {
		      return offset;
		    }
		  }
	  
	  public static class TestData {
		  
		    public static final String BASE_HOME_URL =
		            TestEnvironment.valueOf(WebHelper.getTestEnvironment()).getEnvironment();
		    
		    	    
		  
	  }
	  
}