package com.app.bussinesLayer;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	@XmlElement 
	private String op;
	@XmlElement 
	private byte[] b;
	@XmlElement 
	private String message;
	
	/*public Message(String op,String message){
		this.op=op;
		this.message=message;
	}
	public Message(String op,String message,byte[] d){
		this.op=op;
		this.message=message;
		this.b=d;
	}*/
	
	public void setData(String op,String message,byte[] d){
		this.op=op;
		this.message=message;
		this.b=d;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public byte[] getB() {
		return b;
	}
	public void setB(byte[] b) {
		this.b = b;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
