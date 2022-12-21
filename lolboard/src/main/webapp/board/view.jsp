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
			<h3> 글 조회 </h3>
			<form>
			<table>
				<tr> <td>번호</td> <td class="bno"> 		</td></tr>
				<tr> <td>제목</td> <td class="btitle"> 	</td></tr>
				<tr> <td>내용</td> <td class="bcontent"> </td></tr>
				<tr> <td>첨부파일</td> <td class="bfile"> </td></tr>
			</table>

			<div class="btnbox">
			<a href="llist.jsp">글목록</a>
			<a href="lwrite.jsp">글쓰기</a>
			</div>
			</form>
			
			
		</div>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="../js/board/view.js" type="text/javascript"></script>
</body>
</html>