package models;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import play.db.ebean.Model;

public class Menus extends Model{
	@javax.persistence.Id
	private String id;
	
    public List<Schedule> getSchedule() {
		return schedule;
	}
	public void setSchedule(List<Schedule> schedule) {
		this.schedule = schedule;
	}
	public List<Warning> getWarnings() {
		return warnings;
	}
	public void setWarnings(List<Warning> warnings) {
		this.warnings = warnings;
	}
	public List<Menu> getMenu() {
		return menu;
	}
	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Schedule> schedule;
    public List<Warning> warnings;
    public List<Menu> menu;
    
	public static Menus createMenusFromJson(String node){
		ObjectMapper mapper = new ObjectMapper();

		try {

		// read from file, convert it to user class
		Menus menus = mapper.readValue(node, Menus.class);
		
		System.out.println("Menus "+menus);

		return menus;		

		} catch (JsonGenerationException e) {

			e.printStackTrace();

		} catch (JsonMappingException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return null;
	}
    
}
