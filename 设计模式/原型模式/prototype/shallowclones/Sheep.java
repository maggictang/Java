package prototype.shallowclones;
/**
 * ǳ��¡
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
		// TODO �Զ����ɵķ������
		return super.clone();//����ʹ��clone��������object�࣬�������������ĸ��࣬����д����ʱ���ø��෽���϶���super�ˣ�
						    //this�Ǳ��������౾��û��clone�������ǴӸ���object�̳еġ�
	
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

}
