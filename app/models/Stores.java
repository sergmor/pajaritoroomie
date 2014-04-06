package models;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class SearchAddress
{
	public string street { get; set; }
	public string zip_code { get; set; }
	public string state { get; set; }
	public string city { get; set; }
	public double latitude { get; set; }
	public double longitude { get; set; }
}

public class Url
{
	public string geo_tag { get; set; }
	public string short_tag { get; set; }
	public string complete { get; set; }
}

public class Summary
{
	public string name { get; set; }
	public object cuisines { get; set; }
	public string phone { get; set; }
	public string description { get; set; }
	public int overall_rating { get; set; }
	public int num_ratings { get; set; }
	public string type { get; set; }
	public string type_label { get; set; }
	public List<string> notes { get; set; }
	public Url url { get; set; }
	public string activation_date { get; set; }
}

public class Ordering
{
	public bool delivery_processes_card { get; set; }
	public List<string> payment_types { get; set; }
	public bool is_rds { get; set; }
	public int time_needed { get; set; }
	public List<string> specials { get; set; }
	public string last_or_next_order_time { get; set; }
	public int minimum { get; set; }
	public bool is_open { get; set; }
	public int delivery_charge { get; set; }
	public int delivery_percent { get; set; }
}

public class Location
{
	public double distance { get; set; }
	public string street { get; set; }
	public string city { get; set; }
	public string state { get; set; }
	public string zip { get; set; }
	public double longitude { get; set; }
	public double latitude { get; set; }
	public string landmark { get; set; }
}

public class Merchant
{
	public string id { get; set; }
	public Summary summary { get; set; }
	public Ordering ordering { get; set; }
	public Location location { get; set; }
}

public class Vertical
{
	public string type { get; set; }
	public int count { get; set; }
	public string label { get; set; }
}

// main class that will hold the stores
// may need to add jsonattributes
public class Stores
{
	public SearchAddress search_address { get; set; }
	public List<object> message { get; set; }
	public List<string> promoted_merchants_id { get; set; }
	public List<Merchant> merchants { get; set; }
	public List<Vertical> verticals { get; set; }
	public List<object> cuisines { get; set; }
	public List<object> popular_cuisines { get; set; }

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