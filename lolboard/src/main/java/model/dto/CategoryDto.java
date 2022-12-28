package model.dto;

public class CategoryDto {
	
	private int cno; //카테고리
	private String cname; // 카테고리 이름

	public CategoryDto() {}

	
	
	public CategoryDto(int cno, String cname) {
		super();
		this.cno = cno;
		this.cname = cname;
	}



	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "categoryDto [cno=" + cno + ", cname=" + cname + "]";
	}
	
	
}
