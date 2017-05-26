package com.javacodegeeks.examples.jersey;


import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.app.bussinesLayer.Bussiness;
import com.app.bussinesLayer.Message;
import com.app.bussinesLayer.Person;
import com.app.bussinesLayer.User;
import com.app.bussinesLayer.insertPru;
import com.app.security.Rsa;
import com.app.util.Utilities;

@Path("/sent")

public class AuthorService2 {
	//@Path("/GetHrMsg/json_data")
	//@Consumes(MediaType.APPLICATION_JSON)
	/*
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Message gethrmessage() {
	    //System.out.println(requestBody.hello);
	    //System.out.println(requestBody.foo);
		Message m=new Message();
	
		PublicKey s;
		try {
			s = Bussiness.getPublicKeyServer();
			Person p=new Person();
			User u = new User();
			u.set("mausds@hotmail.com","adasdas");
			p.set("BARMASDA","EL MAURICIO","DIRECCIONC AASDASD","1234534564",Utilities.objToByte(s),u,"123456789");
			byte ob[]=Utilities.objToByte(p);
			ob=Rsa.cipherLongData(ob,s);
			m.setData("Register","value",ob);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
		
	}
	*/
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Message gethrmessage() {
	    //System.out.println(requestBody.hello);
	    //System.out.println(requestBody.foo);
		Message m=new Message();
	
		PublicKey s;
		try {
			s = Bussiness.getPublicKeyServer();
			//Person p=new Person();
			User u = new User();
			u.set("mausds@hotmail.co","adasdas");
			//p.set("BARMASDA","EL MAURICIO","DIRECCIONC AASDASD",23423,Utilities.objToByte(s),u,123456789);
			byte ob[]=Utilities.objToByte(u);
			ob=Rsa.cipherLongData(ob,s);
			m.setData("init","Session",ob);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
		
	}
	
	
	
	
	
}