package com.freeweb.userinfo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_info")
public class UserInfoEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String login_name;
	private String login_pwd;
	private String nick_name;
	private int user_status;
	
	public int get_id() {
		return id;
	}
	
	public String get_login_name() {
		return login_name;
	}
	
	public String get_login_pwd() {
		return login_pwd;
	}
	
	public String get_nick_name() {
		return nick_name;
	}
	
	public int get_user_statusd() {
		return user_status;
	}
	
	public void set_id(int i) {
		this.id = i;
	}
	
	public void set_login_name(String s) {
		this.login_name = s;
	}
	
	public void set_login_pwd(String s) {
		this.login_pwd = s;
	}
	
	public void set_nick_name(String s) {
		this.nick_name = s;
	}
	
	public void set_user_status(int i) {
		this.user_status = i;
	}
	
	public UserInfoEntity(String login_name, String login_pwd, String nick_name) {
		super();
		this.login_name = login_name;
		this.login_pwd = login_pwd;
		this.nick_name = nick_name;
		this.user_status = 0;
	}
	
	public UserInfoEntity(String login_name, String login_pwd) {
		super();
		this.login_name = login_name;
		this.login_pwd = login_pwd;
		this.nick_name = login_name;
		this.user_status = 0;
	}
	
	public UserInfoEntity() {
		super();
	}
	
	@Override
	public String toString() {
		return "UserInfo: id[" + id + "], login_name[" + login_name + "], login_pwd[" + login_pwd + "], nick_name[" + nick_name + "], user_status[" + user_status + "]";
	}
}
