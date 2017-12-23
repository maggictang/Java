package prototype.deepclones;

import java.util.Date;

/**
 * ���¡
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
		// TODO �Զ����ɵķ������
		Sheep s = (Sheep) super.clone();
		s.birthday = (Date) this.birthday.clone();
		return s;
	}

	public Sheep(String string) {
		// TODO �Զ����ɵĹ��캯�����
		this.name = string;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Sheep s1 = new Sheep("����");
		System.out.println(s1);
		System.out.println(s1.name);
		
		Sheep s2 = (Sheep) s1.clone();
		System.out.println(s2); //��������һ��
		System.out.println(s2.name); //�����������ֵһ��
		s2.setName("����");//�����޸Ķ����ֵ
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
