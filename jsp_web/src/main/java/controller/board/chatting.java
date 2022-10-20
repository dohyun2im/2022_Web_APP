package controller.board;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

//@WebServlet("/chatting")
@ServerEndpoint("/chatting/{mid}")
public class chatting{
	//클라이언트소켓 명단
	public static Hashtable<Session , String> clients = new Hashtable<>();
	
	@OnOpen //서버웹소켓 들어옴
	public void onOpen(Session session , @PathParam("mid") String mid) throws IOException {
		System.out.println("세션값: "+ session);
		clients.put(session,mid);//접속된 세션 아이디 저장
		for(Session s : clients.keySet()) {
			s.getBasicRemote().sendText(clients.get(s)+"님이 접속했습니다.");
		}
	}
	
	@OnClose //서버웹소켓 나감 -- 닫기요청시 , 서버재부팅시 , 새로고침시
	public void onClose(Session session) {
		clients.remove(session);
	}
	
	@OnMessage //메시지 들어옴
	public void onMessage(Session session , String msg) throws IOException {
		for(Session s: clients.keySet()) {
			s.getBasicRemote().sendText(msg);
		}
	}
}
