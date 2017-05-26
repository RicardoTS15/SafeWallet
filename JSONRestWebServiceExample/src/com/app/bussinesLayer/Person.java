package com.app.bussinesLayer;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
@Entity
@Table(name = "Person")
public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5132776950854744926L;
	@XmlElement 
	@Id
	@Column(name="RFC")
	String RFC;
	@XmlElement 
	@Column(name="Name")
	String Name;
	@XmlElement 
	@Column(name="Address")
	String Address;
	@XmlElement 
	@Column(name="PhoneNum")
	String PhoneNum;
	@XmlElement 
	//@Column(name="PublicKey")
	byte[] PublicKey;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email")
	User user;
	/*@XmlElement 
	 @OneToOne(cascade = CascadeType.ALL, mappedBy="Person")
	User user;*/
	@XmlElement
	@Column(name="countNum")
	String count;
	
	/*@XmlElement 
	@Column(name="email")
	String email ;*/


	public String toString(){
		return "Person ["+ RFC+","+Name + Address+ "]" ;
	}
	
	
	public void set(String rFC, String name, String address, String phoneNum, byte[] publicKey, User user, String count){
		RFC = rFC;
		Name = name;
		Address = address;
		PhoneNum = phoneNum;
		PublicKey = publicKey;
		this.user = user;
		this.count = count;
	}


	public String getRFC() {
		return RFC;
	}


	public void setRFC(String rFC) {
		RFC = rFC;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getPhoneNum() {
		return PhoneNum;
	}


	public void setPhoneNum(String phoneNum) {
		PhoneNum = phoneNum;
	}


	public byte[] getPublicKey() {
		return PublicKey;
	}


	public void setPublicKey(byte[] publicKey) {
		PublicKey = publicKey;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getCount() {
		return count;
	}


	public void setCount(String count) {
		this.count = count;
	}
	
	
}
