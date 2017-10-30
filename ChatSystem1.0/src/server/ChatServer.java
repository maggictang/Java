package server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ChatServer {

	ServerSocket sSocket = null;
	//��һ��������װ���ӽ����Ŀͻ���
	List<ManageClient> clients = new ArrayList<ManageClient>();

	class ManageClient implements Runnable {	
		private Socket socket = null;
		DataInputStream dis = null; 

		public ManageClient(Socket socket) {
			this.socket = socket;
		}
		@Override
		public void run() {
			ManageClient c = null;
			try {	
				dis = new DataInputStream(socket.getInputStream());
				while(true) {
					String msg = dis.readUTF();
					//System.out.println(msg);
					Iterator<ManageClient> it = clients.iterator();
					while(it.hasNext()) {
						c = it.next();
						String name =  Thread.currentThread().getName();
						c.send(name + msg);
					}
				}
			} catch(EOFException e) {
				try {
					dis.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.out.println("һ���û��˳�");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					dis.close();
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		/**
		 * �ѷ���������������Ϣ���͸������ͻ���
		 */
		public void send(String msg) {
			try {
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				dos.writeUTF(msg);
			} catch(SocketException e) {
				clients.remove(this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void start() {
		//�û���
		int num = 0;
		try {
			sSocket = new ServerSocket(8080);
			while(true) {
				Socket socket = sSocket.accept();
				System.out.println("һ���ͻ���������");
				num++;
				ManageClient cs = new ManageClient(socket);
				new Thread(cs,"�û�" + num + ":").start();
				clients.add(cs);
			}
		} catch(BindException  e) {
			System.out.println("�˿��ѱ�ռ�ã����������Ӧ�ã�������������");
			System.exit(-1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ChatServer().start();

	}
}	
