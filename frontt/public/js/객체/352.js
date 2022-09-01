document.addEventListener('DOMContentLoaded' , ()=> {
	const input= document.querySelector('#todo') //html id값 todo를 가져온다
	const todolist= document.querySelector('#todo_list') //html id값 todo_list를 가져온다
	const addButton= document.querySelector('#add_button') //html id값 add_button를 가져온다
	
	let keycount = 0 // setAttribute(key, value)는 통해 html 태그에 해당 key로 셋팅해서 value값을 넣어준다.
					 // item에 키값을 주고 todolist에 넣고 html에 넣거나 remove할시 사용
	
	const addTodo = () =>{ // 첫 입력창에 넣을 함수
		if(input.value.trim()===''){ //input 값의 trim(문자열공백)과 ''같으면
			alert('할 일을 입력해주세요')
			return //되돌려준다 입력하게끔
		}
	
	
		const item = document.createElement('div') //div를 html에 생성하는 함수 
		const checkbox = document.createElement('input') //input를 html에 생성하는 함수 
		const text = document.createElement('span') //span를 html에 생성하는 함수 
		const button = document.createElement('button') //button를 html에 생성하는 함수 
		
		const key = keycount //key는 +=1씩 증가
		keycount += 1
		
		item.setAttribute('data-key' , key) //item은 data-key라는 속성값을 가지고 key는 +=1씩 증가함
		item.appendChild(checkbox)
		item.appendChild(text)
		item.appendChild(button) // item은 => <div> checkbox text button </div>
		todolist.appendChild(item) //todolist라는 값 안에 자식 item을 넣어준다.
		
		checkbox.type = 'checkbox' 		//checkbox라는 const의 input은 체크박스 타입으로 변경
		checkbox.addEventListener('change' , (event) => {
			item.style.textDecoration
			=event.target.checked ? 'line-through':'' 
		})								// 체크박스가 체크로 변했을때 지나가는 라인 텍스트데코 이벤트 생성
		
		text.textContent=input.value	// input값을 todolist->item->text안에 추가한다.
		
		button.textContent='제거하기' //button에 제거하기 글자 넣기
		button.addEventListener('click' , ()=>{
			removeTodo(key)
		})	//버튼을 누르는 이벤트가 생기면 removeTodo(key)라는 함수를 생성하고 (key)를 찾아간다
		
		input.value='' // input 입력값을 지워준다
	} //addTodo end
	
	
	
	const removeTodo = (key) =>{
		const item =document.querySelector(`[data-key="${key}"]`)
		// item 속성인 data-key값안에 key를 순서대로 가져와라
		todolist.removeChild(item) //todolist안에 item에 ${key}값을 제거 
	}
	
	
	
	addButton.addEventListener('click' ,addTodo) 
	//추가하기 버튼을 누르는 이벤트가 생성되면 addTodo 함수실행 
	input.addEventListener('keyup' , (event)=>{ //input에서 키를 눌렀다떼는 이벤트를 발생하면?
		const ENTER = 13 // 엔터값은 13
		if(event.keyCode === ENTER){ //키를 누른것이 엔터라면
			addTodo() //addTodo함수실행
		}
	})	
	//추가하기버튼을 클릭하거나 or input에서 엔터를 누르면 addTodo가 실행됩니다 !	
})