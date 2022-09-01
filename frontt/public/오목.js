



let 게임상황 = [] //현재 알을 둔 상황을 저장 배열
let 승리 = '' // 이긴 알의 변수

function 게임판그리기(){

	승리 = ''

	게임상황=[null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,
			null,null,null,null,null,null,null] //알을 49개 그린다.


	let 게임판 =''

	for ( let i = 0 ; i < 49 ; i++){
		게임판 += `<button id=${i} onclick=위치선택(${i})>${i}</button>`
		if((i+1) % 7 == 0){게임판 += '<br>' } //7개마다 줄바꿈
	}
	document.getElementById('gameboard').innerHTML = 게임판
}

 /* -------------실행함.----------------- */

 

 function 위치선택(i){

	if(중복검사(i)){
		alert('안내)이미 둔 자리입니다.')
		return
	}
	
	document.getElementById(i).innerHTML = 'O'  //바보오목 사람은 1개 랜덤은 6번
	document.getElementById(i).style.backgroundColor = "orange";
	게임상황[i] = 'O'

	
	if(게임결과()){
		alert('게임종료 승리 : ' + 승리)
		return
	 }

	for(let x = 0 ; x< 6 ; x++){
		while(true){
		let rand = Math.floor(Math.random()*49)
			if (!중복검사(rand)){
			document.getElementById(rand).innerHTML = 'X'
			document.getElementById(rand).style.backgroundColor = "gray";
			게임상황[rand]= 'X'
			break
			}
		}
	} 
}


 

 function 중복검사( i ){
	if(게임상황[i] != null){
		return true  
	}else{
		return false     
	}	
}

 

 function 게임결과(){ 
	for(let i = 0 ; i <=2 ; i++){
			if(게임상황[i] !=null && 게임상황[i+b]== 게임상황[i+b+1] &&
								   게임상황[i+b+1] == 게임상황[i+b+2]&&
								   게임상황[i+b+2] == 게임상황[i+b+3]&&
								   게임상황[i+b+3] == 게임상황[i+b+4]){
			승리 = 게임상황[i]
			return true
		}
	}
	
	
	
	let  oxCount = 0; //무승부
    for (let i = 0; i < 49; i++) {
        if(게임상황[i] != null) {
        oxCount++;
        }
        if(oxCount > 42 ) {
        alert('게임 무승부')
        }
    }
} 










