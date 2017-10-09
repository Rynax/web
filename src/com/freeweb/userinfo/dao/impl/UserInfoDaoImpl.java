package com.freeweb.userinfo.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.freeweb.userinfo.entity.UserInfoEntity;
import com.freeweb.userinfo.dao.UserInfoDao;

public class UserInfoDaoImpl implements UserInfoDao {
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
	public void add(UserInfoEntity p) throws SQLException {
		getSession().save(p);
	    /*Connection conn = null;
	    PreparedStatement ps = null;
	    String sql = "insert into user_info(id,account,person_name,pwd,login_times,is_valid,is_delete) values(null,?,?,?,?,?,?)";
	    try{
	        conn = DBUtils.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, p.get_account());
	        ps.setString(2, p.get_username());
	        ps.setString(3, p.get_password());
	        ps.setInt(4, p.get_login_times());
	        ps.setInt(5, p.get_is_valid());
	        ps.setInt(6, p.get_is_delete());
	        ps.executeUpdate();
	    }catch(SQLException e){
	        e.printStackTrace();
	        throw new SQLException("添加数据失败");
	    }finally{
	        DBUtils.close(null, ps, conn);
	    }*/
	}
	
	@Override
	public void update(UserInfoEntity p) throws SQLException {
		getSession().update(p);
	    /*Connection conn = null;
	    PreparedStatement ps = null;
	    String sql = "update user_info set account=?,person_name=?,pwd=?,login_times=?,is_valid=?,is_delete=? where id=?";
	    try{
	        conn = DBUtils.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, p.get_account());
	        ps.setString(2, p.get_username());
	        ps.setString(3, p.get_password());
	        ps.setInt(4, p.get_login_times());
	        ps.setInt(5, p.get_is_valid());
	        ps.setInt(6, p.get_is_delete());
	        ps.setInt(7, p.get_id());
	        ps.executeUpdate();
	    }catch(SQLException e){
	        e.printStackTrace();
	        throw new SQLException("更新数据失败");
	    }finally{
	        DBUtils.close(null, ps, conn);
	    }*/
	}
	
	@Override
	public void delete(UserInfoEntity p) throws SQLException {
		getSession().delete(p);
	    /*Connection conn = null;
	    PreparedStatement ps = null;
	    String sql = "delete from user_info where id=?";
	    try{
	        conn = DBUtils.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setInt(1, p.get_id());
	        ps.executeUpdate();
	    }catch(SQLException e){
	        e.printStackTrace();
	        throw new SQLException("删除数据失败");
	    }finally{
	        DBUtils.close(null, ps, conn);
	    }*/
	}
	
	@Override
	public UserInfoEntity find_by_name(String name) throws SQLException {
//		String sql = "select pwd from user_info where person_name='admin'";
		String hql = "from UserInfoEntity where login_name=?";
		List<UserInfoEntity> list = null;
		
		try {
			Query query = getSession().createQuery(hql).setString(0, name);
			list = query.list();
		} catch (Exception e) {
			System.out.printf("find_by_name: %s\n", e.toString());
		}
		
		if(list.isEmpty()) {
			return null;
		}else {
			return list.get(0);
		}
	    /*Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    user_info p = null;
	    
	    try{
	        conn = DBUtils.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, name);
	        rs = ps.executeQuery();
	        if(rs.next()){
	        	p = new user_info();
	        	p.set_id(rs.getInt(1));
	        	p.set_account(rs.getString(2));
	        	p.set_username(rs.getString(3));
	        	p.set_password(rs.getString(4));
	        	p.set_login_times(rs.getInt(5));
	        	p.set_is_valid(rs.getInt(6));
	        	p.set_is_delete(rs.getInt(7));
	        }
	    }catch(SQLException e){
	        e.printStackTrace();
	        throw new SQLException("查询数据失败");
	    }finally{
	        DBUtils.close(null, ps, conn);
	    }*/
//	    return list.get(0);
	}
	
	@Override
	public List<UserInfoEntity> find_all() throws SQLException {
		String hql = "from UserInfoEntity";
	    Query query = getSession().createQuery(hql);
	    List<UserInfoEntity> list = query.list();
	    /*Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    user_info p = null;
	    List<user_info> pl = new ArrayList<user_info>();
	    String sql = "select * from user_info";
	    try{
	        conn = DBUtils.getConnection();
	        ps = conn.prepareStatement(sql);
	        rs = ps.executeQuery();
	        while(rs.next()){
	        	p = new user_info();
	        	p.set_id(rs.getInt(1));
	        	p.set_account(rs.getString(2));
	        	p.set_username(rs.getString(3));
	        	p.set_password(rs.getString(4));
	        	p.set_login_times(rs.getInt(5));
	        	p.set_is_valid(rs.getInt(6));
	        	p.set_is_delete(rs.getInt(7));
	        	pl.add(p);
	        }
	    }catch(SQLException e){
	        e.printStackTrace();
	        throw new SQLException("查询数据失败");
	    }finally{
	        DBUtils.close(null, ps, conn);
	    }*/
	    return list;
	}
}
