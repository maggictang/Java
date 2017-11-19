import java.io.IOException;
import java.net.*;

public class Server {
	/**
	 * 标志位，判断服务器是否启动
	 */
	private boolean isRun = false;
	private ServerSocket ss;
	
	public Server() {
		            
	}
	public static void main(String[] args) throws IOException {
		new Server().start();    //创建服务器对象，调用其启动方法
	}
	/**
	 * 启动方法
	 */
	public void start() throws IOException {
		isRun = true;           //服务器启动，把标志位置为true
		ss = new ServerSocket(8080);    //创建8080端口监听客户端请求
		while(isRun) {
			recive();     //不停地监听和接收客户端请求
		}
	}
	/**
	 * 接收客户端请求
	 */
	public void recive() throws IOException {
		Socket s = ss.accept(); 
		new Thread(new Dispatcher(s)).start();     //每接受到一个请求就创建一个Dispatcher线程处理请求
	}
}
