package com.freeweb.indexinfo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONException;
import org.json.JSONObject;

@Entity
@Table(name="index_info")
public class IndexInfoEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int class_id;
	private String img_url;
	private String link_url;
	private int img_priority;
	
	public int get_id() {
		return id;
	}
	
	public int get_class_id() {
		return class_id;
	}
	
	public String get_img_url() {
		return img_url;
	}
	
	public String get_link_url() {
		return link_url;
	}
	
	public int get_img_priority() {
		return img_priority;
	}
	
	public void set_id(int i) {
		this.id = i;
	}
	
	public void set_class_id(int i) {
		this.class_id = i;
	}
	
	public void set_img_url(String s) {
		this.img_url = s;
	}
	
	public void set_link_url(String s) {
		this.link_url = s;
	}
	
	public void set_img_priority(int i) {
		this.img_priority = i;
	}
	
	public IndexInfoEntity(int class_id, String img_url, String link_url, int img_priority) {
		super();
		this.class_id = class_id;
		this.img_url = img_url;
		this.link_url = link_url;
		this.img_priority = img_priority;
	}
	
	public IndexInfoEntity(int class_id, String img_url, String link_url) {
		super();
		this.class_id = class_id;
		this.img_url = img_url;
		this.link_url = link_url;
		this.img_priority = 3;
	}
	
	public IndexInfoEntity() {
		super();
	}
	
	@Override
	public String toString() {
		return "IndexInfo: id[" + id + "], class_id[" + class_id + "], img_url[" + img_url + "], link_url[" + link_url + "], img_priority[" + img_priority + "]";
	}
	
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		try {
			json.put("img", img_url);
			json.put("link", link_url);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.printf("json.put exception: %s\n", e.toString());
		}
		return json;
	}
}
