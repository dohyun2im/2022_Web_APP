
 
let sidebar = document.querySelector('.sidebar')
let mainbox  = document.querySelector('#mainbox')

sidebar.addEventListener('click',function(){
	sidebar.style.left=0;
})

mainbox.addEventListener('click',function(){
	sidebar.style.left='-170px';
})

function pagechange(page){
	$('#mainbox').load(page)
	sidebar.style.left='-170px';
}