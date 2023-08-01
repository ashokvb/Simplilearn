package com.framework.util;

import java.util.Base64;

public class Encrypt {
public static String decodeString(String encodedData) {
	byte[] decodeBytes = Base64.getDecoder().decode(encodedData.getBytes());
	return new String(decodeBytes);
	
}

public static String encodeString(String encryptData) {		
	byte[] encodedBytes = Base64.getEncoder().encode(encryptData.getBytes());
	return new String(encodedBytes);	
}
}