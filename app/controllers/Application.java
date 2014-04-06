package controllers;


import models.RoomieAgreement;
import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.*;

public class Application extends Controller {


    
	@Security.Authenticated(Secured.class)
	public static Result index() {
		User u = RoomieAgreement.findByUsername(request().username());
		RoomieAgreement ra = u.ra;
//		return redirect(routes.RoomieAgreements.getRoomieAgreement(Long.toString(ra.id)));	
		return ok(index.render(""));
	}

	public static Result login() {
		return ok(login.render(Form.form(Login.class)));
	}

	public static Result authenticate() {
		Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
		if (loginForm.hasErrors()) {
			return badRequest(login.render(loginForm));
		} else {
			session().clear();
			session("email", loginForm.get().email);
			return redirect(routes.Application.index());
		}
	}
	
	public static Result logout() {
		session().clear();
		flash("success", "You are logged out");
		return redirect(routes.Application.login());
	}

	public static class Login {

		public String email;
		public String password;

		public String validate() {
			if (User.authenticate(email, password) == null) {
				return "Invalid user or password";
			}
			return null;
		}

	}

}
