package adapter;
/**
 * ��������Ҫʵ�ַ����ṩ�ߵĹ���
 * @author Administrator
 *
 */
public class Adapter implements UsbTarget {
	
	KeyBoard kb = new KeyBoard();
	
	@Override
	public void handlePrint() {
		// TODO �Զ����ɵķ������
		kb.print();
	}

}
