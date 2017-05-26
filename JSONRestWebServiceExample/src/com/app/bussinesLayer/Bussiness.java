package com.app.bussinesLayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.PublicKey;

import com.app.util.Utilities;

public class Bussiness {
	public static PublicKey getPublicKeyServer() throws FileNotFoundException, ClassNotFoundException, IOException{
		return (PublicKey)Utilities.readObject("C:\\Users\\Mauricio\\workspace\\JSONRestWebServiceExample\\publicKey.key");
	}
	
	public static PrivateKey getPrivateKeyServer() throws FileNotFoundException, ClassNotFoundException, IOException{
		return (PrivateKey)Utilities.readObject("C:\\Users\\Mauricio\\workspace\\JSONRestWebServiceExample\\privateKey.key");
		
	}
	
	
	
}
