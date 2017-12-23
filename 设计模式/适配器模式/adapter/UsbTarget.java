package adapter;
/**
 * usb接口
 * @author Administrator
 *
 */
public interface UsbTarget {
	/**
	 * 处理接收键盘的字符串，将其打印到电脑上
	 */
	public void handleType(String str);

}
