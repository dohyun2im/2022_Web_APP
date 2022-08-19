/**
 * 
 */
 const pet ={
	name: '구름' ,
	eat : function(food){
		alert(this.name + ' 은/는 ' + food + ' 을/를 먹습니다. ')
	}	
}
pet.eat('밥')

const student = {}
student.이름 = '윤인성'
student.취미 = '악기'
student.장래희망 = '생명공학자'

console.log(JSON.stringify(student,null,2))

delete student.장래희망
console.log(student)

const pet2 = {
	name : '구름' ,
	eat(food){
		alert(this.name+ '은/는' +food+ '을/를 먹습니다.')
	}
}