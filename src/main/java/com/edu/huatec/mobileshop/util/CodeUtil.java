package com.edu.huatec.mobileshop.util;

import java.util.Random;





public class CodeUtil {

	public static String getCode(int len){
		

		String a = "1234567890";
		

		Random r = new Random();
		

		char[] c = new char[len];
		
		for (int i = 0; i < c.length; i++) {
			c[i] = a.charAt(r.nextInt(a.length()));
		}
		
		
		return new String(c);
		
	}
}