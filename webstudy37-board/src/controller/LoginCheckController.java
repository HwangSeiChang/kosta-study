package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCheckController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
		String id = (String)request.getSession().getAttribute("id");
		int bno = Integer.parseInt(request.getParameter("bno"));
		String url = null;
		//로그인안됨
		if(id == null) {
			url = "system/write_fail.jsp";
		}else {
			url = "DispatcherServlet?command=DetailView&bno="+bno;
		}
		
		return url;
	}
}




