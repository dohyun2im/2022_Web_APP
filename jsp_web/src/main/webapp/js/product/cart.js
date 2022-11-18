
let cartlist = '';
let totalprice = '';
let members ='';




getcart()
function getcart(){
	$.ajax({
		url:"/jsp_web/product/cart",
		type:"get",
		async:false,
		success: re=>{
			cartlist = JSON.parse( re )
			let html = '<tr><th width="5%"></th> <th> <input class="chkbtn" type="checkbox"> </th> <th width="10%"> 이미지 </th><th width="40%"> 상품정보 </th><th width="15%"> 수량 </th> <th width="15%">가격</th> <th width="10%"> 비고 </th> </tr>';
			cartlist.forEach( c => {
				totalprice += c.amount * (c.pprice - ( c.pprice * c.pdiscount ));
				html +=  '	<tr>'+
								'<td> <input class="chkbtn" type="checkbox"> </td>'+
								'<td> <img width="80%" alt="" src="/jsp_web/admin/pimg/'+c.pimg+'"> </td>'+
								'<td> '+c.pname+' <br> - '+c.pcolor+' / '+c.psize+' </td>'+
								'<td> '+c.amount+' </td>'+
								'<td> '+c.amount * (c.pprice - ( c.pprice * c.pdiscount ) )+' </td>'+
								'<td> <button>삭제</button> </td>'+
							'</tr>';

			})
			document.querySelector('.cart_t').innerHTML = html
		}
	})	
	
}


let chkbtn = document.querySelectorAll('.chkbtn');
chkbtn[0].addEventListener('click', (e)=>{
	if(e.currentTarget.checked==true){
		chkbtn.forEach(e=> {
			e.checked = true;
		})
	}
	else{
		chkbtn.forEach(e=> {
			e.checked = true;
		})
	}
})

let checkplist = [];
function payload(){
	  chkbtn.forEach((c,i)=>{
		if(i!=0 && c.checked==true){
			checkplist.push(cartlist[i-1])
		}
	})
	if(checkplist.length==0){alert('1개이상 선택하세요'); return;}
	localStorage.removeItem('checkplist')	
	localStorage.setItem('checkplist',JSON.stringify(checkplist))
	location.href='/jsp_web/product/pay.jsp';
}


getmember();
function getmember(){
	$.ajax({
		url : "/jsp_web/member/info" ,
		success : function(result){		
			members = JSON.parse(result)
			console.log(members.mname);
			console.log(members.mpn);
			console.log(members.memail);
			console.log(members.maddr.split(',')[0]);
			console.log(members.maddr.split(',')[1]+members.maddr.split(',')[2]+members.maddr.split(',')[3]);
		}
	});
}
  
  
  
  
  
  
  
  
  
  
    
    