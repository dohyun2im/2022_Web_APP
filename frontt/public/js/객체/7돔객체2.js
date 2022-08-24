/**
 * 
 */
 document.addEventListener('DOMContentLoaded',()=> {
	const header = document.querySelector('h1')
	
	header.textContent = '안녕하세요'
	header.style.color = 'white'
	header.style.backgroundColor = 'black'
	header.style.padding = '10px' 
})


document.addEventListener('DOMContentLoaded' , ()=> {
	const headers = document.querySelectorAll('h1')
	
	for(let i = 0 ; i<headers.length ; i++){
		headers[i].textContent='안녕ㅎ'+i	
	}
	for(let index in headers){//0부터 마지막 인덱스까지 하나씩 대입반복
		headers[index].textContent = '안녕!'+index
	}
	
	for(let object of headers){//0번째 인덱스의 데이터를 마지막 인덱스의 데이터를 하나씩 대입반복
		object.textContent='안녕?'
	}
	
	headers.forEach((header)=>{
		header.textContent='안녕ㅋ'
	})
	
})