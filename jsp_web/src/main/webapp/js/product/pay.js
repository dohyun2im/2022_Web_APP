
let checkplist = JSON.parse(localStorage.getItem('checkplist'))
console.log(checkplist)

let member = null;

getmember();
function getmember(){
	$.ajax({
		url : "/jsp_web/member/info" ,
		success : function(result){		
			member = JSON.parse(result)
			console.log(member.mname);
			console.log(member.mpn);
			console.log(member.memail);
			console.log(member.maddr.split(',')[0]);
			console.log(member.maddr.split(',')[1]+member.maddr.split(',')[2]+member.maddr.split(',')[3]);
		}
	});
}

document.querySelector('.checkbtn').addEventListener('click',(e)=>{
	if(e.currentTarget.checked==true){
		document.querySelector('.oname').value=  member.mname;
		document.querySelector('.ophone').value= member.mpn  
		document.querySelector('.oaddr').value=  member.maddr;
	}else{
		document.querySelector('.oname').value=  '';
		document.querySelector('.ophone').value= '';
		document.querySelector('.oaddr').value=  '';
	}
})
let pmethod = '';

function paymethod(payM){
	pmethod=payM;
	alert('pmethod')
}

//아임포트 결제하기
function requestPay() {
	var IMP = window.IMP;
	IMP.init("imp14103839");
	
      IMP.request_pay({ 
          pg: "kcp",
          pay_method: pmethod,
          merchant_uid: "ORD20180131-0000011",   //주문번호
          name: "d",
          amount: '',                         // 숫자타입
          buyer_email: '',
          buyer_name:'',
          buyer_tel:'',
          buyer_addr: '',
          buyer_postcode: ''
      }, function (rsp) { // callback
          if (rsp.success) {
             //성공
             setorder()
          } else {
             //실패
             setorder()
          }
      });
  }
  
  function setorder(){
	let orderinfo={
		oname : document.querySelector('.oname').value ,
		ophone : document.querySelector('.ophone').value , 
		oaddr : document.querySelector('.oaddr').value,
		orequest : document.querySelector('.orequest').value
	}
	$.ajax({
		url:'/jsp_web/product/order',
		data:{"checkplist":JSON.stringify(checkplist) , "orderinfo":JSON.stringify(orderinfo)},
		type:"post",
		success :(re)=>{
			if(re=='true'){
				alert('주문완료')
				location.href='/jsp_web/product/ordersuccess.jsp';
				localStorage.removeItem('checkplist');
			}else{
				alert('주문실패 [관리자에게 문의]')
			}
		}
	})
}
  
  
  
  
  
  
  
  