package models;

import java.util.List;

import play.db.ebean.Model;


public class Ordering extends Model
{
	public String delivery_processes_card ;
	public String getDelivery_processes_card() {
		return delivery_processes_card;
	}
	public void setDelivery_processes_card(String delivery_processes_card) {
		this.delivery_processes_card = delivery_processes_card;
	}
	public List<String> getPayment_types() {
		return payment_types;
	}
	public void setPayment_types(List<String> payment_types) {
		this.payment_types = payment_types;
	}
	public String getIs_rds() {
		return is_rds;
	}
	public void setIs_rds(String is_rds) {
		this.is_rds = is_rds;
	}
	public int getTime_needed() {
		return time_needed;
	}
	public void setTime_needed(int time_needed) {
		this.time_needed = time_needed;
	}
	public List<String> getSpecials() {
		return specials;
	}
	public void setSpecials(List<String> specials) {
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
	public String getIs_open() {
		return is_open;
	}
	public void setIs_open(String is_open) {
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
	public List<String> payment_types ;
	public String is_rds ;
	public int time_needed ;
	public List<String> specials ;
	public String last_or_next_order_time ;
	public int minimum ;
	public String is_open ;
	public int delivery_charge ;
	public int delivery_percent ;
}
