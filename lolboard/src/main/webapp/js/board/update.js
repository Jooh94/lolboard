bview()
function bview(){ 
	
	$.ajax({
		url:"/lolboard/board/view",
		success:function(re){
		let board = JSON.parse(re)
	
		
		document.querySelector('.btitle').value=board.btitle;
		document.querySelector('.bcontent').value=board.bcontent;
		
		console.log(board.btitle)
		
		if(board.bfile){ //null ,undefind ,0 , false
		let filelink = '<a href="../board/filedown?bfile='+board.bfile+'">'+board.bfile+'</a>'
		
		document.querySelector('.oldfile').innerHTML=filelink;			
		}


		}
	}) 
}



function bupdate1(){	
		let form = document.querySelector('form');
		let formdata = new FormData(form)
		$.ajax({
			url:"/lolboard/board/bupdate",
			data:formdata,
			type:"post",
			contentType:false,
			processData:false,
			success:function(re){
				if(re==='true'){alert('수정성공');
				location.href='view.jsp'}
				else{alert('수정실패')}
			}	
		})
	} 