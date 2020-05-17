package com.sql.utils;

import java.sql.Date;

public class Emp {
private String uname;
private int id;
private Date date;
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public Emp(String uname, int id, Date date) {
	super();
	this.uname = uname;
	this.id = id;
	this.date = date;
}

}
