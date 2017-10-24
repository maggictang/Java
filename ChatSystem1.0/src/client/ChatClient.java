package client;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;



public class ChatClient extends Frame {

	private static final long serialVersionUID = 1L;
	//����һ�������ı���
	TextField tf = new TextField();
	//����һ����ʾ�ı���
	TextArea ta = new TextArea();
	//����һ��Socket
	Socket socket = null;
	//����һ�������
	DataOutputStream dos = null;
	//����һ��������
	DataInputStream dis = null;
	/**
	 * ������
	 * @param title �ͻ��˱�����
	 */
	public ChatClient(String title) {
		super(title);
	}
	
	/**
	 * ��ʼ������
	 */
	private void initFrame() {
		//���ô����С��λ��
		this.setBounds(300, 300, 500, 300);
		//����ر��˳�����
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
	 * ����ı���
	 */
	public void addText() {
		//�������ı�����ӽ�������
		this.add(tf,BorderLayout.SOUTH);
		this.add(ta,BorderLayout.NORTH);
		pack();
		//Ϊ�����ı������һ���¼�������,�û��س��¼�����
		tf.addActionListener(new TextFieldListener());
		//�ô���ɼ�
	}
	
	/**
	 * �����������
	 */
	private void connect() {
		try {
			socket = new Socket("127.0.0.1",8080);
			System.out.println("�����Ϸ�����");
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �¼����������������ı����û��س��¼�
	 */
	private class TextFieldListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//��������ı�����ַ���
			String msg = tf.getText();
			//���ַ�������ʾ�ı�����ʾ
			//ta.setText(msg);
			//��������ı��������
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
	 * ��������ر�����
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
