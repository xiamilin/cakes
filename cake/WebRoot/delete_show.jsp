<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<html>
	<head><title>删除会员中</title></head>
	<body>
<%request.setCharacterEncoding("UTF-8");%>
		<jsp:useBean id="b" class="vo.huiyuan" scope="request"/>
		<jsp:useBean id="c" class="qianTai.qian" scope="request"/>
		<jsp:setProperty name="b" property="Hid"/>
		<%
			int d = b.getId();
			boolean t=c.delete(d);
		%>
		
		<% if(t){ %>
		删除会员成功！<%}else {%> 删除会员失败！<%} %>
		</body>
		</html>
	