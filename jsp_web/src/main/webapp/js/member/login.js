/**
 * 
 */


function login(){
	
	let mid = document.querySelector('#mid').value;
	let mpw = document.querySelector('#mpw').value;
	let loginconfirmbox = document.querySelector('#loginconfirmbox');
	
	$.ajax({
		url : "/jsp_web/member/login" ,
		data : {"mid":mid , "mpw":mpw} ,
		success : function(re){
			console.log(re)
			if(re==='true'){
				alert('로그인 성공')
				location.href = '/jsp_web/index.jsp';
			}
			else{
				alert('로그인 실패')
				loginconfirmbox.innerHTML = '회원정보가 다릅니다.';
			}
		}
	})	
	
}
