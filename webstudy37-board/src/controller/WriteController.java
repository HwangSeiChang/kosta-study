package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
		request.setAttribute("url", "write.jsp");
		return "home.jsp";
	}
}
