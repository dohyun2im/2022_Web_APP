

let cselect =document.querySelector('.categorybox');
let pselect =document.querySelector('.productbox');
let rows =document.querySelectorAll('.rows');
let productlist = null;

getcategory()
function getcategory(){
	$.ajax({
		url:"/jsp_web/board/pcategory",
		type:"get",
		success:function(re){
			let category = JSON.parse(re)
			let html = '';
			category.forEach(c  => {
				html+=`<option value=${c.pcno}>${c.pcname}</option>`
			})
			cselect.innerHTML=html;
		}
	})
}

cselect.addEventListener('click', e=>{
	let pcno = e.currentTarget.value
	getproduct(pcno)
})

pselect.addEventListener('click', e=>{
	let pno = e.currentTarget.value
	productlist.forEach(p=>{
		if(p.pno==pno){
			rows[0].innerHTML=p.pcno;
			rows[1].innerHTML=p.pno;
			rows[2].innerHTML=p.pname;
			getstock();
		}
	})
})

function getproduct(pcno){
	$.ajax({
		url: "/jsp_web/admin/regist",
		type:"get",
		data : {"type":1 , "option":"all"},
		success:function(re){
			productlist = JSON.parse(re)
			let html = '';
					   
			productlist.forEach(j=>{
				if(j.pcno==pcno){
					html+= `<option value=${j.pno}>${j.pname}</option>`;
				}
			})
			pselect.innerHTML=html;
		}
	})
}

function setstock(){
	let info = {
		psize : document.querySelector('.psize').value ,
		pcolor : document.querySelector('.pcolor').value ,
		pstock : document.querySelector('.pstock').value ,
		pno : rows[1].innerHTML
	}
	console.log(info)
	$.ajax({
		url:"/jsp_web/admin/stock",
		type:"post",
		data:info,
		success: re => {
			if(re=='true'){alert('성공'); getstock();}
			else{alert('실패')}
		}
	})
}


function getstock(){
	$.ajax({
		url:'/jsp_web/admin/stock',
		type:"get",
		data:{"pno": rows[1].innerHTML} ,
		success: re =>{
			let json = JSON.parse(re)
			console.log(json)
			let html ='<tr><th>사이즈</th><th>색상</th><th>재고</th><th>비고</th></tr>';
			json.forEach(j=>{
				html += `<tr><th>${j.psize}</th><th>${j.pcolor}</th><th>${j.pstock}</th><th>-</th></tr>`
			})
			document.querySelector('.stockoutput').innerHTML=html;
		}
	})
}














