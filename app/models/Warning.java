package models;

import java.util.List;

import play.db.ebean.Model;

public class Warning extends Model {
    public String type;
    public List<String> items;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<String> getItems() {
		return items;
	}
	public void setItems(List<String> items) {
		this.items = items;
	}
}
