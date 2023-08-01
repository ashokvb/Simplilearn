package com.framework.restAPI;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.framework.util.ReadProperties;

public class URL {

	String URL;
	String urlParam;
	
	public URL(String url, String urlParam) {
		url =  url.replaceAll("%SERVER%", ReadProperties.getConfigProp().getProperty("server"));
		this.URL = url;
		this.urlParam = urlParam;
	}
	
	public URL(String currentUrl) {
		// TODO Auto-generated constructor stub
	}

	public String getURL() {
		return this.URL + this.urlParam;
	}

	public InputStream openStream() {
		// TODO Auto-generated method stub
		return null;
	}	
	
}
