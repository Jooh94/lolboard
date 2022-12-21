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
	public ArrayList<BoardDto>getlist(int startrow, int listsize) {
		ArrayList<BoardDto> list = new ArrayList<>();
		String sql = "select * from lboard "
				+ " order by "
				+ " bdate desc limit "+startrow+","+listsize ;
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
	
	
	// 게시물 삭제
	public boolean delete (int bno ,String bpassword) {
//		System.out.println(" bno : " + bno );
//		System.out.println(" bpassword : " + bpassword );
		
	String sql = "delete from lboard  where bno = "+bno+" and bpassword = '"+bpassword+"'";
			
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
			int count = ps.executeUpdate();
			if( count >= 1 ) return true;	// delete sql 는 0개를 삭제해도 true 이다... 그래서 삭제 개수를 세야한다..
			else return false;
		} catch (Exception e) {System.out.println("삭제기능"+e);}
		return false;
		
	}
	
	// 게시물 수정 권한 비밀번호 검증 여부 확인
		// java -- dao[작성] --> db
		// 검증 요청 ?? 1.select  2.insert 3.update 4.delete 
		// 
	public boolean upword(int bno, String bpassword) {
//	System.out.println(" bno : " + bno );
//	System.out.println(" bpassword : " + bpassword );		
		String sql = "select * from lboard where bno = ? and bpassword = ?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, bno);
			ps.setString(2, bpassword);
			rs = ps.executeQuery();
			if( rs.next() ) {
				return true;
			}
		} catch (Exception e) {System.out.println("수정비밀번호"+e);}
		return false;
	}
	
	
	// 게시물 수정
	public boolean bupdate(int bno, String btitle,String bcontent,String bfile) {
		
//		System.out.println("1"+bno);
//		System.out.println("2"+btitle);
//		System.out.println("3"+bcontent);
//		System.out.println("4"+bfile);
		
		
	String sql = "update lboard set btitle =? ,"
			+ " bcontent=? , bfile =? "
			+ " where bno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, btitle);
			ps.setString(2, bcontent);
			ps.setString(3, bfile);
			ps.setInt(4, bno);
			ps.executeUpdate(); return true;
		} catch (Exception e) {System.out.println("수정하기"+e);}		
			return false;
	}
	
	
	//게시물 수
	public int gettotalsize() {
		String sql ="select count(*) from lboard";
		try {
			ps = con.prepareStatement(sql);
			rs= ps.executeQuery();
			if(rs.next()) return rs.getInt(1);
			
		} catch (Exception e) {System.out.println(e);} return 0;
		
	}
	
	
	
}
