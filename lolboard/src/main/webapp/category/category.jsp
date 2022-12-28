<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



				<div class="webbox">
			
			<h3>글목록 </h3>
		 	카테고리:<button type="button" onclick="category()">카테고리추가</button>
			<div>게시물수 : <span class="totalsize"></span> </div>
			<div>
				<select class="listsize" onchange="blistsize()">
					<option value="5">5</option>
					<option value="10">10</option>
					<option value="15">15</option>
					<option value="20">20</option>
				</select>
			</div>
			<table class="btable">
					
			</table>
			<div class="pagebox"> </div> <!-- 페이징 -->
			<div> <!-- 검색 -->
				<select class="key">
					<option value="btitle">제목</option>
					<option value="bcontent" >내용</option>
				</select>
				<input class="keyword" type="text" placeholder="검색어">
				<button type="button" onclick="bsearch()">검색</button>
			</div>
			<a href="lwrite.jsp">글쓰기</a>
			</div>

</body>
</html>