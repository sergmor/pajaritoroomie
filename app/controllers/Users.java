package controllers;

import models.User;
import play.mvc.Controller;
import play.mvc.Result;

public class Users extends Controller {

	public static Result getUser(String id) {
		User us = User.findById(Long.valueOf(id));
		return TODO;
	}
	
	public static Result getAllActivities(String id) {
		return TODO;
	}
	
	public static Result newUser() {
		return TODO;
	}
}
