package adapter;
/**
 * ��������Ҫʵ�ַ����ṩ�ߵĹ���
 * @author Administrator
 *
 */
public class Adapter implements UsbTarget {

	@Override
	public void handleType(String str) {
		System.out.println(str);
		
	}
}
