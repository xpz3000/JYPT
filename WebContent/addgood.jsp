<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="style/mycss.css" rel="stylesheet" type="text/css" />
<link href="style/texts.css" rel="stylesheet" type="text/css" />
<link href="style/btn.css" rel="stylesheet" type="text/css" />

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
	    <table align="right">
		<input type="hidden" name="method" value="addGood"> 
		<tr height="50px">
			<td width="380px" align="right">商品名称</td>
			<td><input name="goodname" style="border-radius:5px; widht:200px; height:20px;padding-left:;"placeholder="请输入商品名称"></td>
		</tr>
		<tr height="50px">
			<td width="380px" align="right">商品类型</td>
			<td><input name="goodtype" style="border-radius:5px; widht:200px; height:20px;padding-left:;"placeholder="请输入商品类型"></td>
		</tr>
	<tr height="50px">
			<td width="380px" align="right">商品价格</td>
			<td><input name="goodprice" style="border-radius:5px; widht:200px; height:20px;padding-left:;"placeholder="请输入商品价格"></td>
		</tr>
	<tr height="50px">
			<td width="380px" align="right">交易地点</td>
			<td><input name="adress" style="border-radius:5px; widht:200px; height:20px;padding-left:;"placeholder="交易地点"></td>
		</tr>
		<tr height="50px">
			<td width="380px" align="right">商品图片</td>
			<td><input type="file" name="photo" style="border-radius:5px; widht:200px; height:20px;padding-left:;"></td>
		</tr>
		<tr height="50px">
        <td width="380px" align="right">      </td>
			<td><input type="submit" value="确认发布" style="border-radius:5px; widht:200px; height:20px;padding-left:;"></td>
		</tr>
		
	
	</table>
	</table>
	</td>
    <td width="40" background="images/middle4.jpg">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="5"><img src="images/bottom.jpg" width="780" height="82"></td>
  </tr>
</table>
<!-- 尾部 -->
<br />

</BODY>

</html>