
$(document).ready(function() {
  $('#summernote').summernote({
	placeholder:'내용입력',
 	maxHeight:null , 
 	minHeight:200
	});
});


function board(){
	//폼버젼
	let form = document.querySelector('form')
	console.log(form)
	let formdata = new FormData(form)
	console.log(formdata)
	$.ajax({
		url: "/jsp_web//board/boardwrite",
		data:formdata,
		contentType:false, // multipart/form-data로 바뀜
		processData:false, //
		type: 'POST',
		success : function (re){location.href="/jsp_web/board/boardlist.jsp"}
	})
	/*
	let btitle = document.querySelector('#btitle').value;
	let bcon = document.querySelector('#bcon').value;
	
	$.ajax({
		url : "/jsp_web//board/boardwrite" ,
		data : {"btitle":btitle , "bcon":bcon} ,
		success : function(re){
			if(re==='true'){
				alert('게시물 등록 성공')
				location.href="/jsp_web/board/boardlist.jsp"
			}
			else{
				alert('게시물 등록 실패')
			}
		}
	})*/		
}
let pageinfo = {
	listsize : 5 ,
	page : 1 ,
	key : '' ,
	keyword : ''
}

boardlist(1)

function blistsize(){
	pageinfo.listsize = document.querySelector('.listsize').value;
	boardlist(1)
}

function bsearch(){
	pageinfo.key=document.querySelector('.key').value
	pageinfo.keyword=document.querySelector('.keyword').value
	boardlist(1)
}

function boardlist(page){
	pageinfo.page = page;
	$.ajax({
		url : "/jsp_web/board/boardlist" , 
		data: pageinfo ,
		success : function(result){
			let boards = JSON.parse(result)
			let boardlist = boards.data
			let table = document.querySelector("#viewbox")
			let tag ='<tr>'+
					'<th>아이디</th>'+
					'<th>제목번호</th>'+
					'<th>제목(클릭)</th>'+
					'<th>날짜</th>'+
					'<th>조회수</th>'+
					'</tr>';
			
			for(let i=0; i<boardlist.length ; i++){
				let b = boardlist[i]	
				let to = new Date();   
				let date = to.getFullYear()+'-'+(to.getMonth()+1)+'-'+to.getDate();
				let today = '';
			    /*if(b.bdate!==null && b.bdate.substr(0,10)===date){
					today=b.bdate.substr(11,18);
				}
				else{
					today=b.bdate.substr(0,10);
				}*/
				
				tag +='<tr>'+
					'<td>'+b.mid+'</td>'+
					'<td>'+b.bnum+'</td>'+
					'<td onclick="viewupdate('+b.bnum+')">'+b.btitle+'</td>'+
					'<td>'+b.bdate+'</td>'+
					'<td>'+'&nbsp&nbsp'+b.bview+'</td>'+
					'</tr>';
			}
			table.innerHTML=tag
			//페이지 버튼
			let pagehtml='';
			if(page===1){pagehtml+='<button type="button" onclick="boardlist('+page+')">이전</button>'}
			else{pagehtml+='<button type="button" onclick="boardlist('+(page-1)+')">이전</button>'}
			
			if(page<=3){
				for(let i=1; i<=5; i++){
					pagehtml+='<button type="button" onclick="boardlist('+i+')">'+i+'</button>'
				}
			}
			else if(page===boards.totalpage||page===boards.totalpage-1){
				for(let i=(boards.totalpage-4); i<=boards.totalpage; i++){
					pagehtml+='<button type="button" onclick="boardlist('+i+')">'+i+'</button>'
				}
			}
			else if(2<page && page<boards.totalpage-1){
				for(let i=page-2; i<=page+2; i++){
					pagehtml+='<button type="button" onclick="boardlist('+i+')">'+i+'</button>'
				}
			}
			
			if(page===boards.totalpage){pagehtml+='<button type="button" onclick="boardlist('+page+')">다음</button>'}
			else{pagehtml+='<button type="button" onclick="boardlist('+(page+1)+')">다음</button>'}
			document.querySelector('.pagebox').innerHTML=pagehtml;
			document.querySelector('.totalpage').innerHTML=boards.totalsize;
		}
	})
}

function viewupdate(bnum){
	$.ajax({
		url :"/jsp_web/board/viewupdate", 
		data : {"bno" : bnum} ,
		success : function(result){
			location.href="/jsp_web/board/boarddetail.jsp"
		}
	})	
}





