package com.freeweb.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.freeweb.indexinfo.dao.IndexInfoDao;
import com.freeweb.indexinfo.dao.impl.IndexInfoDaoImpl;
import com.freeweb.indexinfo.entity.IndexInfoEntity;
import com.freeweb.userinfo.dao.UserInfoDao;
import com.freeweb.userinfo.dao.impl.UserInfoDaoImpl;
import com.freeweb.userinfo.entity.UserInfoEntity;

@Controller
public class IndexController {
	private UserInfoDao userinfodao = new UserInfoDaoImpl();
	private IndexInfoDao indexinfodao = new IndexInfoDaoImpl();
	
	@RequestMapping( value="/index.jsp")
	public String root(){
		return "jsp/index.jsp";
	}
	
	@RequestMapping( value="/")
	public String index(){
		return "view/test.html";
	}
	
	@RequestMapping( value="/index.do")
	@ResponseBody
	public String index_init(HttpServletRequest request) throws JSONException{
		List<IndexInfoEntity> list = null;
		JSONArray resp = new JSONArray();
		JSONArray classify = null;
		
		try {
			list = indexinfodao.find_all();
			if(list == null) {
				return resp.toString();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.printf("index_init exception: %s\n", e.toString());
			return resp.toString();
		}
		
		List<List<IndexInfoEntity>> resp_list = new ArrayList<List<IndexInfoEntity>>();
		List<IndexInfoEntity> classify_list = new ArrayList<IndexInfoEntity>();
		int i = 1;
		
		for(IndexInfoEntity indexinfo : list) {
			if(indexinfo.get_class_id() != i) {
				classify_list.sort(Comparator.comparingInt(IndexInfoEntity::get_img_priority).reversed());
				resp_list.add(classify_list);
				classify_list = new ArrayList<IndexInfoEntity>();
				i = indexinfo.get_class_id();
			}
			classify_list.add(indexinfo);
		}
		classify_list.sort(Comparator.comparingInt(IndexInfoEntity::get_img_priority).reversed());
		resp_list.add(classify_list);
		
		String type = "rand";
		
		for(List<IndexInfoEntity> t : resp_list) {
			classify = new JSONArray();
			int num = Math.min(t.size(), 3);
			
			if(type.equals("order")) {
				for(i = 0; i < num; i++) {
					classify.put(t.get(i).toJson());
					//System.out.printf("%s\n", t.get(i).toJson().toString());
				}
			}else {
				do {
					int rand = ((int) (Math.random() * 100)) % num;
					classify.put(t.get(rand).toJson());
					//System.out.printf("%s\n", t.get(rand).toJson().toString());
					t.remove(rand);
				}while(--num > 0);
			}
			resp.put(new JSONObject().put("class", classify));
		}
		
		//System.out.printf("%s\n", resp.toString());
		return resp.toString();
	}
	
	@RequestMapping( value="user_index.do")
	public String login(){
		return "view/index-iframe.html";
	}
	
	@RequestMapping( value="/login.do")
	@ResponseBody
	public String Test(HttpServletRequest request){
		
		String info = request.getParameter("data");
		String username = "";
		String password = "";
		String checkcode = "";

		try {
			JSONObject jsonObj = new JSONObject(info);
			username = jsonObj.getString("username");
			password = jsonObj.getString("password");
			checkcode = jsonObj.getString("checkcode");
			System.out.printf("%s, %s, %s\n", username, password, checkcode);
			UserInfoEntity userinfo = userinfodao.find_by_name(username);
			if(userinfo == null) {
				return "用户不存在";
			}
			System.out.printf("%s\n", userinfo.toString());
			if(password.equals(userinfo.get_login_pwd())) {
				return "登录成功";
			}else {
				return "密码错误";
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.printf("exception: %s\n", e.toString());
			return "服务器异常";
		}
	}
}
