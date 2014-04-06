package models;

import play.db.ebean.Model;


public class Document{

	public byte[] picture; 
	
	public Document() {
		
	}
	
	public Document(byte[] data) {
		this.picture= data;
	}
	
	
}
