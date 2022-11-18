/**
 * 
 */
let pno = document.querySelector('.pno').value
let sizebox ='사이즈 : ';
let sizeoption ='<option>[필수]사이즈 선택</option>';
let coloroption ='<option>[필수]색상 선택</option>';
let stock='';
let product='';
let color='';
let sproductlist = [];
let sale = 0;

//제품정보호출
getproduct()
function getproduct(){
	$.ajax({
		url:'/jsp_web/admin/regist',
		type:'get',
		async:false,
		data:{"type":2,"pno":pno},
		success: re => {
			product = JSON.parse(re)
			document.querySelector('.pimg').src = '/jsp_web/admin/pimg/'+product.pimg;
			document.querySelector('.pname').innerHTML=product.pname;
			document.querySelector('.pcon').innerHTML=product.pcomment;
			
			if(product.pdiscount>0){
				sale=(product.pprice-(product.pprice*product.pdiscount))
				document.querySelector('.pricebox').innerHTML=  '<span class="pdiscount">'+Math.round(product.pdiscount*100)+'%</span>'+
																'<span class="pprice">'+product.pprice.toLocaleString()+'원</span>'+
															    '<span class="saleprice">'+sale.toLocaleString()+'원</span>'
															   
			}else{
				sale=product.pprice
				document.querySelector('.pricebox').innerHTML=`<span class='psale'>${sale.toLocaleString()}</span>`
			}	
		}
	})
}

//제품색상사이즈호출
getsizecolor()
function getsizecolor(){
	$.ajax({
		url:'/jsp_web/admin/stock',  
		type:"get",
		async:false, 
		data:{"pno": pno} ,
		success: re =>{
			stock = JSON.parse(re)
			
			let sizelist=[]
			let colorlist=[]
			stock.forEach(j=>{
				sizelist.push(j.psize)
				colorlist.push(j.pcolor)
			})
			let sizeset = new Set(sizelist)
			let colorset = new Set(colorlist)
			
			sizeset.forEach(j=>{
				sizebox+=(j+" ")
				sizeoption+='<option value='+j+'>'+j+'</option>'
			})
			colorset.forEach(j=>{
				coloroption+='<option value='+j+'>'+j+'</option>'
			})
			document.querySelector('.sizebox').innerHTML=sizebox;
			document.querySelector('.sizeoption').innerHTML=sizeoption;
			document.querySelector('.coloroption').innerHTML=coloroption;
		}
	})
}
//체인지이벤트 색상에 맞는 사이즈 가져오기
document.querySelector('.coloroption').addEventListener('change',(e)=>{
	color = e.currentTarget.value;
	let html='<option>[필수]사이즈 선택</option>';
	stock.forEach(s=>{
		if(s.pcolor==color){
			html+='<option value'+s.psize+'>'+s.psize+'</option>'
		}
		document.querySelector('.sizeoption').innerHTML=html;
	})
})
//체인지이벤트 
document.querySelector('.sizeoption').addEventListener('change',(e)=>{
	let size = e.currentTarget.value;
	
	if(size=='[필수]사이즈 선택'){return;}
	for(p of sproductlist){
		if(p.pcolor == color && p.psize == size){
			p.amount++; 
			print();
			return;
		}
	}
	let sproduct = {
		pcolor: color,
		psize: size,
		amount:1
	}
	sproductlist.push(sproduct)
	print()
})
//찜하기 눌렀을때
document.querySelector('.btnlike').addEventListener('click',(e)=>{
	let mid = document.querySelector('.mid').value;
	if(mid=='null'){
		alert('login하세요');
		return;
	}
	$.ajax({
		url:"/jsp_web/product/plike",
		type:"post",
		data:{"pno":pno},
		success: re=> {
			if(re==1){
				alert('취소')
				document.querySelector('.btnlike').style.backgroundColor = "white";
			}
			else if(re==2){
				alert('찜')
				document.querySelector('.btnlike').style.backgroundColor = "orange";
			}
			else if(re==3){
				alert('DB오류')
			}
		}
	})
	
})
document.querySelector('.btncart').addEventListener('click',(e)=>{
	if(sproductlist.length==0){
		alert('옵션을 고르세요 '); 
		return;
	}
	if(document.querySelector('.mid').value=='null'){
		location.href='/jsp_web/member/login.jsp';
		return;
	}
	$.ajax({
		url:'/jsp_web/product/cart',
		type:"post",
		data:{"data":JSON.stringify(sproductlist), "pno":pno},
		success:re=>{
			if(re=='true'){
				sproductlist=[];
				if(confirm('장바구니에 담았습니다. 장바구니페이지로 이동할까요 ?')){
					location.href='cart.jsp';
				}
			}
			else{
					alert('장바구니 담기 실패 ??')
				}
		}
	})
});


function print(){
	let ohtml='';
	let totalprice =0;
	let totalamount=0;
	
	sproductlist.forEach((s,i)=>{
			let totalsale = sale*s.amount;
			let totalpoint = Math.round(totalsale*0.01);
			totalprice  += totalsale;
			totalamount += s.amount;
			
			ohtml+=		'<tr>'+
'							<td>'+
'								<span>'+product.pname+'</span><br>'+
'								<span>'+s.pcolor+'/'+s.psize+'</span>'+
'							</td>'+
'							<td>'+
'								<div class="row g-0">'+
'									<div class="col-md-3">'+
'										<input class="form-control" value='+s.amount+' readonly>'+
'									</div>'+
'									<div class="col-md-4">'+
'										<button class="aomunt_btn" onclick="amountup('+i+')">▲</button>'+
'										<button class="aomunt_btn" onclick="amountdown('+i+')">▼</button>'+
'									</div>'+
'									<div class="col-md-1">'+
'										<button class="cancel_btn" onclick="pcancel('+i+')">X</button>'+
'									</div>'+
'								</div>'+
'							</td>'+
'							<td>'+
'								<span>'+totalsale.toLocaleString()+'원</span><br>'+
'								<span class="pointbox">포인트:'+totalpoint.toLocaleString()+'</span>'+
'							</td>		'+
'						</tr>';
	})
	document.querySelector('.select_t').innerHTML = ohtml;
	let phtml = totalprice.toLocaleString()+"원"+'('+totalamount+'개)'
 	document.querySelector('.totalprice').innerHTML = phtml;
}
function pcancel(i){
	sproductlist.splice(i,1); print();
}

function amountup(i){
	let max = 0;
	stock.forEach(s=>{
		if(s.pcolor==sproductlist[i].pcolor && s.psize==sproductlist[i].psize){
			max= s.pstock
		}
	})
	if(sproductlist[i].amount>=max){
		alert('재고부족'); 
		return;
	}
	else{
		sproductlist[i].amount++; print()
	}	
}


function amountdown(i){
	if(sproductlist[i].amount<=1){
		alert('최소수량'); 
		return;
	}
	else{
		sproductlist[i].amount--; print()
	}	
}


















