package singleton;

import java.io.Serializable;

/**
 * 单例模式：懒汉式
 */
@SuppressWarnings("serial")
public class Lazy implements Serializable{
	/**
	 * 一开始不创建实例
	 */
	private static Lazy lazy;
	
	private Lazy() {
		//防止利用反射创建实例 
		if(lazy != null) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 加同步锁保证多线程同时访问该方法之创建一个实例
	 * 例如：
	 * A线程判断完lazy为空后，A线程挂起
	 * B线程调用该方法，判断lazy为空后，创建类的实例，B线程挂起
	 * 之后A线程继续执行，又创建了一个实例，但是这样实例九游两个了
	 */
	public static synchronized Lazy getInstance() {
		if(lazy == null) {
			lazy = new Lazy();
		}
		return lazy;
	}
	/**
	 * 反序列化时会自动调用该方法，这样就不会在反序列化时又生成一个对象
	 */
	private Object readResolve() {
		return lazy;	
	}
}
