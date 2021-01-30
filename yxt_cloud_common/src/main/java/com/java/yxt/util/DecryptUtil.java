package com.java.yxt.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * 文 件 名: DecryptUtil.java
 * @description <描述>
 * @author shilihua
 * @version V1.0
 * @date 2017年4月20日
 */
public class DecryptUtil
{
	private static final String KEY_AES = "AES";

	//初始化向量
	private static final byte[] KEYBYTES = { 0x12, 0x34, 0x56, 0x78, (byte) 0x90, (byte) 0xAB, (byte) 0xCD, (byte) 0xEF, 0x12, 0x34, 0x56, 0x78,
	        (byte) 0x90, (byte) 0xAB, (byte) 0xCD, (byte) 0xEF };

	/**
	 * 方法名 encrypt
	 * @description <AES + Base64加密>
	 * @param src 要加密的明文
	 * @param key 秘钥
	 * @return 机密后的密文
	 * @throws Exception
	 * @author shilihua
	 * @version V1.0
	 * @date 2017年4月20日
	 */
	public static String encrypt( String src, String key ) throws Exception
	{
		if (key == null || key.length() != 14) { throw new Exception( "key不满足条件" ); }
		// 必须满足16位秘钥
		key = key + "00";

		//构建密钥规范对象
		SecretKeySpec skeySpec = new SecretKeySpec( key.getBytes(), KEY_AES );
		//根据指定模式创建密码器：参数："算法/模式/补码方式"
		Cipher cipher = Cipher.getInstance( "AES/CBC/PKCS5Padding" );
		//指定初始化向量
		IvParameterSpec iv = new IvParameterSpec( KEYBYTES );
		//初始化密码器：参数：(加密/解密，密钥规范，初始化向量(可无))
		cipher.init( Cipher.ENCRYPT_MODE, skeySpec, iv );
		//根据指定的参数执行加密/解密
		byte[] encrypted = cipher.doFinal( src.getBytes() );
		src = byte2hex( encrypted );

		// Base64二次加密
		byte[] btyeArray = src.getBytes( "utf-8" );
		src = new BASE64Encoder().encode( btyeArray );

		return src;
	}

	/**
	 * 方法名
	 * @description <Base64 + ASE解密>
	 * @param src 加密后的密文
	 * @param key 秘钥
	 * @return 解密后的明文
	 * @throws Exception
	 * @author shilihua
	 * @version V1.0
	 * @date 2017年4月20日
	 */
	public static String decrypt( String src, String key ) throws Exception
	{
		if (key == null || key.length() != 14) { throw new Exception( "key不满足条件" ); }
		// 必须满足16位秘钥
		key = key + "00";

		// 先Base64解密
		byte[] byteArray = null;
		BASE64Decoder decoder = new BASE64Decoder();
		byteArray = decoder.decodeBuffer( src );
		src = new String( byteArray, "utf-8" );

		//构建密钥规范对象
		SecretKeySpec skeySpec = new SecretKeySpec( key.getBytes(), KEY_AES );
		//根据指定模式创建密码器：参数："算法/模式/补码方式"
		Cipher cipher = Cipher.getInstance( "AES/CBC/PKCS5Padding" );
		//指定初始化向量
		IvParameterSpec iv = new IvParameterSpec( KEYBYTES );
		//初始化密码器：参数：(加密/解密，密钥规范，初始化向量(可无))
		cipher.init( Cipher.DECRYPT_MODE, skeySpec, iv );
		byte[] encrypted1 = hex2byte( src );
		//根据指定的参数执行加密/解密
		byte[] original = cipher.doFinal( encrypted1 );
		String originalString = new String( original );
		return originalString;
	}

	/**
	 * 方法名
	 * @description <将加密后密文数组转换成字符串>
	 * @param b
	 * @return
	 * @author shilihua
	 * @version V1.0
	 * @date 2017年4月20日
	 */
	private static String byte2hex( byte[] b )
	{
		String hs = "";
		String stmp = "";
		for ( int n = 0; n < b.length; n++ )
		{
			stmp = ( java.lang.Integer.toHexString( b[n] & 0XFF ) );
			if (stmp.length() == 1)
			{
				hs = hs + "0" + stmp;
			}
			else
			{
				hs = hs + stmp;
			}
		}
		return hs.toUpperCase();
	}

	/**
	 * 方法名
	 * @description <将加密后密文字符串转换成密文数组>
	 * @param strhex
	 * @return
	 * @author shilihua
	 * @version V1.0
	 * @date 2017年4月20日
	 */
	private static byte[] hex2byte( String strhex )
	{
		if (strhex == null) { return null; }
		int l = strhex.length();
		if (l % 2 == 1) { return null; }
		byte[] b = new byte[l / 2];
		for ( int i = 0; i != l / 2; i++ )
		{
			b[i] = (byte) Integer.parseInt( strhex.substring( i * 2, i * 2 + 2 ), 16 );
		}
		return b;
	}

	public static void main( String[] args ) throws Exception
	{
		//		String testSrc = "{\"strName\":\"java\",\"strPwd\":\"123456\"}";
		//		testSrc = encrypt( testSrc, "20170711085432" );
		//
		//		System.out.println( "-------" + testSrc + "--------" );
		//
		//		testSrc = decrypt( testSrc, "20170711085432" );
		//		System.out.println( "-------" + testSrc + "--------" );
		String drc = decrypt(
		        "MDc0QzEwMTJGQjk3QkQ2N0FDMkQ3RUYxOTMyMEFEMEYxNDRBQTk1OUNBNTMwMEUzMjhBRUY5QTFCNTEwMjE1QjIzNTk2OURBRjVERjIzMDFBQjlGQzZBNTJBM0EzNDQ3",
		        "20170804090226" );
		System.out.println( drc );
	}
}
