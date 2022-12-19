package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.dao.BoardDao;
import model.dto.BoardDto;


@WebServlet("/board/view")
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public view() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//세션 요청	
	int bno =(Integer)request.getSession().getAttribute("bno"); //4

	//5
	//2 DAO 처리
	BoardDto dto =BoardDao.getInstance().getboard(bno);
	
	//3. DTO -->JSON 형변환
	JSONObject object = new JSONObject();
	object.put("bno",dto.getBno());
	object.put("btitle", dto.getBtitle());
	object.put("bcontent",dto.getBcontent());
	object.put("bfile", dto.getBfile());
	
		//* 삭제, 수정 버튼 활성화 위한 식별변수 선언 [작성자 판단]
	//1. 
//	 String bpassword = (String)request.getSession().getAttribute("bno");
//	if( bpassword != null & bpassword.equals(dto.getBno()))
//		object.put("btnaction", true);
//	 
	// 보내기
	response.setCharacterEncoding("UTF-8");
	response.getWriter().print(object);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
