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
import javax.imageio.ImageIO;

public class Requests extends Controller{

	@BodyParser.Of(BodyParser.Json.class)
	public static Result newRequest() {
		JsonNode jsonNode = Controller.request().body().asJson();
		String email = jsonNode.findPath("email").asText();
		byte[] fileBytes = (byte[]) jsonNode.findPath("file");

		InputStream in = new ByteArrayInputStream(fileBytes);
		BufferedImage bImageFromConvert = ImageIO.read(in);

		String timestamp = jsonNode.findPath("timestamp").asText();
				
		return TODO;
	}
}
