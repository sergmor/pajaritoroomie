
package models;
import java.util.ArrayList;

class SearchAddress
{
	public String street ;
	public String zip_code ;
	public String state ;
	public String city ;
	public double latitude ;
	public double longitude ;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
}

class Url
{
	public String geo_tag ;
	public String short_tag ;
	public String complete ;
	
	public String getGeo_tag() {
		return geo_tag;
	}
	public void setGeo_tag(String geo_tag) {
		this.geo_tag = geo_tag;
	}
	public String getShort_tag() {
		return short_tag;
	}
	public void setShort_tag(String short_tag) {
		this.short_tag = short_tag;
	}
	public String getComplete() {
		return complete;
	}
	public void setComplete(String complete) {
		this.complete = complete;
	}
}

  class Summary
{
	public String name ;
	public Object cuisines ;
	public String phone ;
	public String description ;
	public int overall_rating ;
	public int num_ratings ;
	public String type ;
	public String type_label ;
	public ArrayList<String> notes ;
	public Url url ;
	public String activation_date ;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object getCuisines() {
		return cuisines;
	}
	public void setCuisines(Object cuisines) {
		this.cuisines = cuisines;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getOverall_rating() {
		return overall_rating;
	}
	public void setOverall_rating(int overall_rating) {
		this.overall_rating = overall_rating;
	}
	public int getNum_ratings() {
		return num_ratings;
	}
	public void setNum_ratings(int num_ratings) {
		this.num_ratings = num_ratings;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType_label() {
		return type_label;
	}
	public void setType_label(String type_label) {
		this.type_label = type_label;
	}
	public ArrayList<String> getNotes() {
		return notes;
	}
	public void setNotes(ArrayList<String> notes) {
		this.notes = notes;
	}
	public Url getUrl() {
		return url;
	}
	public void setUrl(Url url) {
		this.url = url;
	}
	public String getActivation_date() {
		return activation_date;
	}
	public void setActivation_date(String activation_date) {
		this.activation_date = activation_date;
	}
}

class Ordering
{
	public boolean delivery_processes_card ;
	public ArrayList<String> payment_types ;
	public boolean is_rds ;
	public int time_needed ;
	public ArrayList<String> specials ;
	public String last_or_next_order_time ;
	public int minimum ;
	public boolean is_open ;
	public int delivery_charge ;
	public int delivery_percent ;
	
	public boolean isDelivery_processes_card() {
		return delivery_processes_card;
	}
	public void setDelivery_processes_card(boolean delivery_processes_card) {
		this.delivery_processes_card = delivery_processes_card;
	}
	public ArrayList<String> getPayment_types() {
		return payment_types;
	}
	public void setPayment_types(ArrayList<String> payment_types) {
		this.payment_types = payment_types;
	}
	public boolean isIs_rds() {
		return is_rds;
	}
	public void setIs_rds(boolean is_rds) {
		this.is_rds = is_rds;
	}
	public int getTime_needed() {
		return time_needed;
	}
	public void setTime_needed(int time_needed) {
		this.time_needed = time_needed;
	}
	public ArrayList<String> getSpecials() {
		return specials;
	}
	public void setSpecials(ArrayList<String> specials) {
		this.specials = specials;
	}
	public String getLast_or_next_order_time() {
		return last_or_next_order_time;
	}
	public void setLast_or_next_order_time(String last_or_next_order_time) {
		this.last_or_next_order_time = last_or_next_order_time;
	}
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	public boolean isIs_open() {
		return is_open;
	}
	public void setIs_open(boolean is_open) {
		this.is_open = is_open;
	}
	public int getDelivery_charge() {
		return delivery_charge;
	}
	public void setDelivery_charge(int delivery_charge) {
		this.delivery_charge = delivery_charge;
	}
	public int getDelivery_percent() {
		return delivery_percent;
	}
	public void setDelivery_percent(int delivery_percent) {
		this.delivery_percent = delivery_percent;
	}
	
}

class Location
{
	public double distance ;
	public String street ;
	public String city ;
	public String state ;
	public String zip ;
	public double longitude ;
	public double latitude ;
	public String landmark ;
	
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
}

class Merchant
{
	public String id;
	public Summary summary;
	public Ordering ordering;
	public Location location;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Summary getSummary() {
		return summary;
	}
	public void setSummary(Summary summary) {
		this.summary = summary;
	}
	public Ordering getOrdering() {
		return ordering;
	}
	public void setOrdering(Ordering ordering) {
		this.ordering = ordering;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
}

class Vertical
{
	public String type ;
	public int count ;
	public String label ;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
}

// main class that will hold the stores
// may need to add jsonattributes
public class Stores
{
	public SearchAddress search_address ;
	public ArrayList<Object> message ;
	public ArrayList<String> promoted_merchants_id ;
	public ArrayList<Merchant> merchants ;
	public ArrayList<Vertical> verticals ;
	public ArrayList<Object> cuisines ;
	public ArrayList<Object> popular_cuisines ;

	public SearchAddress getSearch_address() {
		return search_address;
	}

	public void setSearch_address(SearchAddress search_address) {
		this.search_address = search_address;
	}

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

	public Stores createStoresFromJson(org.codehaus.jackson.JsonNode json){
		ObjectMapper mapper = new ObjectMapper();

		try {

		// read from file, convert it to user class
		Stores stores = mapper.readValue(json, Stores.class);

		// display to console
		System.out.println(user);

		return stores;

		} catch (JsonGenerationException e) {

			e.printStackTrace();

		} catch (JsonMappingException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
}
