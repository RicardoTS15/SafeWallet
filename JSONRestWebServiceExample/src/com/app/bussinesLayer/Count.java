package com.app.bussinesLayer;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "CountNum")
public class Count {
	@XmlElement
	@Id
	@Column(name="RFC")
	String CountNum;
	@XmlElement 
	@Column(name="mount")
	double mount;
	@XmlElement 
	@Column(name="idType")
	int idType;
	@XmlElement
	@Column(name="InitDate")
	Date date;
	
	public String toString(){
		return "Count["+CountNum+mount+date+"]";
	}
	
}
