/**
 * 
 */
 
 document.addEventListener('DOMContentLoaded',()=>{
 const a = document.querySelector('#a')
 const b = document.querySelector('#b')
 
 a.textContent = '<h1>텍스트 넣어요</h1>'
 b.innerHTML= '<h1>HTML형식으로 넣기</h1>'	

 const rects = document.querySelectorAll('.rect')
 	for(let i = 0 ; i<rects.length ; i++){
	const width = (i+1)*100
	const src = `http://placekitten.com/${width}/250`
	rects[i].setAttribute('src',src)
}	// rects.src=src

 const divs = document.querySelectorAll('#divbox div')
 divs.forEach((div,index)=>{
	console.log(div,index)
	const val = index *10
	div.style.height=`10px`
	div.style.backgroundColor =`rgba(${val},${val},${val})`	
	})


})



 