package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardVO;
import model.EntityDAO;

public class DetailViewController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		/*
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		System.out.println("글을읽고있는 회원의 ID : " +id);
		String[] boardNo = null;
		
		Cookie myCookie = null;						//쿠키값 받아오기
		Cookie[] cookies = request.getCookies(); 	//생성되어있는 모든 쿠키를 얻어온다.
		
		HashMap<String,ArrayList<Cookie>> myCookieValueMap = new HashMap<String,ArrayList<Cookie>>();
		ArrayList<Cookie> CookieList = new ArrayList<Cookie>();
		
		for(int i=0 ; i <cookies.length;i++) {
			if(cookies[i].getName().equals(("myCookie"))) {	//쿠키중 myCookie라는 이름으로 생성된게있으면
				System.out.println("쿠키의 Value["+i+"] : " +cookies[i].getValue());
				
				
				//myCookieValueMap.put(id, CookieList);
			}else {
				System.out.println("myCookie 쿠키값이 전혀 없다");
			}
		}*/
		
		/*boardNo = cookies[i].getValue().split("/");
		if(request.getParameter("bno").equals(boardNo[1])) {
			System.out.println("현재 게시판번호로 저장된 쿠키값이 존재합니다. 조회수 올리지않습니다.");
		}else {
			System.out.println("현재 게시판번호로 저장된 쿠키값이 존재하지않습니다. 조회수를 올립니다.");
			System.out.println("현재 존재 쿠키값"+cookies[i].getValue());
			//쿠키생성
			myCookie = new Cookie("myCookie", "myCookie/"+bno);
			//쿠키유효기간 1시간
			myCookie.setMaxAge(3600);
			//쿠키할당
			response.addCookie(myCookie);
			//조회수증가
			EntityDAO.getInstance().updateRawCount(bno);
		}*/
		
		EntityDAO.getInstance().updateRawCount(bno);
		BoardVO board = EntityDAO.getInstance().postView(bno);
		if(board != null)
			request.setAttribute("board", board);
		else
			System.out.println("게시판 번호 정보를 가져올 수 없습니다.");
		
		request.setAttribute("url", "detailview.jsp");
		return "home.jsp";
	}
}






