package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


import views.html.*;

public class DeliveryController extends Controller {
    final static String host = "http://sandbox.delivery.com/";
    
    final static String GUEST_TOKEN = "Guest-Token";
    final static String AUTH_TOKEN = "Authorization";
    final static String GUEST_TOKEN_URL = "customer/auth/guest";
    final static String CUSTOMER_CART_URL = "customer/cart";
    final static String CHECKOUT_URL = "customer/cart";
    final static String CC_URL = "customer/cc";
    final static String AUTH_URL = "customer/auth";
    final static String LOCATION_URL = "customer/location";
    final static String ORDER_URL = "customer/orders/recent";
    final static String SEARCH_URL = "merchant/search/delivery";    
    //final static String SEARCH_ADDRESS = "1330 1st Ave, 10021";
    final static String SEARCH_ADDRESS = "2960 Broadway, 10027";
    final static String ADDRESS_APT = "Apt 123";    
    final static String CLIENT_ID = "YmRlOWRjYTFkNjUzZjY0MTlmMzhhNjBkMzBjZGEzNDA1";    
    final static String ORDER_TYPE = "delivery";
    final static String clientSecret = "8Vkj0fRJarKy9zZwXHoc980FrDj110e7SeSIMnGY";
    String redirectURI = "http://localhost";
    
    String urlToAddCCInBrowser = "http://sandbox.delivery.com/third_party/credit_card/add?client_id=" + CLIENT_ID + "&redirect_uri=" + redirectURI
        + "&response_type=code&scope=global";
    

	
	public static Result getStores(String address) {
		JSONObject searchResults = search(SEARCH_ADDRESS);
		return TODO;
	}
	
    private static String getGuestToken(String clientId){
    	WebResource resource = Client.create().resource(UriBuilder.fromUri(host + GUEST_TOKEN_URL).queryParam("client_id", clientId).clone().build().toASCIIString());
    	ClientResponse res = resource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
 
    	if (res.getStatus() == ClientResponse.Status.OK.getStatusCode()) {
    		String token = res.getEntity(String.class);
    		return JSONObject.fromObject(token).getString("Guest-Token");
    	} else {
    		throw new RuntimeException(JSONObject.fromObject(res.getEntity(String.class)).getJSONArray("message").getJSONObject(0).getString("code"));
    	}
    }
    
    private static JSONObject search(String address) {
	    String url = host + SEARCH_URL;
	 
	    WebResource resource = Client.create().resource(UriBuilder.fromUri(url).queryParam("address", address).queryParam("client_id", CLIENT_ID).queryParam("merchant_type","I").clone().build().toASCIIString());
	    ClientResponse res = resource.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE).get(ClientResponse.class);
	 
	    if (res.getStatus() == ClientResponse.Status.OK.getStatusCode()) {
	        String merchantInfoArray = res.getEntity(String.class);
	        JSONObject searchResult = JSONObject.fromObject(merchantInfoArray);
	        return searchResult;
	    } else {
	        String msg = JSONObject.fromObject(res.getEntity(String.class)).getJSONArray("message").getJSONObject(0).getString("code");
	        throw new RuntimeException(msg);
	    }
    }
     

}
