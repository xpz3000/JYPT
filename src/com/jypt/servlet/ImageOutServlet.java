package com.jypt.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jypt.dao.ImageDao;



public class ImageOutServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String temp = request.getParameter("id");
        int id = Integer.parseInt(temp);
 
        InputStream inStream = ImageDao.queryImgStream(id);

        ServletOutputStream soutStream = response.getOutputStream();
        if (inStream.equals(null)) {
            soutStream.println("暂无图片 ！<br>");
        } else {
  
            byte[] buffer = new byte[1024];

        
            while (inStream.read(buffer) != -1) {
                soutStream.write(buffer);
            }

            soutStream.flush();
            soutStream.close();
        }
    }

}
