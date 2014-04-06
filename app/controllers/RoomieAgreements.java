package controllers;

import models.RoomieAgreement;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.*;

public class RoomieAgreements extends Controller {
	
	public static Result getRoomieAgreement(String id) {
		RoomieAgreement ra = RoomieAgreement.findById(Long.valueOf(id));
		return ok(getRoomie.render(ra));
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
