package com.ihk.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

/**
 * 密码加密帮助类
 * @author dtc
 * 2012-9-29
 */
public class Md5Security {
	// todo:密钥是否加密后存放呢？

	/**
	 * 解密 src为要加密的内容,key为解密的基准
	 */
	private static String decString(String src, String key) {
		// if (src == null || key == null) {
		if (src == null) {
			return null;
		}

		String pass = null;
		MessageDigest md;

		try {
			md = MessageDigest.getInstance("MD5");
			md.update(key.getBytes());
			byte[] byteMd5key = md.digest();
			byte[] byteSrc = hex2byte(src);

			if (byteSrc.length <= byteMd5key.length) {
				byte[] byteResult = new byte[byteSrc.length];
				for (int i = 0; i < byteSrc.length; i++) {
					byteResult[i] = new Integer(byteSrc[i] ^ byteMd5key[i])
							.byteValue();
				}
				pass = new String(byteResult);
			} else {
				byte[] byteMd5KeyA = new byte[byteSrc.length
						+ byteMd5key.length];
				for (int i = 0; i < byteSrc.length; i += byteMd5key.length) {
					System.arraycopy(byteMd5key, 0, byteMd5KeyA, i,
							byteMd5key.length);
				}
				byte[] byteResult = new byte[byteSrc.length];
				for (int i = 0; i < byteSrc.length; i++) {
					byteResult[i] = new Integer(byteSrc[i] ^ byteMd5KeyA[i])
							.byteValue();
				}
				pass = new String(byteResult);
			}
		} catch (NoSuchAlgorithmException e) {
			pass = null;
		}

		return pass;
	}

	/**
	 * byte转二进制字符串
	 */
	private static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = Integer.toHexString(b[n] & 0XFF);
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
			}
		}
		return hs;
	}

	/**
	 * 二进制字符串转byte
	 */
	private static byte[] hex2byte(String s) {
		byte[] hs = new byte[s.length() / 2];
		for (int i = 0, j = 0; i < s.length(); i += 2, j++) {
			String s1 = s.substring(i, i + 2);
			hs[j] = Integer.valueOf(s1, 16).byteValue();
		}
		return hs;
	}

	private final static String key = "";

	public static String encString(String pwd) {
		return encrypt(pwd);
	}

	public static String decString(String pwd) {
		return decString(pwd, key);
	}

	private static String encrypt(String inputText) {
		if (inputText == null) {
			return null;
		}
		String encryptText = null;
		try {
			MessageDigest m = MessageDigest.getInstance("md5");
			
			m.update(inputText.getBytes("UTF8"));
			byte s[] = m.digest();
			
			//System.out.println(m.toString());
			//byte s[] = m.digest(inputText.getBytes("UTF8"));
			return hex(s);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encryptText;
	}

	// 返回十六进制字符串
	private static String hex(byte[] arr) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; ++i) {
			sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1,3));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Set<String> a = new HashSet<String>();
		a.add("abc");
		a.add("abc");
		
		for(String ou:a){
			System.out.println(ou);
		}
		
		System.out.println(a.size());
	}

}
