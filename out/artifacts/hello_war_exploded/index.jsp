<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我是首页</title>
</head>
<body>
<h1>我是首页</h1>
<c:if test="${empty existUser}">
	<h2>未登录</h2> <a href="/login.jsp">用户登陆</a> <a href="/regist.jsp">用户注册</a>
</c:if>

<c:if test="${not empty existUser}">
	<h2>欢迎你,${existUser.nickname } <a href="/invalidate.jsp">退出</a></h2>
	<c:if test="${existUser.role == 'admin'}">
		<a href="/add_product.jsp">添加商品</a>
		<a href="/exportRank">导出销售榜单</a>
	</c:if>
	<c:if test="${existUser.role == 'user'}">
		<a href="/cart.jsp">查看购物车</a>
	</c:if>
	<a href="/listOrders">查看订单</a>
</c:if>
<a href="/listProduct">查看商品</a>
</body>
</html>