
getlist()
function getlist(){
	$.ajax({
		url: "/jsp_web/admin/regist",
		type:"get",
		success:function(re){
			let json = JSON.parse(re)
			let html = '<tr>'+
					   '<th>카테고리</th><th>제품번호</th><th>제품이름</th><th>제품설명</th>'+
					   '<th>제품가격</th><th>상태</th>'+
					   '<th>제품이미지</th><th>등록날짜</th>'+
					   '</tr>';
			for(let i=0; i<json.length; i++){
				html+= '<tr>'+
						'<td>'+json[i].pcno+'</td>'+
						'<td>'+json[i].pno+'</td>'+
						'<td>'+json[i].pname+'</td>'+
						'<td>'+json[i].pcomment+'</td>'+
						'<td>'+(json[i].pprice*json[i].pdiscount)+'</td>'+
						'<td>'+json[i].pactive+'</td>'+
						'<td><img width="20%" src="/jsp_web/admin/pimg/'+json[i].pimg+'"></td>'+
						'<td>'+json[i].pdate+'</td>'+		
					   '</tr>'
			}
			document.querySelector('.table').innerHTML=html;
		}
	})
}