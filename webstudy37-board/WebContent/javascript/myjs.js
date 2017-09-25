/**
 * 로그인
 */
function login(){
	document.frame.submit();
}

/**
 * 글작성 페이지로 이동
 */
function write_go(){
	location.href="DispatcherServlet?command=Write";
}

/**
 * 글작성하기
 */
function post_write(){
	document.postFrame.submit();
}

/**
 * 글수정 / 글수정페이지이동
 */
function post_update(){
	document.updateFrame.submit();
}

/**
 * 글삭제
 */
function post_delete(){
	var result = confirm("정말 삭제하시겠습니까?");
	
	if(result) {
		document.deleteFrame.submit();
	}
}

function post_read(){
	
}


