package models;

import java.util.List;

public class Child {
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getSchedule() {
		return schedule;
	}
	public void setSchedule(List<String> schedule) {
		this.schedule = schedule;
	}
	public String getMin_qty() {
		return min_qty;
	}
	public void setMin_qty(String min_qty) {
		this.min_qty = min_qty;
	}
	public String getMax_qty() {
		return max_qty;
	}
	public void setMax_qty(String max_qty) {
		this.max_qty = max_qty;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getMax_price() {
		return max_price;
	}
	public void setMax_price(String max_price) {
		this.max_price = max_price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Child> getChildren() {
		return children;
	}
	public void setChildren(List<Child> children) {
		this.children = children;
	}
	public String getIncrement() {
		return increment;
	}
	public void setIncrement(String increments) {
		this.increment = increments;
	}
	public String getQty_name_singular() {
		return qty_name_singular;
	}
	public void setQty_name_singular(String qty_name_singular) {
		this.qty_name_singular = qty_name_singular;
	}
	public String getQty_name_plural() {
		return qty_name_plural;
	}
	public void setQty_name_plural(String qty_name_plural) {
		this.qty_name_plural = qty_name_plural;
	}
	public String id;
    public String name;
    public String description;
    public List<String> schedule;
    public String min_qty;
    public String max_qty;
    public String price;
    public String max_price;
    public String type;
    public List<Child> children;
    public String increment;
    public String qty_name_singular;
    public String qty_name_plural;
}
