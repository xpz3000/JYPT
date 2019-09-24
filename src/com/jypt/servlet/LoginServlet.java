package com.jypt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jypt.dao.UserDao;
import com.jypt.dao.impl.UserDaoImpl;
//import com.sx.dao.impl.UserDaoImpl;
import com.jypt.model.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doPost(  request,   response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String method=request.getParameter("method");
		if("register".equals(method)){


			String username=new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
			String userpwd=request.getParameter("userpwd");

			UserDao userDao = new UserDaoImpl();
			User user = new User();
			user.setUsername(username);
			user.setUserpwd(userpwd);
			userDao.registerUser(user);

				List<User> list= userDao.selectUserList();
				request.setAttribute("userInfoAll", list);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if("logout".equals(method)){
			
			HttpSession session = request.getSession();
			session.removeAttribute("loginUser"); 
			session.invalidate();
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
		else if("login".equals(method)){
			String name=request.getParameter("username");
			String pwd=request.getParameter("userpwd");
			User user =new User();
			user.setUsername(name);
			user.setUserpwd(pwd);

			UserDao userDao = new UserDaoImpl();
			User resultUser=userDao.login(user);
			if(resultUser!=null){
				
				HttpSession session = request.getSession();
	             session.setAttribute("loginUser",name);
				

				request.getRequestDispatcher("shop.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}

	

}}
