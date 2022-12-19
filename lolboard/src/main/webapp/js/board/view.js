


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
		
		let deletebtn ='<button onclick="bdelete('+board.bno+')"> 삭제 </button><input type="text">'
		btnbox.innerHTML +=deletebtn;

		}
	}) 
}
//let bpassword =document.querySelector('.password')

function bdelete(bno){
	
	$.ajax({
		url:"/lolboard/board/bdelete",
		data:{"bno":bno },
		success:function(re){
			if(re==='true'){
		alert('글삭제 성공');
		location.href="../board/llist.jsp"
	}else{
		alert('비밀번호 재입력')
	}
	
	
	}
		
	})
}