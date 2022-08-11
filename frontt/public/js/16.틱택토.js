게임판그리기()

function 게임판그리기(){
	let 게임판 =''
	for ( let i = 0 ; i < 9 ; i++){
		게임판 += `<button id=${i} onclick=위치선택(${i})>${i}</button>`
		if(i % 3 == 2){게임판 += '<br>' }
		
	}
	document.getElementById('gameboard').innerHTML = 게임판
}





 function 위치선택(i){
	alert(i + '버튼눌림')
	
	document.getElementById(i).innerHTML = 'O'
	
	let rand = Math.floor(Math.random())*9
	
	document.getElementById(rand).innerHTML = 'X'
}





//게임상태함수

 function 게임상황출력(){}





//게임결과함수
 function 게임결과(){}