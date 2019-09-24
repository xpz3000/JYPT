package com.jypt.servlet;

import java.io.IOException;
import java.util.List;

import com.jypt.dao.GoodDao;
import com.jypt.dao.impl.GoodDaoImpl;
import com.jypt.model.Good;







import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




public class GoodManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GoodManagerServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String method= request.getParameter("method");
		 HttpSession session = request.getSession(); 
		 
		 if("addGood".equals(method)){


			    String username = session.getAttribute("loginUser").toString();
				String goodname=new String(request.getParameter("goodname").getBytes("ISO-8859-1"),"UTF-8");
				String goodtype=new String(request.getParameter("goodtype").getBytes("ISO-8859-1"),"UTF-8");
				String goodprice=new String(request.getParameter("goodprice").getBytes("ISO-8859-1"),"UTF-8");
				String adress=new String(request.getParameter("adress").getBytes("ISO-8859-1"),"UTF-8");
				String photo=new String(request.getParameter("photo").getBytes("ISO-8859-1"),"UTF-8");

				GoodDao goodDao = new GoodDaoImpl();
				Good good = new Good();
				good.setGoodname(goodname);
				good.setGoodtype(goodtype);
				good.setGoodprice(goodprice);
				good.setAdress(adress);
				good.setPhoto(photo);
				good.setUsername(username);
				goodDao.addGood(good);

					List<Good> list= goodDao.showGoodList();
					request.setAttribute("manygood", list);
				
				request.getRequestDispatcher("showGoodList.jsp").forward(request, response);
		
		 
	 }else if("showGoodList".equals(method)){
			 					 
			 	GoodDao goodDao = new GoodDaoImpl();
		    	List<Good> list=goodDao.showGoodList();
		    	request.setAttribute("manygood", list);
				request.getRequestDispatcher("showGoodList.jsp").forward(request, response);
		    			    			   
		     
				
        }else if("my".equals(method)){		        	
		        	 String name = session.getAttribute("loginUser").toString();
		        	 GoodDao goodDao= new  GoodDaoImpl();
		    		 Good good =new Good();
		    		 good.setUsername(name);
		    		 List<Good> resultGood= goodDao.myGoodList(good);
		        	 request.setAttribute("myGoodList", resultGood); 
		        	 request.getRequestDispatcher("my.jsp").forward(request, response);
		        	
		        	 
	   }else if("delete".equals(method)){
		       	  String id= request.getParameter("id");
		      	System.out.println("delete id value:"+id);
		      	 GoodDao goodDao= new  GoodDaoImpl();
		      	 goodDao.removeGoodById(Integer.parseInt(id));
		      	 
		      	List<Good> list= goodDao.showGoodList();
		 		request.setAttribute("manygood", list);
		 
		      	 request.getRequestDispatcher("showGoodList.jsp").forward(request, response);
		 
		 
		    }else if("correctGood".equals(method)){
		    	 
		    	GoodDao goodDao= new  GoodDaoImpl();
		  	    int id=Integer.parseInt(request.getParameter("id"));
		  	    String goodname=new String(request.getParameter("goodname").getBytes("ISO-8859-1"),"UTF-8");
		  	    String goodprice=new String(request.getParameter("goodprice").getBytes("ISO-8859-1"),"UTF-8");
		  	    String goodtype=new String(request.getParameter("goodtype").getBytes("ISO-8859-1"),"UTF-8");
		  	    String adress=new String(request.getParameter("adress").getBytes("ISO-8859-1"),"UTF-8");
		  		
		  		Good good = new Good();
		  		good.setId(id);
		  		good.setGoodname(goodname);
		  		good.setGoodprice(goodprice);
		  		good.setGoodtype(goodtype);
		  		good.setAdress(adress);
		  		goodDao.correctGood(good);
		  	   
		  	   
		  	   
		  		List<Good> list= goodDao.showGoodList();
		  		request.setAttribute("manygood", list);
		   		request.getRequestDispatcher("showGoodList.jsp").forward(request, response);
		     }else if("showGoodById".equals(method)){
				 int id=Integer.parseInt(request.getParameter("id"));
				 GoodDao goodDao= new  GoodDaoImpl();
				 Good good =new Good();
				 
				 good.setId(id);
				 Good resultGood= goodDao.selectGoodById(good);
		    	 request.setAttribute("correct", resultGood);
				 request.getRequestDispatcher("correctGood.jsp").forward(request, response);
		  
		     
		     }else if("addToCar".equals(method)) {
		    	 
		    	 String name = session.getAttribute("loginUser").toString();
		    	 int id=Integer.parseInt(request.getParameter("id"));
				 GoodDao goodDao= new  GoodDaoImpl();
				 Good good =new Good();
				 
				 good.setId(id);
				 good.setBuyname(name);
				 Good resultGood= goodDao.selectGoodById(good);		
				 
				// goodDao.addToCar(resultGood);
				 Good good1 = new Good();
				 good1.setGoodname(resultGood.getGoodname());
				 good1.setGoodtype(resultGood.getGoodtype());
				 good1.setGoodprice(resultGood.getGoodprice());
				 good1.setAdress(resultGood.getAdress());
				 good1.setBuyname(name);
				 good1.setId(id);
				 goodDao.addToCar(good1);
				 request.getRequestDispatcher("shop.jsp").forward(request, response);
			
		         
		    	 
		     }else if("shopCar".equals(method)) {
		    	 String name = session.getAttribute("loginUser").toString();
		    	 GoodDao goodDao= new  GoodDaoImpl();
	    		 Good good =new Good();
	    		 good.setBuyname(name);
	    		 List<Good> resultGood= goodDao.shopCar(good);
	        	 request.setAttribute("shopCar", resultGood); 
	        	 request.getRequestDispatcher("shopCar.jsp").forward(request, response);
		     }
		    	 
	}	 }
		  
	
	
