/**
 * 
 */
function multiplyall(a,b){
	let result = 1
	for(let i = a ; i<=b ; i ++){
		result *= i
	}
	return result
}
console.log('모두 곱한 값 '+ multiplyall(1,2))
console.log('모두 곱한 값 '+ multiplyall(1,10))


const max = function(array) {
	let output = array[0] // 배열내 가장 첫번째 값을 큰값 설정
	for(let i of array){ // 배열내 값을 하나씩 i에 대입반복
		if(output < i ){output = i } // i의 값이 더크면 교체
	}
	return output
}
console.log(max ( [1,2,3,4] ) )




const max2 = function(...array) {
	let output =array[0] 
	for(let i of array){
		if(output < i ){output = i } 
	}
	return output
}
console.log(max2 ( 1,2,3,4 ) )







const max3 = function(array , ... array2) {
	
	let maxvalue = 0
	let items
	if(typeof(array) === 'object'){
		items = array
	}else if(typeof(array2)!= 'Number'){
		items = array2
	}
	for(let i of items){
		if(maxvalue < i){ maxvalue = i}
	}
	return maxvalue
}
console.log('최대값 구하기 결과 [배열-> 매개변수1개] : ' + max3 ( [1,2,3,4] ) ) //배열
console.log('최대값 구하기 결과 [숫자-> 매개변수4개] : ' + max3 ( 1,2,3,4 ) ) // 숫자1 , 배열





