//엔터키로
function enterkey(){
	if(window.event.keyCode==13){
		send()
	}
}

//js웹소켓 클래스
let mid = document.querySelector('.mid').value;
let websocket = null;
if(mid!==null){
	websocket = new WebSocket('ws://localhost:8080/jsp_web/chatting/'+mid);
	//메소드를 클라이언트에 대입한다.
	websocket.onopen = function(e){onopen(e)}
	websocket.onclose = function(e){onclose(e)}
	websocket.onmessage = function(e){onmessage(e)}
	websocket.onerror = function(e){onerror(e)}
}

//메소드
function onopen(e){alert(e)}
function onclose(e){alert(e)}

function send(){
	let msg = {
		from : mid ,
		content : document.querySelector('.msgbox').value,
		date : new Date().toLocaleTimeString()
	}
	websocket.send(JSON.stringify(msg)) //JSON으로 변환
	document.querySelector('.msgbox').value='';
}

function onmessage(e){
	let msg = JSON.parse(e.data);
	console.log(msg)
	let contentbox = document.querySelector('.contentbox')
	let html= '<div>'+msg.from+" : "+msg.content+"  :  "+msg.date+'</div>';
	contentbox.innerHTML+=html;
}
function onerror(e){alert(e)}
 
//메소드를 소켓에 대입


