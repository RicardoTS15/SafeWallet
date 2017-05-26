package com.javacodegeeks.examples.jersey;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.app.bussinesLayer.User;
import com.app.bussinesLayer.insertPru;
import com.app.util.Utilities;

@Path("/object")
public class AuthorService {
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void readPet(insertPru p) throws ClassNotFoundException, IOException{
		System.out.println(  p.name + " "+ ((User)Utilities.bytetoObject(p.b)));
		//System.out.println("Hola" );
	}
	
	
}
