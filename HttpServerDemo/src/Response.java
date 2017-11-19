import java.io.*;
import java.net.Socket;
import java.util.Date;

public class Response {
	private StringBuilder head;
	private StringBuilder content;
	private static final String CRCF = "\r\n";
	private static final String BLANK = " ";
	private int len;
	BufferedWriter bw;
	

	public Response(Socket s) throws IOException {
		bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		head = new StringBuilder();
		content = new StringBuilder();
	}
	
	public void createHead(int code) {
		head.append("HTTP/1.1").append(BLANK);
		head.append(code).append(BLANK);
		switch(code) {
		case 200: head.append("OK").append(CRCF); break;
		case 404: head.append("Not Found").append(CRCF); break;
		case 500: head.append("Server Error").append(CRCF); break;	
		}
		head.append(new Date()).append(CRCF);
		head.append("Content-type:text/html;charset:utf-8").append(CRCF);
		head.append("Content-Length:" + len).append(CRCF);
		head.append(CRCF);		
	}
	
	public void print(String str) {
		content.append(str);
		len += str.getBytes().length;
	}
	
	public void println(String str) {
		content.append(str).append(CRCF);
		len += (str+CRCF).getBytes().length;
	}
	
	public void pushToClient(int code) throws IOException {
		createHead(code);
		bw.append(head);
		bw.append(content);
		bw.flush();
		//bw.close();
	}

}
