<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0>

<table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td colspan="5" align="center" valign="middle"><img src="images/top.jpg" width="400" height="250" ></td>
  </tr>
  <tr>
    <td colspan="5"><img src="images/middle1.jpg" width="780" height="47"></td>
  </tr>
  <tr>
    <td width="38" background="images/middle2.jpg">&nbsp;</td>
    <td width="172">
	<table align="center">
		<tr>
		  <td><a href="shop.jsp">返回</a></td>
		</tr>

		<tr>
		<td><a href="LoginServlet?method=logout" target="index">退出登录</a></td>
		</tr>
	</table>
	</td>
    <td width="35" background="images/layout_24.gif">&nbsp;</td>
    <td width="495">
	          <table align="center">
			<tr>
		    <th>商品编号</th>
			<th>商品名称</th>
			
			<th>商品类型</th>
			<th>价格</th>
			<th>交易地点</th>

			<th>  </th>
		</tr>
		
<c:forEach items="${requestScope.shopCar}" var="s">

			<tr>
			    <td>${s.id}</td>
				<td>${s.goodname}</td>
				
				<td>${s.goodtype}</td>
				<td>${s.goodprice}</td>
				<td>${s.adress}</td>
		 
			</tr>
		</c:forEach>
</table>
<!-- 尾部 -->
<br />
</td>
</tr>
</table>
</BODY>
</html>