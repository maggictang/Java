package singleton;

import java.io.Serializable;

/**
 * ����ģʽ������ʽ
 */
@SuppressWarnings("serial")
public class Lazy implements Serializable{
	/**
	 * һ��ʼ������ʵ��
	 */
	private static Lazy lazy;
	
	private Lazy() {
		//��ֹ���÷��䴴��ʵ�� 
		if(lazy != null) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ��ͬ������֤���߳�ͬʱ���ʸ÷���֮����һ��ʵ��
	 * ���磺
	 * A�߳��ж���lazyΪ�պ�A�̹߳���
	 * B�̵߳��ø÷������ж�lazyΪ�պ󣬴������ʵ����B�̹߳���
	 * ֮��A�̼߳���ִ�У��ִ�����һ��ʵ������������ʵ������������
	 */
	public static synchronized Lazy getInstance() {
		if(lazy == null) {
			lazy = new Lazy();
		}
		return lazy;
	}
	/**
	 * �����л�ʱ���Զ����ø÷����������Ͳ����ڷ����л�ʱ������һ������
	 */
	private Object readResolve() {
		return lazy;	
	}
}
