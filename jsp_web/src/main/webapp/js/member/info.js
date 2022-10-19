getmember()
// 회원정보 호출
function getmember(){
	$.ajax({
		url : "/jsp_web/member/info" ,
		success : function(result){
			let member = JSON.parse(result)
			document.querySelector("#mno").innerHTML = member.mno
			document.querySelector("#mid").innerHTML = member.mid
			document.querySelector("#mname").value = member.mname
			document.querySelector("#mpn").value = member.mpn
			document.querySelector("#memail").value = member.memail
			//document.querySelector("#maddr").value = member.maddr
			document.querySelector("#mdate").innerHTML = member.mdate.split(' ')[0]
			document.querySelector("#mpoint").innerHTML = member.mpoint
			document.querySelector("#sample4_postcode").value = member.maddr.split(',')[0]
			document.querySelector("#sample4_roadAddress").value = member.maddr.split(',')[1]
			document.querySelector("#sample4_jibunAddress").value = member.maddr.split(',')[2]
			document.querySelector("#sample4_detailAddress").value = member.maddr.split(',')[3]		
			//getmemberlist()
		}
	});
}

/* 모든 회원정보 호출
function getmemberlist(){
	$.ajax({
		url : "/jsp_web/member/infolist" ,
		success : function(result){
			let memberlist = JSON.parse(result)
			let table = document.querySelector("#memberlisttable")
			let tag = '<tr>'+
					'<th>번호</th>'+
					'<th>아이디</th>'+
					'<th>이름</th>'+
					'<th>연락처</th>'+
					'<th>이메일</th>'+
					'<th>주소</th>'+
					'<th>날짜</th>'+
					'<th>포인트</th>'+
					'</tr>';
			
			for(let i=0 ; i<memberlist.length ; i++){
				let m = memberlist[i]
				tag+='<tr>'+
					'<td>'+m.mno+'</td>'+
					'<td>'+m.mid+'</td>'+
					'<td>'+m.mname+'</td>'+
					'<td>'+m.mpn+'</td>'+
					'<td>'+m.memail+'</td>'+
					'<td>'+m.maddr+'</td>'+
					'<td>'+m.mdate+'</td>'+
					'<td>'+m.mpoint+'</td>'+
					'</tr>';
			}
			table.innerHTML = tag;
		}
	});
}
//회원탈퇴
function viewdelete(){
	let deletebox = document.querySelector("#deletebox")
	let tag = '<span>! 정말 탈퇴 하시겠습니까 ? </span>'+
			'<input type="password" id="mpassword">'+
			'<button onclick="mdelete()">확인</button>'
	deletebox.innerHTML = tag
}


function mdelete(){
	alert('mdelete구현')
	let mpassword = document.querySelector("#mpassword").value;
	alert(mpassword)
	$.ajax({
		url :"/jsp_web/member/delete", 
		data : {"mpassword" : mpassword} ,
		success : function(result){
			alert(result)
			if(result==='true'){
				alert('탈퇴 성공')
				location.href='/jsp_web/member/logout.jsp'
			}
			else{
				alert('동일하지않는 비밀번호입니다.')
			}
		}
	})
	
}*/


//회원수정
let btns = document.querySelectorAll('button')

function updateaction(){
	let mname = document.querySelector('#mname')

	if(btns[1].innerHTML==='확인'){
		$.ajax({
			url : "/jsp_web/member/memberupdate" ,
			data : {"mname" : mname.value} , 
			success : function(re){
				if(re==='true'){
					alert('수정 성공')
					
				}
				else{
					alert('수정 실패')
				}
			}
		})
		btns[1].innerHTML='수정';
		mname.readOnly = true;
		location.reload();//이동 location.href='';
	}
	else{
		btns[1].innerHTML='확인';
		mname.readOnly = false;
	}
}



















