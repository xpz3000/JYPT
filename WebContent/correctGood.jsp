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
<script></script>
<form action="GoodManagerServlet" method="post">
<!-- <form action="GoodManagerServlet" method="get"> -->

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
    <% String studentName = request.getParameter("studentName");   %>
	    <table align="right">

		<tr height="50px">
			<td width="380px" align="right">商品名称</td>
			<td><input name="goodname" style="border-radius:5px; widht:200px; height:20px;padding-left:;"placeholder="请修改商品名称"></td>
		</tr>
		<tr height="50px">
			<td width="380px" align="right">商品类型</td>
			<td><input name="goodtype" style="border-radius:5px; widht:200px; height:20px;padding-left:;"placeholder="请修改商品类型"></td>
		</tr>
		<input type="hidden" name="method" value="correctGood"> 
        <input type="hidden" name="id" value="${requestScope.correct.id}">
	<tr height="50px">
			<td width="380px" align="right">商品价格</td>
			<td><input name="goodprice" style="border-radius:5px; widht:200px; height:20px;padding-left:;"placeholder="请修改商品价格"></td>
		</tr>
	<tr height="50px">
			<td width="380px" align="right">交易地点</td>
			<td><input name="adress" style="border-radius:5px; widht:200px; height:20px;padding-left:;"placeholder="请修改交易地点"></td>
		</tr>
		
		<tr height="50px">
        <td width="380px" align="right">      </td>
			<td><input type="submit" value="确认修改" style="border-radius:5px; widht:200px; height:20px;padding-left:;"></td>
		</tr>
		
	  </table>
	</table>

<tr>
    <td width="40" background="images/middle4.jpg">&nbsp;</td>
 </tr>
  <tr>
    <td colspan="5"><img src="images/bottom.jpg" width="780" height="82"></td>
  </tr>

</table>
<!-- 尾部 -->
<br />
</form>
</BODY>
</html>