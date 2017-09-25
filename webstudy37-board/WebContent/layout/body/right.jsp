<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Sidebar Widgets Column -->
<div class="col-md-4">
		<!-- Search Widget -->
		<div class="card my-4">
			<c:choose>
					<c:when test="${sessionScope.user == null}">
						<h5 class="card-header">Login</h5>
						<div class="card-body">
							<form action="DispatcherServlet" method="post" name="frame">
							<input type="hidden" name="command" value="Login">
							<div class="input-group">
								<input type="text" name="id" class="form-control" placeholder="아이디를 입력하세요..." required="required">
								<span class="input-group-btn"></span>
							</div>
							<div class="input-group">
								<input type="password" name="password" class="form-control" placeholder="비밀번호를 입력하세요..." required="required">
								<span class="input-group-btn"></span>
							</div>
							</form>
							<div class="input-group" style="margin-top: 20px">
								<button class="btn btn-secondary" type="button" onclick="login()">로그인</button>
								&nbsp;&nbsp;
								<button class="btn btn-secondary" type="button">회원가입</button>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<h5 class="card-header">MyPage</h5>
						<div class="card-body">
							<form action="DispatcherServlet" method="post" name="frame">
							<input type="hidden" name="command" value="Login">
							<div class="input-group" style="margin-bottom: 20px">
								${sessionScope.name}님 환영합니다.
							</div>
							<div class="input-group">
								<a href="#">마이페이지</a>
							</div>
							<div class="input-group">
								<a href="DispatcherServlet?command=Logout">로그아웃</a>
							</div>
							</form>
							<hr>
							<div class="input-group" style="margin-top: 20px">
								<button class="btn btn-secondary" onclick="write_go()">포스트 작성하기</button>
							</div>
						</div>	
					</c:otherwise>
			</c:choose>
		</div>
</div>