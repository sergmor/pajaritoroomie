package models;

import play.db.ebean.Model;

public class Owner extends Model {

	public long id;
	public String usename;
	public String name;
	public int karma;
	
	public Owner(long id, String usename, String name, int karma) {
		super();
		this.id = id;
		this.usename = usename;
		this.name = name;
		this.karma = karma;
	}
	
	
	
}
