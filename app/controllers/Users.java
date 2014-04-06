package controllers;

import models.User;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.*;

public class Users extends Controller {

	public static Result getUser(String id) {
		// id is the roomate agreement id
		User user = User.findById(Long.valueOf(id));
		return ok(getUser.render(user.ra, user));
	}
	
	public static Result getAllActivities(String id) {
		return TODO;
	}
	
	public static Result newUser() {
		return TODO;
	}
}
