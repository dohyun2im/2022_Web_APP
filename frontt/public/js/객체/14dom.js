const imgs = document.querySelectorAll('img')

for(let i = 0 ; i<imgs.length; i++){
	imgs[i].addEventListener('contextmenu' , (event)=>{
		event.preventDefault()
	})
}
/*
for(i in imgs){ //인덱스
	imgs[i].addEventListener('contextmenu' , (event)=>{
		event.preventDefault()
	})
}

for(i of imgs){ //값
	i.addEventListener('contextmenu' , (event)=>{
		event.preventDefault()
	})
}

imgs.forEach((img)=> {
	img.addEventListener('contextmenu' ,(event)=>{
		event.preventDefault()
	})
})
*/

let status = false // 체크박스 체크했는지 확인?


const checkbox = document.querySelector('input')
checkbox.addEventListener('change' , (event) =>{
	status = event.currentTarget.checked
})


const link = document.querySelector('a')
link.addEventListener('click' , (event) =>{
	if(!status){
		event.preventDefault()
	}
})

  





























