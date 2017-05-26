package com.app.bussinesLayer;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "user")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1865995013575150859L;
	@XmlElement 
	@Id
	@Column(name="email")
	private String email;
	@XmlElement 
	@Column(name="password")
	private String password;

	public void set(String email,String password){
		this.email=email;
		this.password=password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String toString(){
		return "User=["+email+","+password+"]";
	}

}
