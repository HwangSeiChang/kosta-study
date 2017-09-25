package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class EntityDAO {
	private static EntityDAO instance =  new EntityDAO();
	DataSource dataSource;
	private EntityDAO() {
		dataSource = DataSourceManager.getInstance().getDataSource();
	}
	public static EntityDAO getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if(rs != null)
			rs.close();
		if(pstmt != null)
			pstmt.close();
		if(con != null)
			con.close();
	}
	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		closeAll(null, pstmt, con);
	}
	
	public UserVO login(String id, String pw) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVO user = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("select * from b_user where id=? and password=?");
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next())
				user = new UserVO(rs.getString(1),rs.getString(2),rs.getString(3));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeAll(pstmt, con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return user;
	}
	
	/**
	 * select p.*
	 * from(
	 *	select row_number() over(order by bno desc) as board_no,id,bno
	 *	from board order by bno desc
	 *	) p, b_user buser
	 * where board_no between 1 and 5 and p.id = buser.id
	 * order by bno desc;
	 * 
	 */
	//매개변수에 PagingBean을 명시해야함
	/*public ArrayList<BoardVO> getPostList(){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		Connection con = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select p.bno, p.title, p.content, p.regdate, p.count, p.id, p.img_name ");
			sql.append("from( ");
			sql.append("select row_number() over(order by bno desc) as board_no,bno,title,content,regdate,count,id,img_name ");
			sql.append("from board order by bno desc ");
			sql.append(") p, b_user buser ");
			sql.append("where board_no between 1 and 5 and p.id = buser.id ");
			sql.append("order by bno desc");
			rs = con.prepareStatement(sql.toString()).executeQuery();
			while(rs.next())
				list.add(new BoardVO(
						rs.getInt(1),rs.getString(2),
						rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getString(7)));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeAll(rs,null, con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}*/
	
	public int getAllPostCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int count = 0;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("select count(*) from board");
			rs = pstmt.executeQuery();
			if(rs.next())
				count = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeAll(pstmt, con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	
	public ListVO getPostList(String nowPage){
		ArrayList<BoardVO> board = new ArrayList<BoardVO>();
		PagingBean page = null;
		
		if(nowPage == null || nowPage.equals(null))
			page = new PagingBean(getAllPostCount());
		else
			page = new PagingBean(getAllPostCount(), Integer.parseInt(nowPage));
		
		ListVO list = new ListVO(board,page);
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select p.bno, p.title, p.content, p.regdate, p.count, p.id, p.img_name ");
			sql.append("from( ");
			sql.append("select row_number() over(order by bno desc) as board_no,bno,title,content,regdate,count,id,img_name ");
			sql.append("from board order by bno desc ");
			sql.append(") p, b_user buser ");
			sql.append("where board_no between ? and ? and p.id = buser.id ");
			sql.append("order by bno desc");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, page.getStartRowNumber());
			pstmt.setInt(2, page.getEndRowNumber());
			rs = pstmt.executeQuery();
			while(rs.next())
				list.getList().add(new BoardVO(
						rs.getInt(1),rs.getString(2),
						rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getString(7)));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeAll(rs,null, con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public BoardVO postView(int bno) {
		BoardVO board = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			pstmt = con.prepareStatement("select board.bno, board.title, board.content, board.regdate, board.count, board.id, board.img_name, b_user.name "+ 
					"from b_user b_user, board board "+ 
					"where b_user.id = board.id and board.bno = ?");
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				board = new BoardVO(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeAll(pstmt, con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return board;
	}
	
	public void postWrite(BoardVO board) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement("insert into board(bno, title, content, regdate, id, count,img_name) "
					+ "values(board_seq.nextval,?,?,sysdate,?,0,?)");
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getId());
			pstmt.setString(4, board.getImg_name());
			pstmt.executeUpdate();
			System.out.println("게시글 작성 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeAll(pstmt, con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void postUpdate(BoardVO board) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement("update board " + 
					"set title=?, content=? " + 
					"where bno = ?");
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getBno());
			pstmt.executeUpdate();
			System.out.println("게시글 수정 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeAll(pstmt, con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deletePost(int bno) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("delete from board where bno = ?");
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
			System.out.println("게시글 삭제 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeAll(pstmt, con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void updateRawCount(int bno) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("update board " + 
					"set count=count+1 " + 
					"where bno=?");
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
			System.out.println("조회수 증가 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeAll(pstmt, con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
 