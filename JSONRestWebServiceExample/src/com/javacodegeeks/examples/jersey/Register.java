package com.javacodegeeks.examples.jersey;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.transaction.SystemException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.JDBCException;

import com.app.bussinesLayer.Bussiness;
import com.app.bussinesLayer.Message;
import com.app.bussinesLayer.Person;
import com.app.dao.DAOPerson;
import com.app.security.Rsa;
import com.app.util.Utilities;

@Path("/register")
public class Register {
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message registerUser(Message mn) throws IllegalStateException, SystemException{
		Message m=new Message();
		
		try{
			//DAOPerson.Register(u);
			byte ob[] = Rsa.decipherLongData(mn.getB(),Bussiness.getPrivateKeyServer());
			Person p = (Person)Utilities.bytetoObject(ob);
			System.out.println("Publickey :" +p.getPublicKey().length);
			System.out.println("USer :"+p.getUser().toString());
			System.out.println(p);
			DAOPerson.Register(p);
			m.setData("ok","User has been regitered!",null);
		}catch(JDBCException e){
			SQLException s=(SQLException)e.getCause();
			switch(s.getErrorCode()){
				case 1062:
						m.setData("Error","User already registered!",null);
					break;
				case 1205:
						m.setData("Error","TIME OUT!",null);
					break;
					
				default:
						m.setData("Error","User has not been regitered!",null);
					break;
				
			}
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
		
	}
	
}
