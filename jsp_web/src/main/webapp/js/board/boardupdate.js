$(document).ready(function() {
  $('#summernote').summernote({
	placeholder:'내용입력',
 	maxHeight:null , 
 	minHeight:200
	});
});
function update(){
	let form = document.querySelector('form')
	console.log(form)
	let formdata = new FormData(form)
	console.log(formdata)
	$.ajax({
		url: "/jsp_web/board/boardupdate",
		data:formdata,
		contentType:false, // multipart/form-data로 바뀜
		processData:false, //
		type: 'POST',
		success : function (re){location.href="/jsp_web/board/boardlist.jsp"}
	})	 	
}