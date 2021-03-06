package encrypt;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

public class EncTestMain {

	public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, GeneralSecurityException {
		// TODO Auto-generated method stub

		String str = "HELLO JAVA";
		Sha256 sha256 = new Sha256();
		
		
		String encStr = sha256.encrypt(str);
		
		System.out.println("평문 : "+str);
		System.out.println("SHA-256 암호화 : "+encStr);
		System.out.println(sha256.encrypt("1"));
		System.out.println(sha256.encrypt("1"));
		System.out.println(sha256.encrypt("1234567890abcdef"));
		System.out.println(sha256.encrypt("1").length());
		
		
		
		// 양방향 암호화 객체 : AES
		//key : 16자리
		String key = "0000000000000001";
		String key2 = "0000000000000002";

		AES256Util aes256Util = new AES256Util(key);
		AES256Util aes256Util2 = new AES256Util(key2);

		System.out.println("==================================================================");
		
		String encStr1 = aes256Util.encrypt(str);
		String encStr2 = aes256Util2.encrypt(str);
		
		System.out.println("==================================================================");
		
		// 암호화
		System.out.println("평문 : "+ str);
		System.out.println("AES를 이용한 암호화 : "+ encStr1);
		System.out.println("AES를 이용한 암호화 : "+ encStr2);

		System.out.println("==================================================================");

		
		System.out.println("AES를 이용한 암호화 : "+aes256Util.encrypt(str));

		String plainStr1 = aes256Util.decrypt(encStr1);
		String plainStr2 = aes256Util2.decrypt(encStr2);

	}

}
