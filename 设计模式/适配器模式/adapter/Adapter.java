package adapter;
/**
 * 适配器需要实现服务提供者的功能
 * @author Administrator
 *
 */
public class Adapter implements UsbTarget {
	
	KeyBoard kb = new KeyBoard();
	
	@Override
	public void handlePrint() {
		// TODO 自动生成的方法存根
		kb.print();
	}

}
