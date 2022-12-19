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
			<h3> 글쓰기 </h3>	
				<form>
					제목 : <input type="text" name="btitle" >  <br>
					내용 : <input type="text" name="bcontent" ><br>
					첨부파일 : <input type="file" name="bfile"> <br>
					비밀번호 : <input type="text" name="bpassword"> <br>
					<button type="button" onclick="lwrite()">쓰기</button>
				</form>
		</div>
		
		
		<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="../js/board/lwrite.js"></script>
</body>
</html>