package models;

import play.db.ebean.Model;

public class Activity extends Model {
	
	public long id;
	public Owner user;
	public Document evidence;
	public int karmaPoints;
	
	public Activity(long id, Owner user, Document evidence) {
		super();
		this.id = id;
		this.user = user;
		this.evidence = evidence;
	}
	
	

}
