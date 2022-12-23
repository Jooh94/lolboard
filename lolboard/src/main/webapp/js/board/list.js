let pageinfo= {
	listsize :4, //게시물 표시 개수
	page : 1,	//현재 페이지 번호
	key:'',		//검색 키
	keyword:''	//검색 키워드
	
}
//검색 처리

function bsearch(){
	let key = document.querySelector('.key').value
	let keyword = document.querySelector('.keyword').value
	
	pageinfo.key = key
	pageinfo.keyword = keyword
	list(1)
}





list(1)
function list(page){
	
	//let listsize = 3; //한페이지당 게시물 표시하는수 예를들어 3개표시할래하면 3개나옴
	
	pageinfo.page = page; //객체 담아서 보내기 변경
	
	$.ajax({
		url:"/lolboard/board/list",
		data:pageinfo,
		success:function(re){
			
			let boards =JSON.parse(re)
			console.log(boards)
			
			//1. Object내 게시물리스트 먼저 호출
			let boardlist=boards.data
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
			
			//페이징 처리
			let pagehtml ='';
			
				//2이전버튼
				if(page== 1)pagehtml += '<button onclick="list('+(page)+')">이전</button>';    
				else{pagehtml += '<button onclick="list('+(page-1)+')">이전</button>';}				
				//4. 페이지번호 버튼
				for(let page = boards.startbtn; page<= boards.endbtn; page++){
					pagehtml += '<button type="button" onclick="list('+page+')">'+page+'</button>'
				}
				
				//3. 다음버튼
				if(page == boards.totalpage){pagehtml +='<button onclick=list('+(page)+')>다음</button>';}
				else{pagehtml +='<button onclick=list('+(page+1)+')>다음</button>'; }
				
			document.querySelector('.pagebox').innerHTML=pagehtml
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