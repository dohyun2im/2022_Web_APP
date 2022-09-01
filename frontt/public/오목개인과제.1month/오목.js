



let 게임상황 = [] //현재 알을 둔 상황을 저장 배열
let 승리 = '' // 이긴 알의 변수
let count=1

function 게임판그리기(){
	승리 = ''
	게임상황=[null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null] //알을 81개 그린다.


	let 게임판 =''
	for(let b =0 ; b<=800 ; b+=100){ //Y좌표값을 준다.
		for ( let i = 1 ; i <= 9 ; i++){ //X좌표값을 준다.
			let a = b+i
			게임판 += `<button id=${a} onclick=위치선택(${a})>${a}</button>`
			if((i) % 9 == 0){게임판 += '<br>' }
		}
	}
	document.getElementById('gameboard').innerHTML = 게임판
}

 function 위치선택(a){
	if(중복검사(a)){
				alert('안내)이미 둔 자리입니다.')
				return
	}
	
	if(count%2===1){
			document.getElementById(a).innerHTML = 'O'
			document.getElementById(a).value = 'O'
			document.getElementById(a).style.backgroundColor = "orange";
			게임상황[a] = 'O'
	} 
	
	if(count%2===0){
			document.getElementById(a).innerHTML = 'X'
			document.getElementById(a).value = 'X'
			document.getElementById(a).style.backgroundColor = "gray";
			게임상황[a] = 'X'	
	} 
	if(게임결과()){
				alert('게임종료 승리 : ' + 승리)
				return
	}
	count++
}


 

 function 중복검사( a ){
	if(게임상황[a] != null){
		return true  
	}else{
		return false     
	}	
}

 function 게임결과(){ // 가로승리변수
 	for(let c = 0 ; c<=800; c+=100){
		for(let a = 1 ; a<=5 ; a++){
			let i =c+a
			if(게임상황[i] !=null && 
			게임상황[i]== 게임상황[i+1] && 
			게임상황[i+1] == 게임상황[i+2]&&
			게임상황[i+2] == 게임상황[i+3]&&
			게임상황[i+3] == 게임상황[i+4]){
				승리 = 게임상황[i] 
				return true 
			}
		}
	}
	for(let c = 0 ; c<=8; c++){
		for(let a = 1 ; a<=501 ; a+=100){
			let i =c+a
			if(게임상황[i] !=null && 
			게임상황[i]== 게임상황[i+100] && 
			게임상황[i+100] == 게임상황[i+200]&&
			게임상황[i+200] == 게임상황[i+300]&&
			게임상황[i+300] == 게임상황[i+400]){
				승리 = 게임상황[i] 
				return true 
			}
		}
	}
	for(let c = 5 ; c<=9; c++){ // /대각선
		for(let a = 0 ; a<=400 ; a+=100){
			let i =a+c
			if(게임상황[i] !=null && 
			게임상황[i]== 게임상황[i+99] && 
			게임상황[i+99] == 게임상황[i+198]&&
			게임상황[i+198] == 게임상황[i+297]&&
			게임상황[i+297] == 게임상황[i+396]){
				승리 = 게임상황[i] 
				return true 
			}
		}
	}
	for(let c = 1 ; c<=5; c++){ // /대각선
		for(let a = 0 ; a<=400 ; a+=100){
			let i =a+c
			if(게임상황[i] !=null && 
			게임상황[i]== 게임상황[i+101] && 
			게임상황[i+101] == 게임상황[i+202]&&
			게임상황[i+202] == 게임상황[i+303]&&
			게임상황[i+303] == 게임상황[i+404]){
				승리 = 게임상황[i] 
				return true 
			}
		}
	}
}










