package com.encdsc1;

public class AESPasswordEncryptDecrypt {

	  public static void main(String[] args) {

	    // Define your secret key and salt (keep these secure and don't hardcode in production)
	    String secretKey = "MySecretKey";
	    String salt = "MySalt";

	    // String to be encrypted
	    String originalString = "Hello, this is a secret message.";

	    // Encrypt the string
	    String encryptedString = AES256Encripter.encrypt(originalString, secretKey, salt);
	    if (encryptedString != null) {
	       System.out.println("Encrypted: " + encryptedString);
	    } else {
	        System.err.println("Encryption failed.");
	        return;
	    }
	   // Decrypt the string
	    String decryptedString = AES256Decripter.decrypt(encryptedString, secretKey, salt);
	    if (decryptedString != null) {
	        System.out.println("Decrypted: " + decryptedString);
	    } else {
	        System.err.println("Decryption failed.");
	    }
	  }
	}