//엔터키로
function enterkey(){
	if(window.event.keyCode==13){
		send()
	}
}

//js웹소켓 클래스
let mid = document.querySelector('.mid').value;
let type = 132;
let websocket = null;
if(mid!==null){
	websocket = new WebSocket('ws://localhost:8081/jsp_web/chatting/'+mid);
	//메소드를 클라이언트에 대입한다.
	websocket.onopen = function(e){onopen(e)}
	websocket.onclose = function(e){onclose(e)}
	websocket.onmessage = function(e){onmessage(e)}
	websocket.onerror = function(e){onerror(e)}
}

//메소드
function onopen(e){e}
function onclose(e){e}
function onerror(e){e}

function send(){
	let msg = {
		type : "msg",
		from : mid ,
		content : document.querySelector('.msgbox').value,
		date : new Date().toLocaleTimeString(),
		img:'유니.jpg'
	}
	websocket.send(JSON.stringify(msg)) //JSON으로 변환
	document.querySelector('.msgbox').value='';
}

//이모티콘 호출
emoview()
function emoview(){
	let html='';
	for(let i=1 ; i<=43; i++){
		html+= '<img src="/jsp_web/img/imoji/emo'+i+'.gif" width="70px" onclick="emosend('+i+')">'
	}
	document.querySelector('.dropdown-menu').innerHTML=html;
}
function emosend(i){
	let msg ={
		type : "emo",
		content : i , 
		mid : mid ,
		date : new Date().toLocaleTimeString(),
		img : '유니.jpg'
	}
	websocket.send(JSON.stringify(msg))
}

//메시지보내기
function onmessage(e){
	let msg = JSON.parse(e.data);
	//일반메시지
	if(msg.type=="msg"){
		//본인글이면?
		if(msg.from===mid){
			let html =document.querySelector('.contentbox').innerHTML;
			html+='<div class="secontent my-3">'+
	'							<span class="date">'+msg.date+'</span>'+
	'							<span class="content">'+msg.content+'</span>'+
	'			   </div>';
			document.querySelector('.contentbox').innerHTML=html;
		}
		else{//상대
			let html =document.querySelector('.contentbox').innerHTML;
			html+='<div class="row g-0 my-3">'+
	'				<div class="col-sm-1 mx-2">'+
	'				<img width="100%;" class="rounded-circle" src="/jsp_web/img/'+msg.img+'">'+
	'				</div>'+
	'				'+
	'							<div class="col-sm-9">'+
	'								<div class="recontent">'+
	'									<div class="name">'+msg.from+'</div>'+
	'									<span class="content">'+msg.content+'</span>'+
	'									<span class="date">'+msg.date+'</span>'+
	'								</div>'+
	'							</div>'+
	'					</div>';
			document.querySelector('.contentbox').innerHTML=html;
		}
	}
	else if(msg.type=="emo"){
		//본인임티
		if(msg.mid==mid){
			let html =document.querySelector('.contentbox').innerHTML;
			html+='<div class="secontent my-3">'+
	'							<span class="date">'+msg.date+'</span>'+
	'							<img src="/jsp_web/img/imoji/emo'+msg.content+'.gif">'+
	'			   </div>';
			document.querySelector('.contentbox').innerHTML=html;	
		}
		else{//상대
			let html =document.querySelector('.contentbox').innerHTML;
			html+='<div class="row g-0 my-3">'+
	'				<div class="col-sm-1 mx-2">'+
	'				<img width="100%;" class="rounded-circle" src="/jsp_web/img/'+msg.img+'">'+
	'				</div>'+
	'				'+
	'							<div class="col-sm-9">'+
	'								<div class="recontent">'+
	'									<div class="name">'+msg.from+'</div>'+
	'									<img src="/jsp_web/img/imoji/emo'+msg.content+'.gif">'+
	'									<span class="date">'+msg.date+'</span>'+
	'								</div>'+
	'							</div>'+
	'					</div>';
			document.querySelector('.contentbox').innerHTML=html;
		}
	}
	else if(msg.type=="alarm"){
		let html =document.querySelector('.contentbox').innerHTML;
		html +=  '<div class="alarm">'+
'					<span>'+msg.content+'</span>'+
'				  </div>';
		document.querySelector('.contentbox').innerHTML=html;
	}
	//스크롤내리기
	document.querySelector('.contentbox').scrollTop = document.querySelector('.contentbox').scrollHeight;  
}


 
//메소드를 소켓에 대입






