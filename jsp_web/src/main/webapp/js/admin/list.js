
getlist()
function getlist(){
	$.ajax({
		url: "/jsp_web/admin/regist",
		type:"get",
		data : {"type":1 , "option":"all"},
		success:function(re){
			let json = JSON.parse(re)
			let html = '<tr>'+
					   '<th width="10%">카테고리</th><th width="10%">제품번호</th><th width="10%">제품이름</th>'+
					   '<th width="10%">제품설명</th><th width="10%">제품가격</th><th width="10%">상태</th>'+
					   '<th width="10%">제품이미지</th><th width="10%">등록날짜</th><th width="10%">비고</th>'+
					   '</tr>';
					   
			json.forEach(j=>{
				if(j.pactive==0){
					j.pactive="준비중"
				}
				else if(j.pactive==1){
					j.pactive="판매중"
				}
				else if(j.pactive==2){
					j.pactive="판매완료"
				}
				html+= '<tr>'+
						`<td>${j.pcno}</td>`+
						`<td>${j.pno}</td>`+
						`<td>${j.pname}</td>`+
						`<td>${j.pcomment}</td>`+
						`<td>${j.pprice*(1-j.pdiscount)}</td>`+
						`<td>${j.pactive}</td>`+
						`<td><img width="100%" src="/jsp_web/admin/pimg/${j.pimg}"></td>`+
						`<td>${j.pdate}</td>`+	
						`<td><button onclick='deleteproduct(${j.pno})' type='button'>삭제</button><button onclick='updatemodal(${j.pno})' type='button'>수정</button></td>`+	
					   `</tr>`;
			})
			document.querySelector('.table').innerHTML=html;
		}
	})
} 

function deleteproduct(pno){
	if(confirm('삭제하시겠습니까?')){
		$.ajax({
			url:"/jsp_web/admin/regist",
			data:{"pno" : pno},
			type:"delete",
			success:function(re){
				if(re=='true'){
					alert('성공'); 
					pagechange('list.jsp')
				}
			}
		})
	}
}

function updatemodal(pno){
	document.querySelector('.updatemodal').click();
	$.ajax({
		url : "/jsp_web/admin/regist",
		data : {"type":2 , "pno" : pno},
		type : "get" ,
		success : function(re){
			let json = JSON.parse(re);
			document.querySelector('.pno').value=json.pno;
			document.querySelector('.pname').value=json.pname;
			document.querySelector('.pcomment').value=json.pcomment;
			document.querySelector('.pprice').value=json.pprice;
			document.querySelector('.pdiscount').value=json.pdiscount;
			document.querySelector('.pimg').value=json.pimg;
		}		 
	})
}

function updateproduct(){
	let formdata = new FormData(document.querySelector('form'))
	$.ajax({
		url: "/jsp_web/admin/regist",
		type : "put",
		processData: false,
		contentType: false,
		data : formdata ,
		success:function(re){
			alert(re)
			document.querySelector('.pupdate').click();
			pagechange('list.jsp')
		}
	})
}

categorylist()
function categorylist(){
	$.ajax({
		url:"/jsp_web/board/pcategory",
		type:"get",
		success:function(re){
			let category = JSON.parse(re)
			let html = '';
			for(let i=0; i<category.length; i++){
				html+='<input type="radio" name="pcno" value='+category[i].pcno+'>'+category[i].pcname
			}
			html+='<br>';
			document.querySelector('.pcategorybox').innerHTML=html;
		}
	})
}






 




