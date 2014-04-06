package controllers;

import play.*;
import play.mvc.*;
import views.html.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.JsonNode;

//import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;


import com.sun.jersey.core.util.Base64;

import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.*;

public class Requests extends Controller{

	@BodyParser.Of(BodyParser.Json.class)
	public static Result newRequest() throws Exception  {
		JsonNode jsonNode = Controller.request().body().asJson();
		String email = jsonNode.findPath("email").asText();

		String Stringpicture = jsonNode.findPath("file").asText();
		
		byte[] fileBytes = Base64.decode(Stringpicture);
		InputStream in = new ByteArrayInputStream(fileBytes);
		BufferedImage bImageFromConvert = ImageIO.read(in);


		String timestamp = jsonNode.findPath("timestamp").asText();
		File file = new File("pranav"+".jpg");
		ImageIO.write(bImageFromConvert, "jpg", file);
		
		return TODO;
	}
}
