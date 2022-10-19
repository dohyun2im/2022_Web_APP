
alert('a')
function findid(){
	
	let mname = document.querySelector('#mname').value;
	let memail = document.querySelector('#memail').value;
	let findidconfirmbox = document.querySelector('#findidconfirmbox');
	
	$.ajax({
		url : "/jsp_web/member/findid" ,
		data : {"mname":mname , "memail":memail} ,
		success : function(re){
			if(re!=='null'){
				findidconfirmbox.innerHTML= '회원아이디 :'+re
			}
			else{
				findidconfirmbox.innerHTML= '정보가 없습니다.'
			}
		}
	})	
}  