package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EntityDAO;
import model.UserVO;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String url = "";
		UserVO user = EntityDAO.getInstance().login(id, password);
		HttpSession session = request.getSession(false);
		session.setAttribute("user", user);
		
		if(user != null) {
			/*if(session == null) {*/
			session = request.getSession();
			session.setAttribute("id", user.getId());
			session.setAttribute("pw", user.getPassword());
			session.setAttribute("name", user.getName());
			url = "do.jsp";
			/*}else {
				System.out.println("이미 생성되어있는 Session이 존재합니다.");
			}*/
		}else {
			url = "system/login_fail.jsp";
		}
		
		return url;
	}

}
