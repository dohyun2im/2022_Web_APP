



bdetail()
function bdetail(){
	$.ajax({
		url :"/jsp_web/board/view", 
		success : function(result){
			let b = JSON.parse(result)
			let table = document.querySelector("#detailbox")
			let filelink = '<a href="../board/filedown?bfile='+b.bfile+'">'+b.bfile+'</a>';
			let tag = '';
			if(b.mid!=null){tag+='<tr>'+'회원 : '+b.mid+'</tr><br>'}
			if(b.bnum!=null){tag+='<tr>'+'등록번호 : '+b.bnum+'</tr><br>'}
			if(b.btitle!=null){tag+='<tr>'+'제목 : '+b.btitle+'</tr><br>'}
			if(b.bcon!=null){tag+='<tr>'+'내용 : '+b.bcon+'</tr><br>'}
			if(b.bfile!=null){tag+='<tr>'+'파일 : '+filelink+'</tr><br>'}
			if(b.btnaction!=null){
				tag+='<tr><button onclick="bdelete('+b.bnum+')">삭제</button></tr><br>'
				tag+='<tr><button onclick="bupdate('+b.bnum+')">수정</button></tr><br>'
			}
			console.log(b.btnaction)
			table.innerHTML=tag
		}
	})	
}

function bdelete(bnum){
	let bdnum = bnum
	$.ajax({
		url :"/jsp_web/board/boarddelete", 
		data : {"bdnum" : bdnum} ,
		success : function(result){
			if(result==='true'){
				alert('삭제 성공')
				location.href="/jsp_web/board/boardlist.jsp";
			}
			else{
				alert('삭제 실패.')
			}
		}
	})	
}

function bupdate(bnum){
	$.ajax({
		url :"/jsp_web/board/boardupdate", 
		data : {"bnum" : bnum} ,
		success : function(result){
			location.href="/jsp_web/board/boardupdate.jsp";
		}
	})
}

//댓글
function comments(){
	let com = document.querySelector('#com').value
	$.ajax({
		url: "/jsp_web/com/comwrite",
		data : {"com":com, "type" : "comment"} ,
		success : function(result){
			if(result==='true'){location.reload()}
		}
	})	
}

comlist();
function comlist(){
	$.ajax({
		url: "/jsp_web/com/comlist",
		data: {"type" : "reply"},
		async:false,
		success : function(result){
			let commentlist = JSON.parse(result);
			let table = document.querySelector("#commentbox")
			let tag = '';
			for(let i=0; i<commentlist.length ; i++){
				let c = commentlist[i]
				
				tag+='<tr>'+
					'<td>'+c.mid+'</td>'+
					'<td>'+c.cnum+'</td>'+
					'<td>'+c.com+'</td>'+
					'<td>'+c.cdate+'</td>'+
					'<td><button onclick="cocomentbox('+c.cnum+')" type="button">답글</button></td>'+
					'<td class="com'+c.cnum+'"></td>'+
					'</tr>';
				
				$.ajax({
					url: "/jsp_web/com/comlist",
					data: {"type" : "rereply" , "cindex":c.cnum},
					async:false,
					success : function(result){
						let commentlist = JSON.parse(result);
						for(let i=0; i<commentlist.length ; i++){
						let c = commentlist[i]
						if(c.cnum>0){
							tag+='<tr>'+
								'<td>└──답글 : '+c.mid+'</td>'+
								'<td>'+c.cnum+'</td>'+
								'<td>'+c.com+'</td>'+
								'<td>'+c.cdate+'</td>'+
								'</tr>';
							}
						}
					}
				})
					
			table.innerHTML=tag;
			}
		}
	})
}
//대댓글
function cocomentbox(cnum){
	document.querySelector('.com'+cnum).innerHTML='<input class="reply'+cnum+'" type="text"><button onclick="ccwrite('+cnum+')">전송</button>';
}
function ccwrite(cnum){
	let com = document.querySelector('.reply'+cnum).value;
	console.log(com+1)
	$.ajax({
		url: "/jsp_web/com/comwrite",
		data : {"com":com , "cnum": cnum , "type" : "cocomment"} ,
		success : function(result){
			if(result==='true'){location.reload()}
		}
	})
}






