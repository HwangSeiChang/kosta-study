package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BoardVO;
import model.EntityDAO;

public class PostGoController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		HttpSession session = request.getSession(false);
		String id = (String)session.getAttribute("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String img_name = request.getParameter("img_name");
		
		System.out.println("id:"+id);
		System.out.println("title:"+title);
		System.out.println("content:"+content);
		System.out.println("img_name:"+img_name);
		
		for(int i=0;i<50;i++)
			EntityDAO.getInstance().postWrite(new BoardVO(title,content,id,img_name));
		
		return "redirect:do.jsp";
	}

}
