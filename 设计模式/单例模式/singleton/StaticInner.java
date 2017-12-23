package singleton;
/**
 * 单例模式：静态内部类式
 */
public class StaticInner {
	/**
	 * 静态内部类不会再加载外部类的时候加载
	 */
	private static class Inner {
		private static StaticInner si = new StaticInner();
	}
	/**
	 * 调用该方法的时候才会加载静态内部类创建对象
	 */
	public static StaticInner getInstance() {
		return Inner.si;
	}
	/**
	 * 构造器私有化
	 */
	private StaticInner() {
		
	}
}
