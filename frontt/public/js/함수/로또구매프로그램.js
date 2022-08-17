let select_number = []
let lotto_numbers = []
 
  function btn_print(){
	let btnlist = ''
	for (let i = 1 ; i <= 45 ; i++){
		btnlist += `<button id=${i} onclick=btn_click(${i})>${i}</button>`
		if(i%5===0){btnlist += '<br>'}
	}
	document.getElementById('btnbox').innerHTML=btnlist;
}
  
  function btn_click(i){

	let index = select_number.indexOf(i)
	
	if(index>=0){ 
		alert('이미 선택한 번호입니다. [취소]')
		select_number.splice(index , 1)
	}else{
		if(select_number.length == 6){
		alert('더 이상 선택할 수 없습니다')
		return
	}
		select_number.push(i)
	}
	document.getElementById('selectbox').innerHTML = select_number
}

	function lotto_number(){
		if(select_number.length != 6){
			alert('6개 수를 모두 입력 후 추첨해주세요.')
			return
		}
		
		while(true){
			let rand = Math.floor((Math.random()*45)+1)
			let index = lotto_numbers.indexOf(rand)
			if(index>=0){				
			}else{
				if(lotto_numbers.length == 6 ){
					break
				}else{
					lotto_numbers.push(rand)
				}
			}
		}
		document.getElementById('lottobox').innerHTML = lotto_numbers
		lotto_result()
	}

function lotto_result(){
	let count = 0 
	/*for(let i of select_number){ // 배열내 요소를 하나씩 대입반복
		for(let j of lotto_numbers){
			if (i == j){
				count++
			}
		}
	}*/
	let result_numbers = select_number.filter((value)=> lotto_numbers.includes(value))
	count = result_numbers.length
	let msg = ''
	
	if(count == 0){msg += '꽝'}
	else if(count == 1){msg += '1개 맞았습니다'}
	else if(count == 2){msg += '2개 맞았습니다.[5등]'}
	else if(count == 3){msg += '3개 맞았습니다.[4등]'}
	else if(count == 4){msg += '4개 맞았습니다.[3등]'}
	else if(count == 5){msg += '5개 맞았습니다.[2등]'}
	else if(count == 6){msg += '6개 맞았습니다.[1등]'}
	document.getElementById('resultbox').innerHTML = msg
}


