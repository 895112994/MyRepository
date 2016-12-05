<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <body>
  <a href="addUser">新增用户</a>
   <h1>用户列表</h1>
   <c:forEach items="${userList }" var="ul">
	---------${ul.value.userName }
	---------${ul.value.password }
	---------${ul.value.tel }
	---------${ul.value.email }
	
	<a href="${ul.value.userName }">查看用户</a>
	<a href="delete/${ul.value.userName }">删除用户</a>
	<a href="update/${ul.value.userName }">更新用户</a>
	<br/>
   
   </c:forEach>

  </body>
</html>
