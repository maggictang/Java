package singleton;
/**
 * ����ʽ���������ʱ��ʹ�����ʵ��
 */
public class Hungry {
	private static Hungry hungry = new Hungry();
	
	/**
	 * ������˽�л�����֤����
	 */
	private Hungry() {
		
	}               
	/**
	 * �ṩһ�������ķ�����ø����ʵ����static���θ÷����������أ�����new Hungry()�����ø÷���
	 */
	public static Hungry getInstance() { 
		return hungry;
	}
	
}
