import java.io.IOException;
import java.net.*;

public class Server {
	/**
	 * ��־λ���жϷ������Ƿ�����
	 */
	private boolean isRun = false;
	private ServerSocket ss;
	
	public Server() {
		            
	}
	public static void main(String[] args) throws IOException {
		new Server().start();    //�������������󣬵�������������
	}
	/**
	 * ��������
	 */
	public void start() throws IOException {
		isRun = true;           //�������������ѱ�־λ��Ϊtrue
		ss = new ServerSocket(8080);    //����8080�˿ڼ����ͻ�������
		while(isRun) {
			recive();     //��ͣ�ؼ����ͽ��տͻ�������
		}
	}
	/**
	 * ���տͻ�������
	 */
	public void recive() throws IOException {
		Socket s = ss.accept(); 
		new Thread(new Dispatcher(s)).start();     //ÿ���ܵ�һ������ʹ���һ��Dispatcher�̴߳�������
	}
}
