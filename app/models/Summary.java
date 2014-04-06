package models;

import java.util.List;

import play.db.ebean.Model;

public class Summary extends Model
{
	public String name;
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
	public List<String> getNotes() {
		return notes;
	}
	public void setNotes(List<String> notes) {
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
	public Object cuisines;
	public String phone ;
	public String description ;
	public int overall_rating ;
	public int num_ratings ;
	public String type ;
	public String type_label ;
	public List<String> notes ;
	public Url url ;
	public String activation_date ;
}
