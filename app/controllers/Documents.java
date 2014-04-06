package controllers;

import java.io.File;

import models.Activity;
import models.Document;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;
import views.html.*;


public class Documents extends Controller {

	private static final Form<Document> documentForm = Form.form(Document.class);

	public static Result showUpload() {

		return ok(newDocument.render(documentForm));
	}

	public static Result newDocument() {
		MultipartFormData body = request().body().asMultipartFormData();

		FilePart picture = body.getFile("picture");
		if (picture != null) {
			String fileName = picture.getFilename();
			String contentType = picture.getContentType(); 
			File file = picture.getFile();
			System.out.println(file.getAbsolutePath());
			System.out.println(fileName);
			String path = "/Users/Dani/" + fileName;
			file.renameTo(new File(path));
			System.out.println(file.getAbsolutePath());
			return redirect(routes.Application.index());
		} else {
			flash("error", "Missing file");
			return redirect(routes.Application.index());    
		}		
	}

}
