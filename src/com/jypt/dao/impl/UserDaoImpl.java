
package com.jypt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jypt.dao.UserDao;
import com.jypt.model.User;
import com.jypt.util.DBUtil;


public  class UserDaoImpl implements UserDao {
    public Connection conn=null;
    private PreparedStatement ps;
	private ResultSet rs;
	
	public User login(User user) {
		User resultUser =null;
		//1sql
		String sql="select id,username,userpwd from userline where username=? and userpwd=?";
		//2打开链接
        conn=DBUtil.getConnection();
		//3创建执行命令对象
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getUserpwd());
			//4执行命令对象
			rs=ps.executeQuery(); 
			//5结果集
			if(rs.next()){
				resultUser= new User();
				resultUser.setId(rs.getInt("id"));
				resultUser.setUsername(rs.getString("username"));
				resultUser.setUserpwd(rs.getString("userpwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultUser;
	}

	@Override
	public List<User> selectUserList() {
		List<User> list= new ArrayList<User>();
		User resultUser =null;
		//1sql
		String sql="select id,username,userpwd from userline";
		//2打开链接
		conn=DBUtil.getConnection();
		//3创建执行命令对象
		try {
			ps=conn.prepareStatement(sql);
			
			//4执行命令对象
			rs=ps.executeQuery(); 
			//5结果集
			while(rs.next()){
				resultUser= new User();
				resultUser.setId(rs.getInt("id"));
				resultUser.setUsername(rs.getString("username"));
				resultUser.setUserpwd(rs.getString("userpwd"));
				list.add(resultUser);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int registerUser(User user) {
	    int count=0;
			//1sql
			String sql="insert into userline (username,userpwd) values(?,?)";
			//2打开链接
			conn=DBUtil.getConnection();
			//3创建执行命令对象
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1,user.getUsername());
				 ps.setString(2, user.getUserpwd());
				//4执行命令对象
				count=ps.executeUpdate(); 
			 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return count;
	}


	public User selectUserById(User user) {
		User resultUser =null;
		//1sql
		String sql="select id,username,userpwd from userline where id=?";
		//2打开链接
		conn=DBUtil.getConnection();
		//3创建执行命令对象
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, user.getId());
			//4执行命令对象
			rs=ps.executeQuery(); 
			//5结果集
			if(rs.next()){
				resultUser= new User();
				resultUser.setId(rs.getInt("id"));
				resultUser.setUsername(rs.getString("username"));
				resultUser.setUserpwd(rs.getString("userpwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultUser;
	}

	
	public int removeUserById(int id) {
	    int count=0;
		//1sql
		String sql="delete from  userline where id=?";
		//2打开链接
		conn=DBUtil.getConnection();
		//3创建执行命令对象
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1,id);
			 
			//4执行命令对象
			count=ps.executeUpdate(); 
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public int editUser(User user) {
		 int count=0;
			//1sql
			String sql="update userline set userpwd=?,username=? where id=?";
			//2打开链接
			conn=DBUtil.getConnection();
			//3创建执行命令对象
			try {
				ps=conn.prepareStatement(sql);

				 ps.setString(1, user.getUserpwd());
				 ps.setString(2, user.getUsername());
				 ps.setInt(3, user.getId());
				//4执行命令对象
				count=ps.executeUpdate(); 
			 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return count;
	}


}
