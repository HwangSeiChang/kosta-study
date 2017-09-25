package controller;

public class HandlerMapping {
	
	private static HandlerMapping instance = new HandlerMapping();
	
	private HandlerMapping() {}
	
	public static HandlerMapping getInstance() {
		return instance;
	}
	
	public Controller create(String command) {
		Controller controller = null;
		
		if(command.equals("PostList")) {
			controller = new PostListController();
		}else if(command.equals("Login")) {
			controller = new LoginController();
		}else if(command.equals("Logout")) {
			controller = new LogOutController();
		}else if(command.equals("DetailView")) {
			controller = new DetailViewController();
		}else if(command.equals("Write")) {
			controller = new WriteController();
		}else if(command.equals("PostGo")) {
			controller = new PostGoController();
		}else if(command.equals("PostUpdatePageMove")) {
			controller = new PostUpdatePageMoveController();
		}else if(command.equals("PostDeletePageMove")) {
			controller = new PostDeletePageMoveController();
		}else if(command.equals("PostUpdate")) {
			controller = new PostUpdateController();
		}else if(command.equals("PostDelete")) {
			controller = new PostDeleteController();
		}else if(command.equals("LoginCheck")) {
			controller = new LoginCheckController();
		}
		
		return controller;
	}
}

