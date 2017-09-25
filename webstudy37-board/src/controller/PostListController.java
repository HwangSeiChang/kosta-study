package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EntityDAO;

/**
 * DAO 에서 총게시물수를 반환
 * 
 * client로 부터 pageNo를 전달받는다
 * 만약pageNo가 없으면 1페이지로 처리
 * 
 * PagingBean 을 생성
 * DAO에서 현 페이지에 해당하는 게시물 리스트를 반환받는다.
 * ( 이때 PagingBean 객체를 전달해야 한다.
 * ListVO를 생성해서 request에 공유한다
 * @author kosta-inst
 *
 */
public class PostListController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		request.setAttribute("post", EntityDAO.getInstance().getPostList());
		request.setAttribute("url", "list.jsp");
		return "home.jsp";
	}
}
