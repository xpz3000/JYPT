package com.jypt.dao;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.jypt.model.Good;
import com.jypt.util.RowMapper;



public class ImageDao {




    public static InputStream queryImgStream(int id) {
        String sql = "select photo from goodline where id = ?";
        Object[] values = new Object[] {id};
        ImageRM rowMapper = new ImageRM();
        Good good = (Good)GeneralDao.query(sql, values, rowMapper);
  
        if (good.equals(null)) {
            return null;
        }
        return good.getInStream();
    }
}


class ImageRM implements RowMapper {

    @Override
    public Object rowMapping(ResultSet rs) throws SQLException {
        if (rs.next()) {
        	Good good = new Good();
    
            good.setInStream(rs.getBinaryStream("photo"));
            return good;
        }

        return null;
    }

}


