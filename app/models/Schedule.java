package models;

import java.util.List;

import play.db.ebean.Model;

public class Schedule extends Model{
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Time> getTimes() {
		return times;
	}
	public void setTimes(List<Time> times) {
		this.times = times;
	}
	public int id;
    public List<Time> times;
}
