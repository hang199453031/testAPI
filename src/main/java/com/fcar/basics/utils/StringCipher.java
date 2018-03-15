//package com.fcar.basics.utils;
//
//import java.io.UnsupportedEncodingException;
//import java.net.URLDecoder;
//import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
//import java.security.NoSuchProviderException;
//
//import javax.crypto.BadPaddingException;
//import javax.crypto.Cipher;
//import javax.crypto.IllegalBlockSizeException;
//import javax.crypto.NoSuchPaddingException;
//import javax.crypto.SecretKey;
//import javax.crypto.spec.SecretKeySpec;
//
//import org.apache.commons.codec.binary.Base64;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//
///**
// * A simple text cipher to encrypt/decrypt strings.
// */
//public class StringCipher {
//    private static final Logger logger = LoggerFactory.getLogger(StringCipher.class);
//	private static String defaultKey = "252s1rr5"; // secret key length must be 8
//	private static Base64 base64Encoder;
//
//	static {
//	    base64Encoder = new Base64();
//	}
//	
//    /**
//     * Encrypts the given string using the specified key. The key must be 8
//     * chars long
//     * 
//     * @param plainText
//     *            Text to encrypt
//     * @param key
//     *            Key used by the encryption algorithm
//     * @return Encrypted text
//     * @throws InvalidKeyException
//     * @throws IllegalBlockSizeException
//     * @throws BadPaddingException
//     * @throws NoSuchPaddingException
//     * @throws NoSuchProviderException
//     * @throws NoSuchAlgorithmException
//     */
//    public static String encrypt(String plainText, String key) throws InvalidKeyException,
//            IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchProviderException,
//            NoSuchPaddingException {
//
//        // Init cipher
//        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding", "SunJCE");
//        SecretKey secretKey = new SecretKeySpec(key.getBytes(), "DES");
//        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
//
//        byte[] cipherText = cipher.doFinal(plainText.getBytes());
//        String encrypted = new String(base64Encoder.encode(cipherText));
//        return encrypted.replaceAll("\\=", "-"); // Prevent equal chars in encrypted code
//    }
//    
//    /**
//     * Decrypts the given encrypted text using the given key. The key must be 8
//     * chars long
//     * 
//     * @param encryptedText
//     *            Text to decrypt
//     * @param key
//     *            Key used by the encryption algorithm
//     * @return
//     * @throws InvalidKeyException
//     * @throws IllegalBlockSizeException
//     * @throws BadPaddingException
//     * @throws NoSuchAlgorithmException
//     * @throws NoSuchProviderException
//     * @throws NoSuchPaddingException
//     */
//    public static String decrypt(String encryptedText, String key) throws InvalidKeyException,
//            IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchProviderException,
//            NoSuchPaddingException {
//
//        // Init cipher
//        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding", "SunJCE");
//        SecretKey secretKey = new SecretKeySpec(key.getBytes(), "DES");
//        cipher.init(Cipher.DECRYPT_MODE, secretKey);
//
//        encryptedText = encryptedText.replaceAll("-", "="); // Decode equal char replacement in encrypted code
//        byte[] encypted = base64Encoder.decode(encryptedText.getBytes());
//        byte[] decrypted = cipher.doFinal(encypted);
//        return new String(decrypted);
//    }
//    
//    /**
//     * Encrypt using default key
//     * 
//     * @param plainText
//     *            Text to encrypt
//     * @return
//     * @throws NoSuchPaddingException
//     * @throws NoSuchProviderException
//     * @throws NoSuchAlgorithmException
//     * @throws BadPaddingException
//     * @throws IllegalBlockSizeException
//     * @throws InvalidKeyException
//     */
//    public static String encrypt(String plainText) throws InvalidKeyException, IllegalBlockSizeException,
//            BadPaddingException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException {
//        return encrypt(plainText, defaultKey);
//    }
//
//    /**
//     * Decrypt using default key
//     * 
//     * @param encryptedText
//     *            Text to decrypt
//     * @return
//     * @throws InvalidKeyException
//     * @throws IllegalBlockSizeException
//     * @throws BadPaddingException
//     * @throws NoSuchAlgorithmException
//     * @throws NoSuchProviderException
//     * @throws NoSuchPaddingException
//     * @throws UnsupportedEncodingException 
//     */
//    public static String decrypt(String encryptedText) throws InvalidKeyException, IllegalBlockSizeException,
//            BadPaddingException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, UnsupportedEncodingException {
//      String urlDecodeText = encryptedText;
//      if (urlDecodeText.contains("%")) {
//        urlDecodeText = URLDecoder.decode(encryptedText, "utf-8");
//      }
//      return decrypt(urlDecodeText, defaultKey);
//    }
//
//	public static void main(String[] args) throws Exception {
//		String original = "78893";
//
//		String encrypted = encrypt(original);
//		String decrypted = decrypt(encrypted);
//
//		logger.info("Original: {} : [original : {}] ",original,original);
//		logger.info("Encrypted: {} : [encrypted : {}] ",encrypted,encrypted);
//		logger.info("Decrypted: {} : [decrypted : {}] ",decrypted,decrypted);
//	}
//}
