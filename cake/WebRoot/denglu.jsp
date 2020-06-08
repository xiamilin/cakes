<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head><title>登录界面</title>
<!-- 前台工作人员 -->

</head>
	<body>
	<center>
		<form align="center" action="denglu_deal.jsp" method="post">
		<td>登录用户名：</td><td><input type="text" name="huiyuan"></td><br>
		<td>登录密码：</td><td><input type="password" name="pwd"></td><br>
		<% session.setAttribute("huiyuan",huiyuan);
			session.setAttribute("y",pwd);
		%>
		
		 <input type="submit" value="登录" >&nbsp;&nbsp;
		 </form>
		<form action="zhuce.jsp" method="post">
		<td><input type="submit" value="注册"></td>
		
		</form>
	</body>
</html>
