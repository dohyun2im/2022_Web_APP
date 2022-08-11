sumAll(a,b)


function sumAll(a,b){
	let output = 0
	for(let i = a ; i<=b ; i++){
		output += i
	}
	return output
}
console.log(`1부터 100까지의 합 : ${sumAll(1,100)}`)
console.log(`1부터 100까지의 합 : ${sumAll(1,500)}`)

//html 함수


function 계산버튼함수(){
 alert('버튼눌림 확인')
let sin = Number(document.getElementById('sinput').value)
let ein = Number(document.getElementById('einput').value)
let result = sumAll(sin , ein)
document.getElementById('resultbox').innerHTML = '계산 결과 : + result'
}