package com.javacodegeeks.examples.jersey;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.app.bussinesLayer.Bussiness;
import com.app.bussinesLayer.Message;
import com.app.bussinesLayer.Person;
import com.app.bussinesLayer.User;
import com.app.dao.DAOPerson;
import com.app.dao.DaoUser;
import com.app.security.Rsa;
import com.app.util.Utilities;

@Path("/session")
public class Session {
	@Context private HttpServletRequest request;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message SessionOp(Message m) {
		Message mn = new Message();
		
		if(m.getOp().equalsIgnoreCase("init")){
			try {
				User u = (User)Utilities.bytetoObject(Rsa.decipherLongData(m.getB(),Bussiness.getPrivateKeyServer()));
				//DaoUser daou=new DaoUser();
				Person p=DAOPerson.getByUsername(u.getEmail());
				if(  p!=null &&  p.getUser().getPassword().equals(u.getPassword())){
					PublicKey pu = (PublicKey)Utilities.bytetoObject(p.getPublicKey());
					p.setPublicKey(null);
					p.setUser(null);
					mn.setData("init","ok",Rsa.cipherLongData(Utilities.objToByte(p), pu));
					//HttpSession session=request.getSession(true);
					//request.get
				}else{
					mn.setData("init","User o Password was incorrec!", null);
				}
			} catch (InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException
					| IllegalBlockSizeException | BadPaddingException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				mn.setData("init","FAIL LOGIN", null);
			}
		}
		return mn;
	}
	
}
