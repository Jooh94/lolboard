//alert('js연결확인')

function lwrite(){

	let form = document.querySelector('form')
	console.log(form)
	let formdata= new FormData(form)
	console.log(formdata)
	$.ajax({		
		url:"/lolboard/board/write",
		data: formdata, // ajax 기본값으로 form 전송 불가능
				//첨부파일 전송시 : 아래코드 추가[무조건 post 로해야함]
		type:'post',
		contentType:false,
		processData: false,
		success: function(re){
			if(re=='true')
			{alert('글등록');
			location.href="llist.jsp"
			
			}
			else{alert('글등록실패')}
			
		}			
		
		
	})

}



/*

 let inputs = document.querySelectorAll('input')
 
 let data= {
	btitle : inputs[0].value,
	bcontent: inputs[1].value
}
	
	$.ajax({	
		url:"/lolboard/board/write",
		data: data,
		type:'post',
			success :function(re){
			if(re == 'true')
			{alert('글등록');
			 }
			else{alert('글등록실패') } }
	})
	*/