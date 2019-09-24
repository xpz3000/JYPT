<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- javascript -->
<script type="text/javascript">
function pass(){
	var pass = false;
	if( document.myForm.username.value =="" ){
		alert("用户名不能为空");
		pass= false;
	}else if(document.myForm.userpwd.value == ""){
		alert("密码不能为空");
		pass = false;
	} else if(document.myForm.userpwd.value != document.myForm.userpwd1.value){
		alert("两次密码不一样");
		pass = false;
	}  else {
		pass = true;
	}
	return pass;
}

</script>

</head>
<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0>

<table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td colspan="5" align="center" valign="middle"><img src="images/top.jpg" width="480" height="250" ></td>
  </tr>
  <tr>
    <td colspan="5"><img src="images/middle1.jpg" width="780" height="47"></td>
  </tr>
  <tr>
    <td width="38" background="images/middle2.jpg">&nbsp;</td>
    <td width="172">
	<table align="center">
		<tr>
		  <td><a href="index.jsp">返回首页</a></td>
		</tr>
		<tr>
		  <td><a href="login.jsp">用户登陆</a></td>
		</tr>
	</table>
	</td>
    <td width="35" background="images/layout_24.gif">&nbsp;</td>
    <td width="495">
	<form action="LoginServlet" method="post">
	<!-- <form action="UserManagerServlet" method="get"> -->
		<table align="center">
			<tr>
				<td>用户注册：</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2"><hr/></td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username"><br></td>
			<tr>
			
				<td>密码：</td>
				<td><input type="password" name="userpwd"><br></td>
			<tr>
			
			<tr>
				<td><input type="hidden" name="method" value="register"> </td>
				<td><input type="submit" value="注册"></td>
				<td><input type="reset" value="重置" class="btn"></td>
			</tr>
		</table>
	</form>
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
</HTML>