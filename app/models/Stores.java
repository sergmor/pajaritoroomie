
package models;
import java.util.ArrayList;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import play.db.ebean.Model;

public class Stores extends Model
{

	public SearchAddress search_address ;
	public ArrayList<Object> message ;
	public ArrayList<String> promoted_merchants_id ;
	public ArrayList<Merchant> merchants ;
	public ArrayList<Vertical> verticals ;
	public ArrayList<Object> cuisines ;
	public ArrayList<Object> popular_cuisines ;
	@javax.persistence.Id
	private String id;

	public ArrayList<Object> getMessage() {
		return message;
	}

	public void setMessage(ArrayList<Object> message) {
		this.message = message;
	}

	public ArrayList<String> getPromoted_merchants_id() {
		return promoted_merchants_id;
	}

	public void setPromoted_merchants_id(ArrayList<String> promoted_merchants_id) {
		this.promoted_merchants_id = promoted_merchants_id;
	}

	public ArrayList<Merchant> getMerchants() {
		return merchants;
	}

	public void setMerchants(ArrayList<Merchant> merchants) {
		this.merchants = merchants;
	}

	public ArrayList<Vertical> getVerticals() {
		return verticals;
	}

	public void setVerticals(ArrayList<Vertical> verticals) {
		this.verticals = verticals;
	}

	public ArrayList<Object> getCuisines() {
		return cuisines;
	}

	public void setCuisines(ArrayList<Object> cuisines) {
		this.cuisines = cuisines;
	}

	public ArrayList<Object> getPopular_cuisines() {
		return popular_cuisines;
	}

	public void setPopular_cuisines(ArrayList<Object> popular_cuisines) {
		this.popular_cuisines = popular_cuisines;
	}

	public static Stores createStoresFromJson(String json){

		ObjectMapper mapper = new ObjectMapper();

		try {

		// read from file, convert it to user class
		Stores stores = mapper.readValue(json, Stores.class);

		// display to console
		System.out.println(stores);

		return stores;		

		} catch (JsonGenerationException e) {

			e.printStackTrace();

		} catch (JsonMappingException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
