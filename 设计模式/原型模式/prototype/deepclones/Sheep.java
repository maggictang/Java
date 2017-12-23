package prototype.deepclones;

import java.util.Date;

/**
 * 深克隆
 * @author Administrator
 *
 */
public class Sheep implements Cloneable {
	private String name;
	private Date birthday;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO 自动生成的方法存根
		Sheep s = (Sheep) super.clone();
		s.birthday = (Date) this.birthday.clone();
		return s;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
