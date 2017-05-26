package com.app.security;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.security.*;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;



public class Rsa {
	private static final String PRIVATE_KEY_FILE ="privateKey.key";
	private static final String PUBLIC_KEY_FILE = "publicKey.key";
	private static final String ALGORITHM = "RSA";
	private static Cipher cipher;
	public static final int bufSize=240;
	public static final int bufSizeDe=256;
	
	public static void init() throws NoSuchAlgorithmException, NoSuchPaddingException {
		cipher=Cipher.getInstance("RSA");
	}

	
	public static boolean verify(byte[] indata, byte[] inSign, PublicKey publicKey) throws Exception {
        Signature publicSignature = Signature.getInstance("SHA256withRSA");
        publicSignature.initVerify(publicKey);
        publicSignature.update(indata);
        return publicSignature.verify(inSign);
    }
	
	public static byte[] sign(byte[] inData, PrivateKey privateKey) throws Exception {
        Signature privateSignature = Signature.getInstance("SHA256withRSA");
        privateSignature.initSign(privateKey);
        
        privateSignature.update(inData);

       return privateSignature.sign();
    }
	
	public static byte[] cipher(byte[] data,Key key) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException{
		cipher=Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE,  key);
        return cipher.doFinal(data);
        
	}
	
	/**********************CIPHER LONG DATA
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 * @throws IOException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException **************************************/
	
	public static byte[] cipherLongData(byte d[],Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException{
		cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE,key);
        ByteArrayOutputStream ous = new ByteArrayOutputStream();
        InputStream ios =  new ByteArrayInputStream(d);
         byte[] buffer = new byte[bufSize];
        byte[] cipherData;
        while ((ios.read(buffer)) != -1) {
            cipherData=cipher.doFinal(buffer);
            ous.write(cipherData, 0, cipherData.length);
        }
        cipherData=ous.toByteArray();
        ous.close();
        ios.close();
        return cipherData;
	}
	
	public static byte[] decipherLongData(byte d[],Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException{
		byte[] buffer = new byte[bufSizeDe];
        byte[] decipherData=null;
		cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE,key); 
        ByteArrayOutputStream ous  = new ByteArrayOutputStream();
        InputStream ios= new ByteArrayInputStream(d);
        while ((ios.read(buffer)) != -1) {
            decipherData=cipher.doFinal(buffer);
            ous.write(decipherData, 0, decipherData.length);
        }
        decipherData=ous.toByteArray();
        ous.close();
        ios.close();
        return decipherData;
	}
	
	
	
	
	
	
	
	public static void generateKey() {
	    try {
	      final KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
	      //keyGen.initialize(2048,new SecureRandom());
	      keyGen.initialize(2048);
	       
	      final KeyPair key = keyGen.generateKeyPair();
	     

	      File privateKeyFile = new File(PRIVATE_KEY_FILE);
	      File publicKeyFile = new File(PUBLIC_KEY_FILE);

	      // Create files to store public and private key
	      if (privateKeyFile.getParentFile() != null) {
	        privateKeyFile.getParentFile().mkdirs();
	      }
	      privateKeyFile.createNewFile();

	      if (publicKeyFile.getParentFile() != null) {
	        publicKeyFile.getParentFile().mkdirs();
	      }
	      publicKeyFile.createNewFile();

	      // Saving the Public key in a file
	      ObjectOutputStream publicKeyOS = new ObjectOutputStream(
	          new FileOutputStream(publicKeyFile));
	      publicKeyOS.writeObject(key.getPublic());
	      publicKeyOS.close();

	      // Saving the Private key in a file
	      ObjectOutputStream privateKeyOS = new ObjectOutputStream(
	          new FileOutputStream(privateKeyFile));
	      privateKeyOS.writeObject(key.getPrivate());
	      privateKeyOS.close();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }

	  }
	
	

	
	public static void main (String args[]){
		generateKey();
	}
}
