package factory.simplefactory;
/**
 * 没有工厂模式
 * 调用者和创建者是同一个类
 */
public class NoFactory {
	public static void main(String[] args) {
		Car c1 = new Aodi();
		Car c2 = new Byd();
		
		c1.run();
		c2.run();		
	}
}
