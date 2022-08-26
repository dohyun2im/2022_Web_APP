/**
 * 
 document.addEventListener.(이벤트명 , 함수)
	이벤트종류
		1. Click : 객체 클릭했을때 함수 실행
		2. keyup : 객체에서 키가 떨어질떄 함수 실행
		 
 */
	const 긴글상자 = document.querySelector('textarea')
 	const 헤더텍스트 = document.querySelector('h1')
 	
 	긴글상자.addEventListener('keyup' , ()=> {
	const length = 긴글상자.value.length
	헤더텍스트.textContent = `글자 수 :${length}`
	})

	function 글자수(){
	const 길이 = 긴글상자.value.length
	헤더텍스트.textContent = `글자 수 : ${길이}`
	}	

	
	const h2 = document.querySelector('h2')
	const print = (event) =>{
		let output =''
		output+=`alt : ${event.altKey}<br>`
		output+=`ctrl : ${event.ctrlKey}<br>`
		output+=`shift : ${event.shiftKey}<br>`
		output+=`code : ${typeof(event.code) != 'undefined' ?
		event.code : event.keycode}<br>`
		
		h2.innerHTML = output
		
		
	}
	document.addEventListener('keyup' , print)
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	