/**
 * 
 
 1. 학생 객체 설계
 2. html에서 입력받은 데이터를 js객체에 저장
 	document.getElementById('name').value;
 3. 점수등록을 했을때 / 여러번(함수)	/ 객체를 배열로 저장
 4. html 초기화
 5. 학생점수출력 처음열렸을때 / 등록할때마다
 

 */
  let studentlist = []
  학생출력()
  
 function 학생등록(){
	const student = {
	name :document.getElementById('name').value , 
	kor : Number(document.getElementById('kor').value) , 
	eng : Number(document.getElementById('eng').value) ,
	mat : Number(document.getElementById('mat').value)
}	
	if(이름중복체크(student.name)){
		return
	}
	studentlist.push(student) //배열에 데이터 추가
	alert('점수 등록이 되었습니다.')
	
	document.getElementById('name').value = ''
	document.getElementById('kor').value = ''
	document.getElementById('eng').value = '' 
	document.getElementById('mat').value = ''
	학생출력()
}	
	
	
	
	
	
function 이름중복체크(name){
	for(let i = 0 ; i <studentlist.length ; i++){
		if(studentlist[i].name===name){
			alert('이미 존재한 학생명 입니다.')
			return true
		}
	}
	return false
}





function 학생출력(){
	let html = '<tr>'+
					'<th>등수</th>'+
					'<th>학생명</th>'+
					'<th>국어</th>'+
					'<th>영어</th>'+
					'<th>수학</th>'+
					'<th>총점</th>'+
					'<th>평균</th>'+
					'<th>비고</th>'+
				'</tr>'
	for(let i = 0 ; i < studentlist.length ; i++){
		let sum = studentlist[i].kor + studentlist[i].eng + studentlist[i].mat
		let avg = sum/3
		html += '<tr>'+
					'<th>'+(i+1)+'</th>'+
					'<th>'+studentlist[i].name+'</th>'+
					'<th>'+studentlist[i].kor+'</th>'+
					'<th>'+studentlist[i].eng+'</th>'+
					'<th>'+studentlist[i].mat+'</th>'+
					'<th>'+sum+'</th>'+
					'<th>'+avg+'</th>'+
					'<th><button onclick="학생삭제('+i+')">삭제</button></th>'+
				'</tr>'
	}
				
	document.getElementById('listtable').innerHTML = html
}


function 학생삭제(i){
	alert(studentlist[i].name + '의 점수를 삭제합니다.')
	studentlist.splice(i,1)
	학생출력()
}

 














	
