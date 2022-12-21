


bview()
function bview(){ 
	
	$.ajax({
		
		url:"/lolboard/board/view",
		success:function(re){
		let board = JSON.parse(re)
		console.log(board)
		
		document.querySelector('.bno').innerHTML=board.bno;
		document.querySelector('.btitle').innerHTML=board.btitle;
		document.querySelector('.bcontent').innerHTML=board.bcontent;
		
		console.log(board.bfile)
		
		if(board.bfile){ //null ,undefind ,0 , false
		let filelink = '<a href="../board/filedown?bfile='+board.bfile+'">'+board.bfile+'</a>'
		
		document.querySelector('.bfile').innerHTML=filelink;			
		}
		let btnbox =document.querySelector('.btnbox')
		
		let deletebtn ='<input type="text" class="bpassword"> <button type="button" onclick="bdelete('+board.bno+')"> 삭제 </button>'
		btnbox.innerHTML +=deletebtn;
		let updatebtn = '<button type="button" onclick="bupdate('+board.bno+')">수정</button>'
		btnbox.innerHTML += updatebtn;

		}
	}) 
}

function bupdate(bno){
	// 만약에 게시물 비밀번호와 입력받은 비밀번호가 같으면 페이지 전환 
	let bpassword =document.querySelector('.bpassword').value
	$.ajax({
		url:"/lolboard/board/updatepassword",
		data:{"bno":bno,"bpassword":bpassword},
		type:"post",
		success:function(re){
			if(re == 'true'){alert('성공')
			location.href="../board/update.jsp"}
		else{alert('비밀번호 재입력 수정')}
		}
	})
	// 아니면 페이지 전환을 안한다.
}


function bdelete(bno){
	let bpassword =document.querySelector('.bpassword').value
	$.ajax({
		url:"/lolboard/board/bdelete",
		data:{"bno":bno , "bpassword" : bpassword },
		success:function(re){
			if(re == 'true'){alert('글삭제 성공');
				location.href="../board/llist.jsp"} 
			else{alert('비밀번호 재입력 삭제')}
	}
		
	})
}

