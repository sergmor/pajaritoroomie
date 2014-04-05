package controllers;

import models.RoomieAgreement;
import play.mvc.Controller;
import play.mvc.Result;

public class RoomieAgreements extends Controller {
	
	public static Result getRoomieAgreement(String id) {
		RoomieAgreement ra = RoomieAgreement.findById(Long.valueOf(id));
		return TODO;
	}
	
	public static Result getAllActivities() {
		return TODO;
	}
	
	public static Result newRoomieAgreement() {
		return TODO;
	}
	
	public static Result newRoomie(String id) {
		return TODO;
	}
	
}
