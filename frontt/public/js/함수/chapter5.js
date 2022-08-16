/*
 매개변수 : 함수 안으로 들어오는 변수
 	가변 매개변수 함수 1. 매개변수가 정해져있지 않은경우
 		- function 함수명(...나머지매개변수){}
 		- 매개변수가 배열로 들어온다
 	전개 연산자 : 함수호출할때 매개번수가 개수가 정확하지않을때 
 	 	- 함수명 (데이터,데이터)
 	 	- 함수명(...데이터)
 */
 function sample(...items){
	console.log(items)
}

sample( 1 , 2 , 3 ) // 인수전달
sample( 1 , 2 , 3 , 4 ) // 인수전달
sample( 1 , 2 , 3 , 4 , 'java' , true , '안녕하세요')

// 가변 매개변수 / 일반매개변수 조합 함수

function sample2( a , b , ... c ){
	console.log( a , b , c )
}
sample2( 1 , 2 )
sample2( 1 , 2 , 3 )
sample2( 1 , 2 , 3 , 4 )
sample2( 1 )


// 전개연산자를 가변매개변수에 .
function sample3(...items){
	console.log(items)
}
const array = [ 1 , 2 , 3 , 4 ]
console.log("# 전개 연산자를 사용하지 않는 경우")
sample3(array)
console.log("# 전개 연산자를 사용한 경우")
sample3(...array)