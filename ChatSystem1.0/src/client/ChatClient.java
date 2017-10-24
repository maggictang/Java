package client;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;



public class ChatClient extends Frame {

	private static final long serialVersionUID = 1L;
	//创建一个输入文本框
	TextField tf = new TextField();
	//创建一个显示文本框
	TextArea ta = new TextArea();
	//创建一个Socket
	Socket socket = null;
	//创建一个输出流
	DataOutputStream dos = null;
	//创建一个输入流
	DataInputStream dis = null;
	/**
	 * 构造器
	 * @param title 客户端标题名
	 */
	public ChatClient(String title) {
		super(title);
	}
	
	/**
	 * 初始化方法
	 */
	private void initFrame() {
		//设置窗体大小和位置
		this.setBounds(300, 300, 500, 300);
		//点击关闭退出程序
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				disConnect();
				System.exit(0);
			}		
		});
		addText();
		this.setVisible(true);
		connect();
		new Thread(new reciveMsg()).start();
	}
	
	/**
	 * 添加文本框
	 */
	public void addText() {
		//把两个文本框添加进窗体里
		this.add(tf,BorderLayout.SOUTH);
		this.add(ta,BorderLayout.NORTH);
		pack();
		//为输入文本框添加一个事件监听器,敲击回车事件发生
		tf.addActionListener(new TextFieldListener());
		//让窗体可见
	}
	
	/**
	 * 与服务器连接
	 */
	private void connect() {
		try {
			socket = new Socket("127.0.0.1",8080);
			System.out.println("连接上服务器");
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 事件监听，监听输入文本框敲击回车事件
	 */
	private class TextFieldListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//获得输入文本框的字符串
			String msg = tf.getText();
			//让字符串在显示文本框显示
			//ta.setText(msg);
			//清空输入文本框的内容
			tf.setText("");
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}		
	}
	
	/**
	 * 与服务器关闭连接
	 */
	public void disConnect() {
		try {
			dos.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	class reciveMsg implements Runnable {
		@Override
		public void run() {
			try {
				dis = new DataInputStream(socket.getInputStream());
			} catch (IOException e1) {
				e1.printStackTrace();
			} 
			while(true) {
				try {
					String msg = dis.readUTF();
					ta.setText(ta.getText() + msg + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}	
		}	
	}

	public static void main(String[] args) {
		new ChatClient("WeChat").initFrame();
	}
}
