package models;

import javax.persistence.Entity;

import play.db.ebean.Model;

@Entity
public class Activity extends Model {
	
	
	public long id;
	public Owner user;
	public String name;
	public Document evidence;
	public int karmaPoints;
	
	public Activity(long id, Owner user, String name, Document evidence) {
		super();
		this.id = id;
		this.user = user;
		this.name = name;
		this.evidence = evidence;
	}
	
	

}
