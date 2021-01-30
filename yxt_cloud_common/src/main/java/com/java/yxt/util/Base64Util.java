/**
 * 文 件 名:    Base64.java  
 * @description <描述>  
 * @author   YuPeiLiang
 * @version  V1.0
 * @date	 2016年6月24日
 */
package com.java.yxt.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * 文 件 名: Base64.java
 * 
 * @description <描述>
 * @author YuPeiLiang
 * @version V1.0
 * @date 2016年6月24日
 */
public class Base64Util {
	public static String decode(String s) throws UnsupportedEncodingException {
		return new String(Base64.getDecoder().decode(s), "utf-8");
	}

	public static String encode(String s) {
		return Base64.getEncoder().encodeToString(s.getBytes());
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
//		String s = "1742sp";
//		String s64 = getBase64(s);
//		System.out.println(s64);
//		System.out.println(getFromBase64("MTc0MnNw"));
//		System.out.println(decode("MTc0MnNw"));

	}
}
