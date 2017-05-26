package com.app.util;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.omg.CORBA.DataOutputStream;

import com.app.bussinesLayer.User;

public class Utilities {
	static final Base64 base64 = new Base64();

    public static String serializeObjectToString(Object object) throws IOException {
        try (
                ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
                GZIPOutputStream gzipOutputStream = new GZIPOutputStream(arrayOutputStream);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(gzipOutputStream);) {
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            return new String(base64.encode(arrayOutputStream.toByteArray()));
        }
    }

    public static Object deserializeObjectFromString(String objectString) throws IOException, ClassNotFoundException, DecoderException {
        try (
                ByteArrayInputStream arrayInputStream = new ByteArrayInputStream( (byte[]) base64.decode(objectString));
                GZIPInputStream gzipInputStream = new GZIPInputStream(arrayInputStream);
                ObjectInputStream objectInputStream = new ObjectInputStream(gzipInputStream)) {
            return objectInputStream.readObject();
        }
    }
    
	public static byte[] objToByte(Object o) throws IOException{
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutput out = null;
			byte[] yourBytes=null;
			try {
			  out = new ObjectOutputStream(bos);   
			  out.writeObject(o);
			  out.flush();
			 yourBytes = bos.toByteArray();
		
			} finally {
			  try {
			    bos.close();
			  } catch (IOException ex) {
			   ex.printStackTrace();
			  }
			}
			return yourBytes;
			
		}
	
	public static Object bytetoObject(byte[] d) throws IOException, ClassNotFoundException{
		
		ByteArrayInputStream bis = new ByteArrayInputStream(d);
		ObjectInput in = null;
		Object o =null;
		try {
		  in = new ObjectInputStream(bis);
		  o= in.readObject(); 
		} finally {
		  try {
		    if (in != null) {
		      in.close();
		    }
		  } catch (IOException ex) {
		    ex.printStackTrace();
		  }
		}
		return o;

	}

   /* public static void main(String args[]) throws IOException, ClassNotFoundException, DecoderException{
    	User u = new User("email","Password");
    	System.out.println(serializeObjectToString(u));
    	System.out.println(((User)deserializeObjectFromString(serializeObjectToString(u))).toString());
    	
    }*/
    
    public static Object readObject(String filename) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fi = new FileInputStream(new File(filename));
        ObjectInputStream oi = new ObjectInputStream(fi);
        Object o= oi.readObject();
        oi.close();
        fi.close();
        return o;
    }
    
}
