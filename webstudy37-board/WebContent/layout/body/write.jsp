<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Blog Entries Column -->
<div class="col-md-8">
		<h1 class="my-4">
			Blog
		</h1>

		<!-- Blog Post -->
		<div class="card mb-4">
			<!--<img class="card-img-top" src="http://placehold.it/750x300" alt="Card image cap"> -->
			<form name="postFrame" action="DispatcherServlet" method="post">
			<input type="hidden" name="command" value="PostGo">
			<div class="card-body">
				<p class="card-text">
					<input type="text" name="title" class="form-control" placeholder="제목을 입력하세요." required="required">
				</p>
				<p class="card-text">
					<textarea class="form-control" name="content" rows="18" placeholder="내용을 입력하세요." required="required"></textarea>
				</p>
			</div>
			<div class="card-footer text-muted" style="height: 65px">
				<input type="text" name="img_name" class="form-control" style="float: left; width: 50%" placeholder="이미지 파일 이름을 입력하세요." required="required">
				<input type="button" class="btn btn-primary" style="width: auto; float: right" value="작성하기" onclick="post_write()">
			</div>
			</form>
		</div>
</div>