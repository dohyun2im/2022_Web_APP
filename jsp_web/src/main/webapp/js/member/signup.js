/*아이디 
	/^ : 정규표현식 시작.
	$/ : 정규표현식 끝.
	[a-z] : 소문자 패턴.
	[A-Z] : 대문자 패턴.
	[0-9] : 숫자 패턴. /d
	{최소길이 , 최대길이}  : 문자열길이패턴
	검사 : 정규표현식.test(데이터) : 맞으면 t/f
	/^[a-z]{5,20}$/ : 소문자 5~20길이
	/^[a-zA-z가-힣]{2,5} $/
	+ 앞에있는 패턴 1개 반복
	? 앞에있는 패턴 0개 이상 반복
	* 앞에있는 패턴 0개 반복
	(?=.*[a-z]) 1개 이상의 소문자영문
	(?=.*[!@#$%^&*()_]) 1개이상의 특수문자
	/^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-]+$/ 1개이상패턴@1개이상패턴.1개이상패턴
	
*/
let sicon = '<i class="fa-solid fa-user-check"></i>';
let bicon = '<i class="fa-solid fa-ban"></i>';
let col3 = document.querySelectorAll(".col3") //all은 배열로 가져옴
let checklist = [false,false,false,false,false,false] 
function mevent1(){
	let mid = document.querySelector("#mid").value
	let midj = /^[a-z0-9]{5,20}$/
	if(midj.test(mid)){
		$.ajax({
			url : "/jsp_web/member/idcheck",
			data : {"mid" : mid} ,
			success : function (result){
				if(result==='true'){
					col3[0].innerHTML="사용중인 아이디입니다."+bicon
				}
				else{col3[0].innerHTML=sicon;}
			}
		})
	}
	else{
		col3[0].innerHTML="소문자와 숫자로 5~20글자만 가능합니다."+bicon
	}
}
/*비밀번호 */
function mevent2(){
	let mpw = document.querySelector("#mpw").value
	let mpwj = /^[a-zA-z0-9]{8,20}$/
	if(mpwj.test(mpw)){
		col3[1].innerHTML=sicon ; mevent3()
	}
	else{
		col3[1].innerHTML="대소문자와 숫자로 8~20글자만 가능합니다."+bicon
	}
}
/*비밀번호 확인*/
function mevent3(){
	let mpw = document.querySelector("#mpw").value
	let mconpw = document.querySelector("#mconpw").value
	let mpwj = /^[a-zA-z0-9]{8,20}$/ 
	if(!mpwj.test(mconpw)){col3[1].innerHTML="사용 불가능한 비밀번호입니다."+bicon}
	else if(mpw!=mconpw){col3[1].innerHTML="비밀번호가 서로 다릅니다."+bicon}
	else{col3[1].innerHTML=sicon; mevent2()}
}
/*이름 */
function mevent4(){
	let mname = document.querySelector("#mname").value
	let mnamej = /^[a-zA-z가-힣]{2,20}$/
	if(mnamej.test(mname)){col3[2].innerHTML=sicon}
	else{col3[2].innerHTML="영대소문자 혹은 한글작성 ! "+bicon}
}
/*전화번호 */
function mevent5(){
	let mpn = document.querySelector("#mpn").value
	let mpnj = /^([0-9]{2,3})-([0-9]{3,4})-([0-9]{3,4})$/
	if(mpnj.test(mpn)){col3[3].innerHTML=sicon}
	else{col3[3].innerHTML="xxx-xxxx-xxxx형식을 맞추세요 "+bicon}
}
/*이메일 */
function mevent6(){
	let memail = document.querySelector("#memail").value
	let memailj = /^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-]+$/
	if(memailj.test(memail)){
		$.ajax({
			url : "/jsp_web/member/emailcheck" ,
			data : {"memail" : memail} ,
			success : function(re){
				if(re==='true'){
					col3[4].innerHTML="사용중인 이메일입니다."+bicon
				}
				else{
					col3[4].innerHTML=sicon
				}
			}
		})
		col3[4].innerHTML=sicon}
	else{col3[4].innerHTML="xxx@xxxx.com형식을 맞추세요 "+bicon}
} 
/*주소 */
let postcode = document.querySelector("#sample4_postcode")
let road = document.querySelector("#sample4_roadAddress")
let jibun = document.querySelector("#sample4_jibunAddress")
let detail = document.querySelector("#sample4_detailAddress")

function addresscheck(e){
	let a = e.currentTarget.value;
	if(a.indexOf(",") != -1){ //해당문자열에 ,이 있으면
		col3[5].innerHTML="주소에 [,]입력 불가능"+bicon
	}
	else{col3[5].innerHTML=sicon}
}
postcode.addEventListener('change',addresscheck)
road.addEventListener('change',addresscheck)
jibun.addEventListener('change',addresscheck)
detail.addEventListener('change',addresscheck)

//전송 
function formsubmit(){
	for(let i=0; i<=5; i++){
		if(col3[i].innerHTML!==sicon){
			alert('입력이 안된 정보가 있습니다.')
			return false;
		}
	}
	if(!document.querySelector('#chk1').checked){
		alert('체크가 안된 이용약관이 있습니다.')
		return false;
	}
	if(!document.querySelector('#chk2').checked){
		alert('체크가 안된 개인정보수집동의가 있습니다.')
		return false;
	}
	document.querySelector('.signupform').submit();
}

//
  function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }