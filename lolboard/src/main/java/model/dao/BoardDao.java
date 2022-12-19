package model.dao;

import java.util.ArrayList;

import model.dto.BoardDto;

public class BoardDao extends Dao{

	private static BoardDao bdao = new BoardDao();
	public static BoardDao getInstance() {return bdao; }
	
	
	
	//1.글쓰기
	public boolean write(String btitle, String bcontent , String bfile , String bpassword) {
		String sql =" insert into lboard(btitle,bcontent,bfile,bpassword)"
				+ " values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, btitle);
			ps.setString(2, bcontent);
			ps.setString(3, bfile);
			ps.setString(4, bpassword);
			ps.executeUpdate();return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	//2. 글출력
	public ArrayList<BoardDto>getlist() {
		ArrayList<BoardDto> list = new ArrayList<>();
		String sql = "select * from lboard";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardDto dto = new BoardDto(
					rs.getInt(1),rs.getString(2),	
					rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getInt(6),
					rs.getString(7)
						);
				list.add(dto);
			}
			return list;
		} catch (Exception e) {System.out.println(e);} return list;
		
	}
	
	//3. 상세페이지
	public BoardDto getboard(int bno) {
		String sql ="select * from lboard"
				+ " where bno ="+bno;
		try {
			ps =con.prepareStatement(sql);
			rs= ps.executeQuery();
			if( rs.next()) {
				BoardDto dto = new BoardDto(
					rs.getInt(1), rs.getString(2),
					rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getInt(6),
					rs.getString(7)
						);
					return dto;		
			}	
		} catch (Exception e) {System.out.println(e);}
		return null;		
	}
	
	
	//글삭제
	public boolean delete (int bno ,String bpassword) {
	String sql ="delete from lboard "
			+ " where bno = and bpassword ="+bno+"+"+bpassword;
			
//			"delete from lboard "
//			+ " where  bno="+bno+"and where bpassword"+bpassword;
//			
//			 "delete from lboard"
//				+ " where bno = and bpassword ="+bno+"+"+bpassword;
				
				
		//"delete from lboard"
//				+ " where bno and where bpassword ="+bno+","+bpassword;
//			sql="delete from lboard "
//					+ " where bpassword="+bpassword;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate(); return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
		
		
		
				
	}
	
	
}
