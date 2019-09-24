package com.jypt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.jypt.util.DBUtil;
import com.jypt.util.RowMapper;



public class GeneralDao    {

	
	public static Object query(String sql, Object[] values, RowMapper rowMapper) {
	    Object object = null;
	    Connection conn = DBUtil.getConnection();
	    PreparedStatement preStmt = null;
	    ResultSet rs = null;  
	    try {
	        preStmt= conn.prepareStatement(sql);
	        for(int i =0;i<values.length;i++)
	            preStmt.setObject(i+1, values[i]); 
	        rs = preStmt.executeQuery();
	        object = rowMapper.rowMapping(rs);  
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }finally{
	        DBUtil.closeResource(conn, preStmt, preStmt, rs);
	    }
	    return object;
	}

	   

}
