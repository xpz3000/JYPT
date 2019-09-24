
package com.jypt.dao.impl;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;










import com.jypt.dao.GoodDao;
import com.jypt.model.Good;
import com.jypt.model.User;
import com.jypt.util.DBUtil;
import com.jypt.util.ImageUtil;



public class GoodDaoImpl implements GoodDao {
	 public Connection conn=null;
	    private PreparedStatement ps;
		private ResultSet rs;



		public int addGood(Good good) {
			FileInputStream in = null;

		    int count=0;
				
				String sql="insert into goodline (goodname,goodtype,goodprice,adress,photo,id,username) values(?,?,?,?,?,?,?)";
			
				conn=DBUtil.getConnection();
				
				try {
					 in = ImageUtil.readImage(good.getPhoto());
					 ps=conn.prepareStatement(sql);
					 ps.setInt(6,good.getId());
					 ps.setString(1,good.getGoodname());
					 ps.setString(2, good.getGoodtype());
					 ps.setString(3,good.getGoodprice());
					 ps.setString(4,good.getAdress());
					 ps.setBinaryStream(5,in);
					 ps.setString(7,good.getUsername());
					
					count=ps.executeUpdate(); 
				 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return count;
		
		}
		
		public List<Good> showGoodList() {
			List<Good> list= new ArrayList<Good>();
			Good resultGood =null;
		
			String sql=" select id,goodname,goodtype,goodprice,adress,username from goodline";
		
			conn=DBUtil.getConnection();
			
			try {

				ps=conn.prepareStatement(sql);
				
				
				rs=ps.executeQuery(); 
				
				
				while(rs.next()){
										   	                
					resultGood= new Good();
					resultGood.setId(rs.getInt("id"));
					resultGood.setGoodname(rs.getString("goodname"));
					resultGood.setUsername(rs.getString("username"));
					resultGood.setGoodtype(rs.getString("goodtype"));
					resultGood.setGoodprice(rs.getString("goodprice"));
					resultGood.setAdress(rs.getString("adress"));															
					list.add(resultGood);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
			return list;
		}
		
		public  List<Good> myGoodList(Good good) {
			List<Good> list= new ArrayList<Good>();
			Good resultGood =null;
			//1sql
			String sql=" select id ,goodname,goodtype,goodprice,adress from goodline where username=?";
			
			conn=DBUtil.getConnection();
		
			try {

				ps=conn.prepareStatement(sql);
				ps.setString(1, good.getUsername());
				
				
				rs=ps.executeQuery(); 
				
				while(rs.next()){
										   	                
					resultGood= new Good();
					resultGood.setId(rs.getInt("id"));
					resultGood.setGoodname(rs.getString("goodname"));
					resultGood.setGoodtype(rs.getString("goodtype"));
					resultGood.setGoodprice(rs.getString("goodprice"));
					resultGood.setAdress(rs.getString("adress"));															
					list.add(resultGood);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
			return list;
		}						
		
		public int removeGoodById(int id) {
		    int count=0;
			
			String sql="delete from  goodline where id=?";
			
			conn=DBUtil.getConnection();
		
			try {
				ps=conn.prepareStatement(sql);
				ps.setInt(1,id);
				
				count=ps.executeUpdate(); 
			 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return count;
		}
		
		public int correctGood(Good good){
			
			
				 int count=0;
					
					String sql="update goodline set goodname=?,goodprice=?,goodtype=?,adress=? where id=?";
				
					conn=DBUtil.getConnection();
					
					try {
						ps=conn.prepareStatement(sql);

						 ps.setString(1, good.getGoodname());
						 ps.setString(2, good.getGoodprice());
						 ps.setString(3, good.getGoodtype());
						 ps.setString(4, good.getAdress());
						 ps.setInt(5, good.getId());
						
						count=ps.executeUpdate(); 
					 
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return count;
			}
		
		public Good selectGoodById(Good good) {
			Good resultGood =null;
			
			String sql="select id,goodname,goodprice,goodtype,adress from goodline where id=?";
		
			conn=DBUtil.getConnection();
		
			try {
				ps=conn.prepareStatement(sql);
				ps.setInt(1, good.getId());
			
				rs=ps.executeQuery(); 
			
				if(rs.next()){
					resultGood= new Good();
					resultGood.setId(rs.getInt("id"));
					resultGood.setGoodname(rs.getString("goodname"));
					resultGood.setGoodtype(rs.getString("goodtype"));
					resultGood.setGoodprice(rs.getString("goodprice"));
					resultGood.setAdress(rs.getString("adress"));	
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return resultGood;
		}
		
		public int addToCar(Good resultGood) {
			//FileInputStream in = null;
			
			

		    int count=0;
				
				String sql="insert into shopcar (goodname,goodtype,goodprice,adress,buyname,id) values(?,?,?,?,?,?)";
			
				conn=DBUtil.getConnection();
			
				try {
					// in = ImageUtil.readImage(good.getPhoto());
					 ps=conn.prepareStatement(sql);
					 
					 ps.setString(1,resultGood.getGoodname());
					 ps.setString(2, resultGood.getGoodtype());
					 ps.setString(3,resultGood.getGoodprice());
					 ps.setString(4,resultGood.getAdress());
					 ps.setString(5,resultGood.getBuyname());
					 ps.setInt(6,resultGood.getId());
					 
				//	 ps.setBinaryStream(5,in);
				//	 ps.setString(7,resultGood.getUsername());
					//4执行命令对象
					count=ps.executeUpdate(); 
				 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				return count;
		
		}
		
		public  List<Good> shopCar(Good good) {
			List<Good> list= new ArrayList<Good>();
			Good resultGood =null;
			String sql=" select id ,goodname,goodtype,goodprice,adress from shopcar where buyname=?";
			conn=DBUtil.getConnection();
			try {

				ps=conn.prepareStatement(sql);
				ps.setString(1, good.getBuyname());				
				rs=ps.executeQuery(); 				
				while(rs.next()){
										   	                
					resultGood= new Good();
					resultGood.setId(rs.getInt("id"));
					resultGood.setGoodname(rs.getString("goodname"));
					resultGood.setGoodtype(rs.getString("goodtype"));
					resultGood.setGoodprice(rs.getString("goodprice"));
					resultGood.setAdress(rs.getString("adress"));															
					list.add(resultGood);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
			return list;
		}						
		
		

		}
		

			
		

