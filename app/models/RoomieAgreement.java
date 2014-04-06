package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import play.db.ebean.Model;

@Entity
public class RoomieAgreement extends Model {
	
	public long id;
	public List<User> roomies;
	public String agreementName;
	public static List<RoomieAgreement> agreements;
	
	static {
		List<User> roomie = new ArrayList<User>();
		User test = new User(1L, "sergmor", "SDM", 0, "567 W 125 Street, 10027");
		roomie.add(test);
		User test1 = new User(2L, "sergmor1", "SDM1", 1, "567 W 125 Street, 10027");
		roomie.add(test1);
		Activity dish = new Activity(1L, test, "dishes", null);
		Activity wash = new Activity(1L, test, "wash", null);
		Activity trash = new Activity(1L, test1, "trash", null);
		test.addActivity(dish);
		test.addActivity(wash);
		test1.addActivity(trash);
		// adding the agreement back to users
		RoomieAgreement tempRa = new RoomieAgreement(1L, roomie, "bhakchods");
		test.ra = tempRa;
		test1.ra = tempRa;

		agreements = new ArrayList<RoomieAgreement>();
		agreements.add(tempRa);
	}
	
	public RoomieAgreement() {
		
	}
	
	public RoomieAgreement(long id, List<User> roomies, String agreementName) {
		super();
		this.id = id;
		this.roomies = roomies;
		this.agreementName = agreementName;
	}
	
	public static RoomieAgreement findById(long id) {
		RoomieAgreement res = null;
		for (RoomieAgreement ra : agreements) {
			if(ra.id == id) {
				res = ra;
			}
		}
		return res;
	}
	
	public static User findUserById(long id) {
		for (RoomieAgreement ra : agreements) {
			List<User> ul = ra.roomies;
			for(int i=0; i<ul.size(); i++) {
				if(ul.get(i).id == id) {
					return ul.get(i);					
				}
			}
		}
		return null;
	}
	
	public static User findByUsername(String uName) {
		for (RoomieAgreement ra : agreements) {
			List<User> ul = ra.roomies;
			for(int i=0; i<ul.size(); i++) {
				if(ul.get(i).usename == uName) {
					return ul.get(i);					
				}
			}
		}
		return null;
	}
	
	
	
	
	
}
