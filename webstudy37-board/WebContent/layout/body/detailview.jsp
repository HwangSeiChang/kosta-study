<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!-- Post Content Column -->
<div class="col-lg-8" style="margin-bottom: 300px">
          <!-- Title -->
          <h1 class="mt-4">${requestScope.board.title}</h1>
          <!-- Author -->
          <p class="lead">
            by ${requestScope.board.name}
          </p>
          <hr>
          
          <!-- Date/Time -->
          <p style="width: auto;float: left">Posted on ${requestScope.board.regdate} </p>
          <p style="width: auto;float: right">조회수 ${requestScope.board.count}</p>
          <hr style="clear: both">
          <!-- Preview Image -->
          <c:choose>
				<c:when test="${requestScope.board.img_name != null}">
			         <img class="img-fluid rounded" src="${pageContext.request.contextPath}/img/${requestScope.board.img_name}" alt="">
				</c:when>
				<c:otherwise>
			         <img class="img-fluid rounded" src="http://placehold.it/750x300" alt="Card image cap">
				</c:otherwise>
		 </c:choose>
          
          <hr>
          
          <!-- Post Content -->
          <p class="lead">${requestScope.board.title}</p>
          <p>${requestScope.board.content}</p>

          <hr>

          <!-- Comments Form -->
          <div class="card my-4">
	            <h5 class="card-header">Leave a Comment:</h5>
	            <div class="card-body">
	              <form>
	                <div class="form-group">
	                  <textarea class="form-control" rows="3"></textarea>
	                </div>
	                <button type="submit" class="btn btn-primary">Submit</button>
	              </form>
	            </div>
          </div>
          
          <form action="DispatcherServlet" name="updateFrame">
          	<input type="hidden" name="command" value="PostUpdatePageMove" >
          	<input type="hidden" name="bno" value="${requestScope.board.bno}" >
          </form>
          
          <form action="DispatcherServlet" name="deleteFrame">
          	<input type="hidden" name="command" value="PostDelete" >
          	<input type="hidden" name="bno" value="${requestScope.board.bno}" >
          </form>
          
          <c:if test="${requestScope.board.id == sessionScope.user.id}">
	          <div class="card my-4" style="float: right; width: auto;">
	          	<button type="button" class="btn btn-secondary" onclick="post_delete()">삭제</button>
	          </div>
	          <div class="card my-4" style="float: right; width: auto;">
	          	<button type="button" class="btn btn-secondary" onclick="post_update()">수정</button>
	          </div>
          </c:if>
</div>
