package prototype.shallowclones;
/**
 * 浅克隆
 * @author Administrator
 *
 */
public class Sheep implements Cloneable {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO 自动生成的方法存根
		return super.clone();//最早使用clone方法的是object类，这个类是所有类的父类，在重写方法时调用父类方法肯定用super了，
						    //this是本身，但子类本身没有clone方法，是从父类object继承的。
	
	}

	public Sheep(String string) {
		// TODO 自动生成的构造函数存根
		this.name = string;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Sheep s1 = new Sheep("少利");
		System.out.println(s1);
		System.out.println(s1.name);
		
		Sheep s2 = (Sheep) s1.clone();
		System.out.println(s2); //两个对象不一样
		System.out.println(s2.name); //但两个对象的值一样
		s2.setName("多利");//可以修改对象的值
	}

}
