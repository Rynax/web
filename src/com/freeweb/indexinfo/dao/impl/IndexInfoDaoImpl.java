package com.freeweb.indexinfo.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.freeweb.indexinfo.dao.IndexInfoDao;
import com.freeweb.indexinfo.entity.IndexInfoEntity;

public class IndexInfoDaoImpl implements IndexInfoDao {
	private SessionFactory sessionFactory;
	
	{
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionFactory = context.getBean(SessionFactory.class);
	}
	
	private Session getSession() {
		Session s = sessionFactory.openSession();
//		Session s = sessionFactory.getCurrentSession();
		return s;
	}
	
	@Override
	public void add(IndexInfoEntity p) throws SQLException {
		getSession().save(p);
	}
	
	@Override
	public void update(IndexInfoEntity p) throws SQLException {
		getSession().update(p);
	}
	
	@Override
	public void delete(IndexInfoEntity p) throws SQLException {
		getSession().delete(p);
	}
	
	@Override
	public List<IndexInfoEntity> find_by_class_id(int id) throws SQLException {
		String hql = "from IndexInfoEntity where class_id=?";
		List<IndexInfoEntity> list = null;
		
		try {
			Query query = getSession().createQuery(hql).setInteger(0, id);
			list = query.list();
		} catch (Exception e) {
			System.out.printf("find_by_name: %s\n", e.toString());
		}
		
		return list;
	}
	
	@Override
	public List<IndexInfoEntity> find_all() throws SQLException {
		String hql = "from IndexInfoEntity order by class_id";
	    Query query = getSession().createQuery(hql);
	    List<IndexInfoEntity> list = query.list();
	    return list;
	}
}
