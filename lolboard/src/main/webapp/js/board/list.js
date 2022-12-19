



list()
function list(){
	
	$.ajax({
		url:"/lolboard/board/list",
		success:function(re){
			let boardlist=JSON.parse(re)
			let html = ""		
			for( let i = 0 ; i<boardlist.length; i++){
	 			let board =  boardlist[i]
				html += '<tr>'+
						'<td>'+board.bno+'</td>'+
						'<td onclick="viewload('+board.bno+')">'+board.btitle+'</td>'+
						'<td>'+board.bdate+'</td>'+
						'<td>'+board.bview+'</td>'+
						'</tr>';
			}	
			document.querySelector('.btable').innerHTML = html
		}
		
		
	})

}   

function viewload(bno){
	$.ajax({
		url:"/lolboard/board/viewload",
		data:{"bno":bno},
		success: function(re){
			location.href="/lolboard/board/view.jsp";	
		}	
	})
}