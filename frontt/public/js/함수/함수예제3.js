/**
 * 
 */
 
 function 함수1(){alert('함수1실행')}
 
 function 함수2(value){
	alert('함수2실행 매개변수 : ' +value)
}
 function 함수3(value1 , value2){
	alert('함수3실행 매개변수 : ' +value1+value2)
	return value1 + value2
}
 function 함수4( ){
	alert('함수 4실행')
	return 10
}

함수1()
함수2(50)
let result = 함수3(3,5)
let result2 = 함수4()


function min( array ){
	let output= (array)[0]
	for(const item of array){ //배열에 요소를 하나씩 item에 대입
		if(output>item){      //in : 인덱스를 대입반복 of : 인덱스의 값을 대입반복
			output = item // item이 아웃풋보다 작으면 아웃풋에 아이템 대입
		}
	}
	return output
}

const testArray = [52,273,32,103,275,24,57]
console.log(`${testArray}중에서`)
console.log(`최솟값=${min(testArray)}`)