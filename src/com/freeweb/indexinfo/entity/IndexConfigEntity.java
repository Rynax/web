package com.freeweb.indexinfo.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class IndexConfigEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String key;
	private String value;
	
	public int get_id() {
		return id;
	}
	
	public String get_key() {
		return key;
	}
	
	public String get_value() {
		return value;
	}
	
	public void set_id(int i) {
		this.id = i;
	}
	
	public void set_key(String s) {
		this.key = s;
	}
	
	public void set_value(String s) {
		this.value = s;
	}
	
	public IndexConfigEntity() {
		super();
	}
}
