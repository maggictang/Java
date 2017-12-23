package singleton;
/**
 * 饿汉式：加载类的时候就创建了实例
 */
public class Hungry {
	private static Hungry hungry = new Hungry();
	
	/**
	 * 构造器私有化，保证单例
	 */
	private Hungry() {
		
	}               
	/**
	 * 提供一个公开的方法获得该类的实例，static修饰该方法与该类相关，不用new Hungry()来调用该方法
	 */
	public static Hungry getInstance() { 
		return hungry;
	}
	
}
