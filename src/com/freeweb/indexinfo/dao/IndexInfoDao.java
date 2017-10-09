package com.freeweb.indexinfo.dao;

import java.sql.SQLException;
import java.util.List;

import com.freeweb.indexinfo.entity.IndexInfoEntity;

public interface IndexInfoDao {
	public void add(IndexInfoEntity p)throws SQLException;
	public void update(IndexInfoEntity p)throws SQLException;
	public void delete(IndexInfoEntity p)throws SQLException;
	public List<IndexInfoEntity> find_by_class_id(int id)throws SQLException;
	public List<IndexInfoEntity> find_all()throws SQLException;
}
