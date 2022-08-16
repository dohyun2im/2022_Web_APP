/**
 * 
  람다 = 익명함수
  자바스크립트는 함수도 자료형이다 [ 함수는 변수처럼 사용가능] 
  매개변수에 함수 전달이 가능하다
  함수호출[변수]
  함수호출[배열]
  함수호출[함수]
  함수호출[function(){})
  매개변수 자료형 : Number string boolean 
  				object[array , ]
 */
 function callThreeTime(callback){
	for(let i = 0; i < 3 ; i++){
		callback(i)
	}
}
 function print(i){
	console.log(`${i}번째 함수 호출`)
}
callThreeTime(print)
console.log(typeof(print))





function callThreeTime2(callback){
	for( let i = 0 ; i<3 ; i++){
		callback(i)
		}
}
callThreeTime2(
	function(i){
	console.log(`${i}번째 함수 호출`)	
	}
)




let numbers = [273, 52, 103, 32, 57]
	numbers.forEach(function(value,index,array)
	{console.log(`${index}번째 요소 : ${value}`)}
	)




numbers = numbers.map(function(value, index, array) {
	return value * value
})
console.log('map 실행 결과 : ' + numbers)
numbers.forEach(console.log)




const evenNumbers = numbers.filter(function(value){
	return value%2===0
})
console.log('원래 배열 : ' + numbers)
console.log('짝수 배열 : ' + evenNumbers)




