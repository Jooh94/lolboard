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
			<h3> 글 수정하기 </h3>	
				<form>
					제목 : <input type="text" name="btitle" class="btitle">  <br>
					내용 : <input type="text" name="bcontent" class="bcontent" ><br>
					새로운 첨부파일 : <input type="file" name="newfile" class="newfile"> <br>
					<div class="oldfile"></div>
					<button type="button" onclick="bupdate1()" >수정하기 </button>
				</form>
		</div>
		
		
		<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="../js/board/update.js"></script>
</body>
</html>