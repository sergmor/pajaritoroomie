package models;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import play.db.ebean.Model;


// main class that will hold the stores
// may need to add jsonattributes
public class Stores extends Model
{
	public SearchAddress getSearch_address() {
		return search_address;
	}

	public void setSearch_address(SearchAddress search_address) {
		this.search_address = search_address;
	}

	public List<Object> getMessage() {
		return message;
	}

	public void setMessage(List<Object> message) {
		this.message = message;
	}

	public List<String> getPromoted_merchants_id() {
		return promoted_merchants_id;
	}

	public void setPromoted_merchants_id(List<String> promoted_merchants_id) {
		this.promoted_merchants_id = promoted_merchants_id;
	}

	public List<Merchant> getMerchants() {
		return merchants;
	}

	public void setMerchants(List<Merchant> merchants) {
		this.merchants = merchants;
	}

	public List<Vertical> getVerticals() {
		return verticals;
	}

	public void setVerticals(List<Vertical> verticals) {
		this.verticals = verticals;
	}

	public List<Object> getCuisines() {
		return cuisines;
	}

	public void setCuisines(List<Object> cuisines) {
		this.cuisines = cuisines;
	}

	public List<Object> getPopular_cuisines() {
		return popular_cuisines;
	}

	public void setPopular_cuisines(List<Object> popular_cuisines) {
		this.popular_cuisines = popular_cuisines;
	}

	public SearchAddress search_address ;
	public List<Object> message ;
	public List<String> promoted_merchants_id ;
	public List<Merchant> merchants ;
	public List<Vertical> verticals ;
	public List<Object> cuisines ;
	public List<Object> popular_cuisines ;
	@javax.persistence.Id
	private String id;

	public static Stores createStoresFromJson(String node){
		ObjectMapper mapper = new ObjectMapper();

		try {

		// read from file, convert it to user class
		Stores stores = mapper.readValue(node, Stores.class);

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