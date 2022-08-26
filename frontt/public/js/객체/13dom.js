const input = document.querySelector('#inchbox')
const button = document.querySelector('#btn')
const p = document.querySelector('#pbox')
 
button.addEventListener('click' , () => {
	const inch = Number(input.value)
	if(isNaN(inch)){
		p.textContent='숫자를 입력해주세요'
		return
	}
	const cm = inch * 2.54
	p.textContent= `${cm}cm`
})




const emailbox =document.querySelector('#emailbox')
const emailp =document.querySelector('#emailp')

const isemail = (value) => {
	return (value.indexOf("@")>1) && (value.split("@")[1].indexOf(".")>1)
}

emailbox.addEventListener('keyup' , (event)=>{
	const value = event.currentTarget.value //현재 이벤트중인 객체
	if(isemail(value)){
		p.style.color = 'green'
		p.textContent = `이메일 형식입니다. ${value}`
	}else{
		p.style.color = 'red'
		p.textContent = `이메일 형식이 아닙니다. ${value}`
	}
})

 // 배열내 해당 데이터의 인덱스번호찾기
 // 문자열.split('기준문자') 문자열내 기준문자 기준으로 분리
 
 
 
 
 const select =document.querySelector('#selectbox')
 const selectp =document.querySelector('#select_p')
 
 
 select.addEventListener('change' , (event)=>{
	
	//select 안에 모든 options호출
	const options = event.currentTarget.options
	const index = event.currentTarget.options.selectedIndex
	selectp.textContent= `선택 : ${options[index].textContent}`
})
 
 
 
  const select2 =document.querySelector('#selectbox2')
  const selectp2 =document.querySelector('#select_p2')
  
  select2.addEventListener('change' , (event)=> {
	const options = event.currentTarget.options
	const list = []
	
	for(const option of options ){
		if(option.selected){
			list.push(option.textContent)
		}
	}
	selectp2.textContent = `선택 : ${list.join(',')}`
	
})
 
 
 
 
	let 현재값
	let 변환상수 = 10
	
	const select3 = document.querySelector('#select3')
	const input3 = document.querySelector('#cmbox')
	const span3 = document.querySelector('#span1')
	
	const calculate = () => {
		span3.textContent = (현재값*변환상수).toFixed(2)
	}
	
	select3.addEventListener('change' , (event) => {
		const options = event.currentTarget.options
		const index = event.currentTarget.options.selectedIndex
		변환상수 = Number(options[index].value)
		calculate()
	})
	
	input3.addEventListener('keyup',(event)=>{
		현재값=Number(event.currentTarget.value)
		calculate()
	})
 
 
 
 	let[timer,timerId] = [0,0]
	const chkbox = document.querySelector('#chkbox')
	const head1 = document.querySelector('#head1')
	
	chkbox.addEventListener('change' , (event)=> {
		if(event.currentTarget.checked){
			timerId=setInterval(()=>{
				timer+=1
				head1.textContent = `${timer}초`
			},1000)
		}else{
			clearInterval(timerId)
		}
	})
 
 
 	const radios =document.querySelectorAll('[name=pet]')
 	const output =document.querySelector('#output')
 	
 	radios.forEach((radio) =>{
	radio.addEventListener('change' , (event) =>{
		const current = event.currentTarget
		if(current.checked){
			output.textContent=`좋아하는 애완동물은 ${current.value}이시군요!`
		}
	})
})
    
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 