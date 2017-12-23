package adapter;
/**
 * µçÄÔ
 * @author Administrator
 *
 */
public class Clinet {
	public static void main(String[] args) {
		UsbTarget t = new Adapter(); 
		t.handleType(new KeyBoard().type());
	}
} 
