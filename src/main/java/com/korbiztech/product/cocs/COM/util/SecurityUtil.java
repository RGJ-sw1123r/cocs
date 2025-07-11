package com.korbiztech.product.cocs.COM.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityUtil {
	
	private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static SecureRandom rnd = new SecureRandom();
	
	public static String randomString(int len){
		StringBuilder sb = new StringBuilder(len);
		for(int i = 0; i < len; i++) {
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		}
		return sb.toString();
	}
	
	public static String generateHash(String input) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hash = md.digest(input.getBytes(StandardCharsets.UTF_8));
		BigInteger number = new BigInteger(1, hash);
		StringBuilder hexString = new StringBuilder(number.toString(16));
		
		while (hexString.length() < 32) {
			hexString.insert(0, '0');
		}
		return hexString.toString();
	}
	
	public static String encodePasswordWithBCrypt(String plainPassword) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(plainPassword);
	}
	
}
