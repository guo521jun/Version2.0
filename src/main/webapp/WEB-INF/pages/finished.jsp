<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<table border="1" bordercolor="green" cellpadding="10" cellspacing="0">
			<tr>
				<th>商品id</th>
				<th>商品名</th>
				<th>价格</th>
				<th>描述</th>
			</tr>
			<tr>
				<td>${sessionScope.product.id }</td>
				<td>${sessionScope.product.name }</td>
				<td>${sessionScope.product.price }</td>
				<td>${sessionScope.product.descs }</td>
			</tr>
		</table><br>
		<a href="${pageContext.servletContext.contextPath }/product/back">返回后台管理页面</a>
	</center>
</body>
</html>