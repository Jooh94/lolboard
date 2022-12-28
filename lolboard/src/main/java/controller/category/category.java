package controller.category;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.dao.categoryDao;
import model.dto.CategoryDto;

/**
 * Servlet implementation class category
 */
@WebServlet("/board/category")
public class category extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public category() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		//2. db처리
		ArrayList<CategoryDto> list = new categoryDao().getCategory();
		JSONArray array = new JSONArray();
		for(CategoryDto dto : list) {
			JSONObject object = new JSONObject();
			object.put("cno", dto.getCno()); 
			object.put("cname",dto.getCname());
			array.add(object);
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
