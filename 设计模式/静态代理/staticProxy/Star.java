package proxy.staticProxy;
/**
 * ���Ǳ��ˣ���ʵ��ɫ
 * @author Administrator
 *
 */
public class Star implements Transaction {
	private String name;
	
	public Star(String name) {
		this.name = name;
	}
	@Override
	public void conder() {
		// TODO �Զ����ɵķ������
		System.out.println("���Ǳ�����̸");
	}

	@Override
	public void signContract() {
		// TODO �Զ����ɵķ������
		System.out.println("���Ǳ���ǩԼ");
		
	}

	@Override
	public void bookTicket() {
		// TODO �Զ����ɵķ������
		System.out.println("���Ǳ��˶�Ʊ");
	}

	@Override
	public void sing() {
		// TODO �Զ����ɵķ������
		System.out.println("���Ǳ���"+ this.name + "����");
	}

	@Override
	public void colletMoney() {
		// TODO �Զ����ɵķ������
		System.out.println("���Ǳ�����β��");
	}

}
