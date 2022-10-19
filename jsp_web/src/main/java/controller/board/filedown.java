package controller.board;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/filedown")
public class filedown extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public filedown() {super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//업로드된 파일을 다운로드하기.
		request.setCharacterEncoding("UTF-8");
		String bfile = request.getParameter("bfile");
		//String uploadpath = "C:\\Users\\504\\git\\2022_Web_APP\\jsp_web\\src\\main\\webapp\\upload\\"+bfile;
		String uploadpath = request.getSession().getServletContext().getRealPath("/upload/"+bfile);
		//파일의 객체화
		File file = new File(uploadpath);
		//HTTP에서 지원하는 다운로드메소드
		response.setHeader("Content-Disposition", //다운로드 형식
				"attachment;filename="+URLEncoder.encode(bfile,"UTF-8") //파일명
				);
		//파일을 바이트로 변환
		BufferedInputStream fin = new BufferedInputStream(new FileInputStream(file));
		//파일길이만큼 배열선언
		byte[] bytes = new byte[(int)file.length()];
		//파일내용을 바이트로 읽어오기
		fin.read(bytes);
		//외부로 내보내기위한 방법
		BufferedOutputStream fout = new BufferedOutputStream(response.getOutputStream());
		//실제출력
		fout.write(bytes);
		fout.flush();
		fin.close();
		fout.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
