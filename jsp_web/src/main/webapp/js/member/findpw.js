/**
 * 
 */
alert('a')
function findpw(){
	
	let mid = document.querySelector('#mid').value;
	let memail = document.querySelector('#memail').value;
	let findpwconfirmbox = document.querySelector('#findpwconfirmbox');
	
	$.ajax({
		url : "/jsp_web/member/findpw" ,
		data : {"mid":mid , "memail":memail} ,
		success : function(re){
			if(re!=='null'){
				findpwconfirmbox.innerHTML = mid+'님의 비밀번호는 :'+re;
			}
			else{
				findpwconfirmbox.innerHTML = '회원정보가 다릅니다.';
			}
		}
	})	
	
}