package models;

import javax.persistence.Entity;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Activity extends Model {

	public long id;	
	public User user;
	public String name;
	public Document evidence;
	public int karmaPoints;
	
	public Activity(long id, User user, String name, Document evidence) {
		super();
		this.id = id;
		this.user = user;
		this.name = name;
		this.evidence = evidence;
	}
	
	public void save(User u) {
		this.user = u;
	}
}
