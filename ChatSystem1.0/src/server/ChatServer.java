package server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ChatServer {

	ServerSocket sSocket = null;
	//用一个集合类装连接进来的客户端
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
		 * 把发送来服务器的消息发送给其他客户端
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
		//用户数
		int num = 0;
		try {
			sSocket = new ServerSocket(8080);
			while(true) {
				Socket socket = sSocket.accept();
				System.out.println("一个客户端连接上");
				num++;
				ManageClient cs = new ManageClient(socket);
				new Thread(cs,"用户" + num + ":").start();
				clients.add(cs);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				sSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new ChatServer().start();

	}
}	
