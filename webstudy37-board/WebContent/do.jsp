<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<jsp:forward page="DispatcherServlet">
	<jsp:param value="PostList" name="command"/>
</jsp:forward>