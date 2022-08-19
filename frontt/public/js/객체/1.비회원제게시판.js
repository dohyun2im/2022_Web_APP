/**
 *
 인풋태그 데이터 호출
  객체에 담기
  글등록 버튼 누를때마다 실행
  여러개 게시물 객체 저장공간 boardlist = 배열
  글 등록 될때마다 보드객체를 배열에 저장한다
  기존 내용을 지워준다
  새로운 글이 올라올때마다 출력
  제목클릭할때마다 게시물 출력 
  	인수를 전달 내가 클릭한 게시물이 무엇인지 ? 클릭한 게시물의 번호-인덱스
 
  	
 */


 
 let boardlist = []
 
 게시물출력()

 function 글등록(){
	 let bwriter =document.getElementById('bwriter').value
	 let bpw =document.getElementById('bpw').value
	 let btt =document.getElementById('btt').value
	 let bcon =document.getElementById('bcon').value
	  
	 let board = {
	작성자 : bwriter ,
	비밀번호 : bpw  ,
	제목 : btt ,
	내용 : bcon
	}
	boardlist.push(board)
	alert('글 등록 완료 ㅎ')
	document.getElementById('bwriter').value = ''
	document.getElementById('bpw').value = ''
	document.getElementById('btt').value = ''
	document.getElementById('bcon').value = ''
	console.log(boardlist)
	게시물출력()

}




function 게시물출력(){
	
	let html = '<tr> <th>번호</th> <th>제목</th> <th>작성자</th> </tr>'
	
	for (let i = 0 ; i<boardlist.length ; i++ ){
	html += '<tr> <th>'+i+
			'</th> <th><a href="#" onclick="게시물보기('+i+')">'+boardlist[i].제목+
			'</a></th> <th>'+boardlist[i].작성자+'</th> </tr>'
	}
	
	document.getElementById('boardlist').innerHTML = html
}

function 게시물보기(i){
	document.getElementById('viewtitle').innerHTML = boardlist[i].제목
	document.getElementById('viewwriter').innerHTML = boardlist[i].작성자
	document.getElementById('viewcontent').innerHTML = boardlist[i].내용
}



 function deleteDiv() {
  const div = document.getElementById('delete');
  
  div.remove();
} 


















 