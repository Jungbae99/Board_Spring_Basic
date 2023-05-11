package com.mvc.board;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import java.util.*;

public class BoardDAO {
	
	// DAO : Data Access Object 
	// 데이터베이스의 데이터에 접근하여 CRUD를 처리하는 객체
	
	private Connection conn;
	//Db에 연결성을 가지는 객체
	private PreparedStatement pstmt;
	// Db에 접근해 CRUD처리
	private ResultSet rs;
	// 조회결과 데이터를 처리함 
	//conn & pstmt & rs 는 모두 java.sql 패키지에있다
	
	
	private DataSource ds; 
	// connection pool을 관리하는 객체이다 import javax.sql.*;에 있다
	
	private BoardDAO() {
		try {
			Context context = new InitialContext();
			// JNDI서비스를 제공하는 객체
			
			ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	private static BoardDAO instance = new BoardDAO();
	
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	
	
	private void close(Connection conn) {
		try {
			if(conn!=null) {
				conn.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	private void close(PreparedStatement pstmt) {
		try {
			if(pstmt!=null) {
				pstmt.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	private void close(ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 게시판 목록을 보여주기 위해 데이터를 얻는 메소드 
	public List<BoardDTO> boardList(){
		List<BoardDTO> list = new ArrayList<>();
		// id를 내림차순으로 정렬하여 Board테이블 모든 데이터를 보여주는 query
		String query = "SELECT * FROM BOARD ORDER BY ID DESC";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				//next메소드 : 다음레코드가없다면 false반환
			
				Integer id = rs.getInt("ID");
				String writer = rs.getString("WRITER");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				Timestamp regDate = rs.getTimestamp("REG_DATE");
				Integer viewCount = rs.getInt("VIEW_COUNT");
				
				list.add(new BoardDTO(id, writer, title, content, regDate, viewCount));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		return list;
	}
	// 글을 작성후 데이터를 받아서 DB에 데이터를 넣어주는 메소드
	public int boardInsert(BoardDTO dto) {
		int result = 0;
		String query = " INSERT INTO BOARD(ID, WRITER, TITLE, CONTENT) "
				+ "VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt  = conn.prepareStatement(query);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			//테이블의 내용이 변경되는경우 사용되는 메서드 Update
			result = pstmt.executeUpdate();
			//변경된 레코드의 수를 반환한다 -> 아마 1을 반환할 것이다.
		}catch(Exception e) {
			
		}finally{
			close(pstmt);
			close(conn);
			
		}
		return result;
		
	}
	// 목록에서 제목을 클릭시, 해당하는 내용을 보여주기위해 데이터를 얻는 메소드
	public BoardDTO getContent(int id) {
		
		upHit(id);
		
		BoardDTO dto = null;
		
		String query = "SELECT * FROM BOARD WHERE ID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt("ID");
				String writer = rs.getString("WRITER");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				Timestamp regDate = rs.getTimestamp("REG_DATE");
				Integer viewCount = rs.getInt("VIEW_COUNT");
				
				dto = new BoardDTO(id, writer, title, content, regDate, viewCount);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		return dto;
	}
	
	
	// 조회수를 하나 증가시켜주는 메소드
	private void upHit(int id) {
		String query = "UPDATE BOARD SET VIEW_COUNT = VIEW_COUNT + 1 WHERE ID = ?";
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
		}catch(Exception e ) {
			e.printStackTrace();
			
		}finally {
			close(pstmt);
			close(conn);	
		}
	}
	
	//수정 폼을 만들기 위해 데이터를 얻는 메서드
	public BoardDTO modifyForm(int id) {
				
		BoardDTO dto = null;
		
		String query = "SELECT * FROM BOARD WHERE ID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt("ID");
				String writer = rs.getString("WRITER");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				Timestamp regDate = rs.getTimestamp("REG_DATE");
				Integer viewCount = rs.getInt("VIEW_COUNT");
				
				dto = new BoardDTO(id, writer, title, content, regDate, viewCount);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		return dto;
	}
	
	
	// 해당하는 글을 수정해주는 메소드
	public int boardModify(BoardDTO dto) {
		int result = 0;
		
		//작성자, 제목, 내용 수정
		String query = "UPDATE BOARD SET WRITER = ?, TITLE = ?, CONTENT = ? WHERE ID = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setInt(4, dto.getId());
			
			result  = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);	
		}
		
		return result;
	}
	
		// 해당하는 글을 삭제해주는 메소드
	public int boardDelete(int id) {
		int result = 0;
		
		String query = "DELETE FROM BOARD WHERE ID =?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			
			result = pstmt.executeUpdate();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
			
		}
		
		return result;
	}
	
}