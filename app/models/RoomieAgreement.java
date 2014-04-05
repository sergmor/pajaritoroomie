package models;

import java.util.List;

import javax.persistence.Entity;

import play.db.ebean.Model;

@Entity
public class RoomieAgreement extends Model {
	
	public List<Owner> roomies;

	public RoomieAgreement(List<Owner> roomies) {
		super();
		this.roomies = roomies;
	}
	
	
	
}
