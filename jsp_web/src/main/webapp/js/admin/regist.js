
function regist(){
	let form = document.querySelector('form')
	let formdata = new FormData(form);
	$.ajax({
		url: "/jsp_web/admin/regist",
		data:formdata ,
		type:"post",
		processData:false,
		contentType:false,
		success: function(re){
			if(re=='true'){
				alert('등록 성공')
			}
			else{
				alert('등록 실패')
			}
		}
	})
}

let pimg = document.querySelector('#pimg')

pimg.addEventListener('change',function(e){
	let file = new FileReader()
	
	//경로찾기
	let path = file.readAsDataURL(e.target.files[0])
	
	//특정태그에 이미지 삽입.
	file.onload = function(e){
		document.querySelector('#pimgpre').src=e.target.result
	}
})

function pcatehoryview(){
	document.querySelector('.pcategorybox').innerHTML=
	'<input type="text" id="pcname">'+
	'<button type="button" onclick="categoryadd()">카테고리등록</button>'
}

function categoryadd(){
	$.ajax({
		url:"/jsp_web/board/pcategory",
		type:"post",
		data:{"pcname":document.querySelector('#pcname').value},
		success:function(re){
			if(re==='true'){
				alert('카테고리 등록')
				document.querySelector('.pcategorybox').innerHTML='';
				categorylist()
			}else{alert('등록 실패')}
		}
	})
}
categorylist()
function categorylist(){
	$.ajax({
		url:"/jsp_web/board/pcategory",
		type:"get",
		success:function(re){
			let category = JSON.parse(re)
			let html = '';
			for(let i=0; i<category.length; i++){
				html+='<input type="radio" name="pcno" value='+category[i].pcno+'>'+category[i].pcname+'<br>'
			}
			document.querySelector('.pcategorylist').innerHTML=html;
		}
	})
	
}



