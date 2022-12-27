package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.dao.BoardDao;
import model.dto.BoardDto;


@WebServlet("/board/list")
public class list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public list() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		/// 검색처리
		String key = request.getParameter("key");
		String keyword = request.getParameter("keyword");
//		System.out.println(key);
//		System.out.println(keyword);
		
		
		
		//1.페이지당 게시물수
		int listsize =Integer.parseInt( request.getParameter("listsize"));
		//System.out.println(listsize); = 3나왔씀 왜냐 3으로 지정했으니깐
		//2.전체 게시물수
		int totalsize = BoardDao.getInstance().gettotalsize(key,keyword);
		//3. 전체 페이지수 계산
		int totalpage =0;
		if(totalsize % listsize ==0) totalpage = totalsize /listsize;
		else totalpage = totalsize / listsize +1;
		
		//3. 현재 페이지 번호
		int page = Integer.parseInt(request.getParameter("page"));
		// 3.페이지별 시작 게시물 행번호
		int startrow = (page-1)*listsize;
	
		//3. 화면에 표시할 최대 버튼수
		int btnsize = 5; //버튼 5개씩 표시
		int startbtn = ((page-1)/btnsize)* btnsize +1;
		int endbtn = startbtn+(btnsize-1);
			// 만약에 endbtn 마지막 페이지보다 크면 마지막버튼 번호는 마지막페이지 번호
			if(endbtn>totalpage) endbtn =totalpage;
		
		//페이징처리 정보 담는 jsonobject
		JSONObject boards = new JSONObject();
		
	//2. db
		ArrayList<BoardDto> list = BoardDao.getInstance().getlist(startrow ,listsize,key,keyword);
		JSONArray array = new JSONArray();
		for( int i=0; i<list.size(); i++) {
			JSONObject object = new JSONObject();
			object.put("bno", list.get(i).getBno());
			object.put("btitle", list.get(i).getBtitle());
			object.put("bcontent", list.get(i).getBcontent());
		 	object.put("bfile", list.get(i).getBfile());
			object.put("bdate", list.get(i).getBdate());
			object.put("bview", list.get(i).getBview());
			array.add(object);
		}	
		
		//4. 
		boards.put("totalpage", totalpage); //전체 페이지수
		boards.put("data", array); //게시물리스트
		boards.put("startbtn",startbtn); //버튼 시작번호
		boards.put("endbtn", endbtn);   //버튼 끝번호
		boards.put("totalsize", totalsize); //게시물 수
		
	response.setCharacterEncoding("UTF-8");
	response.getWriter().print(boards);
	}  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
