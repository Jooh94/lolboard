package controller.board;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dto.BoardDto;

/**
 * Servlet implementation class bupdate
 */
@WebServlet("/board/bupdate")
public class bupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1. 서버 업로드 파일 경로 찾기
		String uploadpath = request.getSession()
				.getServletContext().getRealPath("/upload");
		//2. 멀티파트 MultipartRequest 객체 만들기
		MultipartRequest multi = new MultipartRequest(
				request, 
				uploadpath,
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy()); 
		//3. 요청
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
			
			//1. 수정시 새로운 첨부파일 등록시 [기존]
		//수정할 게시물의 번호 갖고 있어야한다.
		int bno =(Integer) request.getSession().getAttribute("bno");
		// 수정전 게시물 정보
		BoardDto dto = BoardDao.getInstance().getboard(bno); //수정 되기전 게시물 정보 호출
		
		//* 기존첨부파일 변경 여부 판단
		boolean bfilechange = false;
		if(bfile == null) {bfile =dto.getBfile(); bfilechange = true; }//2. 수정시 첨부파일 등록 없을경우	

		//4. Dao 처리 [ 업데이트 = 새로운 첨부파일 ] 
		boolean result = BoardDao.getInstance().bupdate(bno,btitle,bcontent,bfile);
		if(result) { // 업데이트 성공시 기존파일 삭제
			if( !bfilechange ) {
				String deletepath = request.getSession().getServletContext().getRealPath("/upload/"+dto.getBfile());
				File file = new File(deletepath); if(file.exists()) file.delete();			
			}		
		}
		//반환
		response.getWriter().print(result);
		
		
	}

}
