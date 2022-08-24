let counter = 0
let isConnect = false // 연결상태

const h1 = document.querySelector('h1')
const p = document.querySelector('p')
const connectbtn = document.querySelector('#connect')
const disconnectbtn = document.querySelector('#disconnect')
const psbtn = document.querySelector('#ps')
const msbtn = document.querySelector('#ms')


const listener = () => {h1.textContent =`클릭 횟수:${++counter}`}
const dislistener = () => {h1.textContent =`클릭 횟수:${--counter}`}

connectbtn.addEventListener('click' , ()=>{
	if(isConnect == false){
		h1.addEventListener('click',listener)
		p.textContent = '이벤트 연걸 상태: 연결'
		isConnect = true 
	}
})

disconnectbtn.addEventListener('click', ()=>{
	if(isConnect == true){
		h1.removeEventListener('click',listener)
		p.textContent='이벤트 연결 상태: 해제'
		isConnect = false
	}
})

psbtn.addEventListener('click', ()=>{
		ps.addEventListener('click',listener)
})



msbtn.addEventListener('click', ()=>{
	ms.addEventListener('click',dislistener)
})















