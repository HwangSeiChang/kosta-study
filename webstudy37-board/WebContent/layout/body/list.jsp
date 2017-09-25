<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!-- Blog Entries Column -->
<div class="col-md-8">
		<h1 class="my-4">
			BootStrap <small> 2조</small>
		</h1>

		<!-- Blog Post -->
		<c:forEach items="${requestScope.post.list}" var="post">
		<div class="card mb-4">
			<c:choose>
				<c:when test="${post.img_name != null}">
					<img class="card-img-top" src="img/${post.img_name}" alt="Card image cap">
				</c:when>
				<c:otherwise>
					<img class="card-img-top" src="http://placehold.it/750x300" alt="Card image cap">
				</c:otherwise>
			</c:choose>
			<div class="card-body">
				<h2 class="card-title">${post.title}</h2>
				<p class="card-text">${post.content}</p>
				<%-- <a href="DispatcherServlet?command=DetailView&bno=${post.bno}" class="btn btn-primary">구독하기 &rarr;</a> --%>
				<a href="DispatcherServlet?command=LoginCheck&bno=${post.bno}" class="btn btn-primary">구독하기 &rarr;</a>
			</div>
			<div class="card-footer text-muted">
				Post on by ${post.regdate}        <small>조회수 &nbsp; ${post.count}</small>
			</div>
		</div>
		</c:forEach>
		
		
		<div class="pagination" style="margin-bottom: 50px">
			<c:set var="pageInfo" value="${post.pagingBean}" />
			<c:if test="${pageInfo.previousPageGroup}">
				<a href="DispatcherServlet?command=PostList&nowPage=${pageInfo.startPageOfPageGroup-1}">&laquo;</a>
			</c:if>
			
			<c:forEach begin="${pageInfo.startPageOfPageGroup }" end="${pageInfo.endPageOfPageGroup }" var="groupNumber">
				<a href="DispatcherServlet?command=PostList&nowPage=${groupNumber}">${groupNumber}</a>
			</c:forEach>
			
			<c:if test="${pageInfo.nextPageGroup}">
				<a href="DispatcherServlet?command=PostList&nowPage=${pageInfo.endPageOfPageGroup+1}">&raquo;</a>
			</c:if>
		</div>
</div>