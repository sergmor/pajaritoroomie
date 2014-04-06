package controllers;

import java.io.File;

import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;

public class Requests extends Controller{

	public static Result newRequest() throws Exception  {
		MultipartFormData body = request().body().asMultipartFormData();
		System.out.println(body);		

		FilePart picture = body.getFile("pranav");
		System.out.println("here");
		if (picture != null) {
			System.out.println("if");
			String fileName = picture.getFilename();
			String contentType = picture.getContentType(); 

			File file = picture.getFile();
			System.out.println(file.getAbsolutePath());
			System.out.println(fileName);
			String path = "/Users/Apple/" + fileName;
			file.renameTo(new File(path));
			System.out.println(file.getAbsolutePath());
			return redirect(routes.Application.index());
		} else {
			System.out.println("else");
			flash("error", "Missing file");
			return redirect(routes.Application.index());    
		}
	}
}
