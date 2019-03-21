package com.example.demo.main.security;

import java.security.MessageDigest;

import org.springframework.security.crypto.password.PasswordEncoder;

public class BCryctPasswordEncoder implements PasswordEncoder {

	
	private static final char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	/**此字符串相当于加密用的串，数据校验时结果不会被猜测。*/
	private static final String default_key = "dAA%D#V*2a9r4I!V";
	@Override
	public String encode(CharSequence arg0) {
		try {
			String s=arg0.toString();
			byte[] strTemp = s.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean matches(CharSequence arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

}
