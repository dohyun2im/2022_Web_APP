
function comment(){
	alert('코멘트')
	let form1 = document.querySelector('form')
	let formdata1 = new FormData(form1)
	console.log(formdata1)
	$.ajax({
		url: "/jsp_web/board/commentwrite",
		data:formdata,
		contentType:false, // multipart/form-data로 바뀜
		processData:false, //
		type: 'POST',
		success : function(result){
			if(result==='true'){alert('성공')}
		}
	})	
}