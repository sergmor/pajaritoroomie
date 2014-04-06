package controllers;

import models.Activity;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.*;

public class Activities extends Controller{
	
	private static final Form<Activity> activityForm = Form.form(Activity.class);

	public static Result getActivity(String id) {
		return TODO;
	}
	
	public static Result newActivity() {
		return ok(newActivity.render(activityForm));		
	}
	
	public static Result save() {
		Form<Activity> boundForm = activityForm.bindFromRequest();
		if(boundForm.hasErrors()) {
			flash("error", "Please correct the form");
			return badRequest(newActivity.render(boundForm));
		}
		Activity act = boundForm.get();
		act.save();
		flash("success",String.format("Saved activity %s", act.name));
		return redirect(routes.Users.getUser(Long.toString(act.user.id)));
	}
}
