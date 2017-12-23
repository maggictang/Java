package adapter;
/**
 * 适配器需要实现服务提供者的功能
 * @author Administrator
 *
 */
public class Adapter implements UsbTarget {

	@Override
	public void handleType(String str) {
		System.out.println(str);
		
	}
}
