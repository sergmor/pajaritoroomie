package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import play.db.ebean.Model;

@Entity
public class RoomieAgreement extends Model {
	
	public long id;
	public static List<Owner> roomies;
	public static List<RoomieAgreement> agreements;
	
	static {
		List<Owner> roomie = new ArrayList<Owner>();
		Owner test = new Owner(1L, "sergmor", "SDM", 0);
		roomie.add(test);
		Owner test1 = new Owner(2L, "sergmor1", "SDM1", 1);
		roomie.add(test1);
		Activity dish = new Activity(1L, test, "dishes", null);
		Activity wash = new Activity(1L, test, "wash", null);
		Activity trash = new Activity(1L, test1, "trash", null);
		test.addActivity(dish);
		test.addActivity(wash);
		test1.addActivity(trash);
		
		agreements.add(new RoomieAgreement(1L, roomie));
	}
	
	public RoomieAgreement(long id, List<Owner> roomies) {
		super();
		this.id = id;
		RoomieAgreement.roomies = roomies;
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
	
	
	
	
	
}
