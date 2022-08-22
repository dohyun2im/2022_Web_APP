/**
 * 
 */

 const object = {
	name : '혼자 공부하는 파이썬' ,
	price : 18000 , 
	publisher : '한빛미디어'
}

 if(object.name !== undefined ){
	console.log('name 있습니다.')
}else{
	console.log('name 없습니다.')
}

if(object.author !== undefined ){
	console.log('name 있습니다.')
}else{
	console.log('name 없습니다.')
}

object.name = object.name !== undefined ? object.name :'제목 미정'
object.author = object.author !== undefined ? object.author : '저자 미정'
console.log(object)
/*
let [a,b] = [1,2]
console.log(a)
console.log(b)

[a,b] = [b,a]
console.log(a)
console.log(b)

let arrayA = [1,2,3,4,5]
const [a,b,c] = arrayA
console.log(a,b,c)
*/
const {name , price} = object
console.log(name)
console.log(price)

const {n=name , p=price} = object
console.log(n)
console.log(p)

