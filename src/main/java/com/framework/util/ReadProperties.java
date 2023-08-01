package com.framework.util;

import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
    
	public static Properties getConfigProp(){
		Properties prop=new Properties();
	    try{
	    	ClassLoader loader = Thread.currentThread().getContextClassLoader();
	    	InputStream resourceStream = loader.getResourceAsStream("config.properties");
	    	prop.load(resourceStream);
	    	resourceStream.close();
	    }
	    catch(Exception e) {
	        System.out.print("error file to stream: ");
	        System.out.println(e.getMessage());
	    }
	    return  prop;
	}
	
	public static Properties getTestRailProp(){
		Properties prop=new Properties();
	    try{
	    	ClassLoader loader = Thread.currentThread().getContextClassLoader();
	    	InputStream resourceStream = loader.getResourceAsStream("testrail.properties");
	    	prop.load(resourceStream);
	    	resourceStream.close();
	    }
	    catch(Exception e) {
	        System.out.print("error file to stream: ");
	        System.out.println(e.getMessage());
	    }
	    return  prop;
	}
}
