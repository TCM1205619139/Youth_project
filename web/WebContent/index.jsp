<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta http-equiv="X-UA-Compatible" content="ie=edge" />
	<title>Document</title>
	<link rel="stylesheet" href="css/login.css">
	<link rel="stylesheet" href="css/icon.css">
	<script src="js/jquery-3.4.1.min.js"></script>
	<script src="js/login.js"></script>
	<script src="js/lib.js"></script>
</head>
<body>
<div class="registered-box">
	<div class="show-login-btn">登录 <i class="iconfont">&#xe8ee;</i></div>
	<div class="registered-img"></div>
	<form action="register" method="post" class="registered-form">
		<h1>欢迎注册账号</h1>
		<input type="text" name="username" placeholder="用户名" id="reg-userName">
		<input type="password" name="password" placeholder="密码" id="reg-userPwd">
		<input type="password" name="password" placeholder="确认密码">
		<input type="submit" value="确定">
	</form>
</div>



<div class="login-box">
	<div class="registered-btn">注册 <i class="iconfont">&#xe71c;</i></div>
	${error }
	<form action="login" name="user_form" method="post" class="login-form">
		<h1>welcome</h1>
		<input class="txtb" type="text" name="username" placeholder="请输入用户名/手机号">
		<input class="txtb" type="password" name="password" placeholder="请输入密码">
		<input class="login-btn" type="submit" value="登录">
	</form>
</div>
</body>
</html>
<script> 
//取出传回来的参数error并与yes比较
  var errori ='<%=request.getParameter("error")%>';
  if(errori=='1'){
   alert("账号或密码错误!");
  }else if(errori=='2'){
	  alert("用户名重复");
  }
</script>