package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import play.db.ebean.Model;


public class Activity extends Model {

	public long id;	
	public User user;
	//@Required
	public String name;
	public Document evidence;
	public int karmaPoints;
	public Date dueDate;
	public boolean complete;
	
	public Activity() {
		super();
	}
	
	public Activity(String name, Document evidence, int kp, Date dd) {
		super();		
		this.name = name;
		this.evidence = evidence;
		this.karmaPoints = kp;
		this.dueDate = dd;
	}
	
	public Activity(long id, User user, String name, int kp) {
		super();
		this.id = id;
		this.user = user;
		this.name = name;
		this.karmaPoints = kp;
	}
	
	public void save(User u) {
		this.id = System.currentTimeMillis();
		this.user = u;
	}

	public void setDueDate(String string) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YY");
		try {
			dueDate = sdf.parse(string);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void complete() {
		this.complete = true;
		
	}
	
	
}
