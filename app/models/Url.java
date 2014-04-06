package models;

import play.db.ebean.Model;

public class Url extends Model
{
	public String geo_tag;
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
	public String short_tag;
	public String complete;
}
