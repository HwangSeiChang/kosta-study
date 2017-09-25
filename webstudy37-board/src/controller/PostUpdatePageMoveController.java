package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardVO;
import model.EntityDAO;

public class PostUpdatePageMoveController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		BoardVO board = EntityDAO.getInstance().postView(Integer.parseInt(request.getParameter("bno")));
		request.setAttribute("board", board);
		request.setAttribute("url", "update.jsp");
		return "home.jsp";
	}
}
