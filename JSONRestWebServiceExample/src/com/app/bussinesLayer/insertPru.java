package com.app.bussinesLayer;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class insertPru  {

	@XmlElement
	public byte[]b;
	@XmlElement
	public String name;
	/*
	public insertPru(String name,byte[] b){
		this.name=name;
		this.b=b;
	}*/
}
