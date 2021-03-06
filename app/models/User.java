package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;


public class User extends Model {

	public long id;
	public RoomieAgreement ra;
	public String usename;
	public String name;
	public List<Activity> tasks;
	public int karma;
	public String address;
	
	public User(long id, String usename, String name, int karma, String address) {
		super();
		this.id = id;
		this.usename = usename;
		this.name = name;
		this.karma = karma;
		this.address = address;
	}
	
	//public static Finder<String, User> find = new Finder<String,User>(String.class, User.class);
	
	public static User findById(long id) {
		return RoomieAgreement.findUserById(id);
	}
	
	public void addActivity(Activity act) {
		if (tasks == null) tasks = new ArrayList<Activity>();
		tasks.add(act);
	}
	
	public void addToAgreement(RoomieAgreement ra) {
		this.ra = ra;
	}
	
	public static User authenticate(String email, String pwd) {
		return RoomieAgreement.findByUsername(email);
	}
	
}
