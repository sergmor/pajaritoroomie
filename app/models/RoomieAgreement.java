package models;

import java.util.List;

import play.db.ebean.Model;

public class RoomieAgreement extends Model {
	
	public List<Owner> roomies;

	public RoomieAgreement(List<Owner> roomies) {
		super();
		this.roomies = roomies;
	}
	
	
	
}
