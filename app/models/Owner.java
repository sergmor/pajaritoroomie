package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import play.db.ebean.Model;

@Entity
public class Owner extends Model {

	public long id;
	public String usename;
	public String name;
	public List<Activity> tasks;
	public int karma;
	
	public Owner(long id, String usename, String name, int karma) {
		super();
		this.id = id;
		this.usename = usename;
		this.name = name;
		this.karma = karma;
	}
	
	public void addActivity(Activity act) {
		if (tasks == null) tasks = new ArrayList<Activity>();
		tasks.add(act);
	}
	
	
	
}
