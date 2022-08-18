/**
 * 변수/상수 : 메모리 1개
   배열: 변수 여러개를 저장하는 객체
   함수: 미리 정의된 코드
   객체[object]: 실제로 존재하는 사물 ??
   인스턴스[instance]
   객체지향[oop]
 */
 
 const product = {
	제품명 : '7D 건조 망고' ,
	유형 : '당절임' ,
	성분 : '망고 , 설탕 , 메타중아황산나트륨 , 치자황색소' ,
	원산지 : '필리핀' 
}
console.log('객체호출 : ' + product)
console.log('객체내 속성호출 : '+ product['원산지'])
console.log('객체내 속성호출 : '+ product['유형'])
console.log('객체내 속성호출 : '+ product.성분)


const object = {
	number : 273 ,
	string : '구름' ,
	boolean : true ,
	array : [52,273,103,32] ,
	method : function(){console.log('함수실행')}
}
console.log('객체내 메소드호출 : '+ object.method())