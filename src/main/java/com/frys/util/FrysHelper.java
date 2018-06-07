package com.frys.util;

public class FrysHelper {

	public static boolean isValueNull(Object obj) {
		return (obj == null) ? true : false;
	}
	
	public static boolean isValueNotNull(Object obj) {
		return !isValueNull(obj);
	}
	
	
}
