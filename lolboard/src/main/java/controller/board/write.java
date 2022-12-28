package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Sockaddr;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dto.BoardDto;


@WebServlet("/board/write")
public class write extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public write() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String btitle= request.getParameter("btitle");
//		String bcontent= request.getParameter("bcontent");
//		
//		
//		System.out.println(btitle);
//		System.out.println(bcontent);
		
//		boolean result=
//		BoardDao.getInstance().write(btitle, bcontent);
//		response.getWriter().print(result);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String uploadpath ="C:\\Users\\504\\eclipse-workspace\\lolboard\\src\\main\\webapp\\upload";	
		
		//1. 배포된 프로젝트 경로찾기
		String uploadpath = request.getSession().getServletContext().getRealPath("/upload");
		
		
		MultipartRequest multi = new MultipartRequest(
			request , // 요청방식
			uploadpath , // 저장경로
			1024 * 1024 * 10, // 1MB
			 "UTF-8", //인코딩
			 new DefaultFileRenamePolicy() // 5. 업로드된 파일의 이름이 중복일경우 자동이름 변경
			 
			); //생성자 end
		String btitle = multi.getParameter("btitle"); // requset -> multi
		String bcontent= multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
		String bpassword = multi.getParameter("bpassword");
	       
        if(bpassword == null) { response.getWriter().print("pwfalse");  }
        
		//db 처리 다시
         boolean result=
         BoardDao.getInstance().write(btitle, bcontent, bfile, bpassword);

         response.getWriter().print(result);
		
	} 

}
