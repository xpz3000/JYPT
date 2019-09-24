

package com.jypt.model;

import java.io.InputStream;



public class Good {
	
 private int id;
 private String goodname;
 private String goodtype;
 private String goodprice;
 private String adress;
 private String photo;
 private String username;
 private String buyname;

 private User user;
 private InputStream inStream;


public String getGoodname() {
	return goodname;
}
public void setGoodname(String goodname) {
	this.goodname = goodname;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public String getGoodtype() {
	return goodtype;
}
public void setGoodtype(String goodtype) {
	this.goodtype = goodtype;
}
public String getGoodprice() {
	return goodprice;
}
public void setGoodprice(String goodprice) {
	this.goodprice = goodprice;
}
public String getAdress() {
	return adress;
}
public void setAdress(String adress) {
	this.adress = adress;
}

public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public InputStream getInStream() {
	return inStream;
}
public void setInStream(InputStream inStream) {
	this.inStream = inStream;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getBuyname() {
	return buyname;
}
public void setBuyname(String buyname) {
	this.buyname = buyname;
}



 
}
