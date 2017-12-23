package singleton;
/**
 * ����ģʽ����̬�ڲ���ʽ
 */
public class StaticInner {
	/**
	 * ��̬�ڲ��಻���ټ����ⲿ���ʱ�����
	 */
	private static class Inner {
		private static StaticInner si = new StaticInner();
	}
	/**
	 * ���ø÷�����ʱ��Ż���ؾ�̬�ڲ��ഴ������
	 */
	public static StaticInner getInstance() {
		return Inner.si;
	}
	/**
	 * ������˽�л�
	 */
	private StaticInner() {
		
	}
}
