package com.jypt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jypt.dao.UserDao;
import com.jypt.dao.impl.UserDaoImpl;
import com.jypt.model.User;



public class UserManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

    public UserManagerServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(  request,   response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String method= request.getParameter("method");
    if("delete".equals(method)){
    	  String id= request.getParameter("id");
    	System.out.println("delete id value:"+id);
    	 UserDao userDao= new  UserDaoImpl();
    	 userDao.removeUserById(Integer.parseInt(id));
    	 
 		List<User> list= userDao.selectUserList();
 		request.setAttribute("userInfoAll", list);
    	 request.getRequestDispatcher("showUserList.jsp").forward(request, response);
    }else if("showUserList".equals(method)){
		 UserDao userDao= new  UserDaoImpl();
		List<User> list= userDao.selectUserList();
		request.setAttribute("userInfoAll", list);
		request.getRequestDispatcher("showUserList.jsp").forward(request, response);
    }
   else if("showUserById".equals(method)){
		 int id=Integer.parseInt(request.getParameter("id"));
		 UserDao userDao= new  UserDaoImpl();
		 User user =new User();
		 user.setId(id);
    	 User resultUser= userDao.selectUserById(user);
    	 request.setAttribute("updateUser", resultUser);
		request.getRequestDispatcher("updateUser.jsp").forward(request, response);
   } 
   
	}

}
