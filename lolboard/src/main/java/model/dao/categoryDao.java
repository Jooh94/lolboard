package model.dao;

import java.util.ArrayList;

import model.dto.CategoryDto;

public class categoryDao extends Dao{
	

	//카테고리 출력 
	
	public ArrayList<CategoryDto> getCategory(){
		ArrayList<CategoryDto> list = new ArrayList<>();
		String sql = "select * from category";
		try {
			ps= con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				CategoryDto dto
				= new CategoryDto(rs.getInt(1),
						rs.getString(2));
						list.add(dto);
			}
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
	

	
}
