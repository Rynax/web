package com.freeweb.userinfo.dao;

import java.sql.SQLException;
import java.util.List;

import com.freeweb.userinfo.entity.UserInfoEntity;

public interface UserInfoDao {
	public void add(UserInfoEntity p)throws SQLException;
	public void update(UserInfoEntity p)throws SQLException;
	public void delete(UserInfoEntity p)throws SQLException;
	public UserInfoEntity find_by_name(String name)throws SQLException;
	public List<UserInfoEntity> find_all()throws SQLException;
}
