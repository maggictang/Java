package proxy.staticProxy;
/**
 * �����ˣ�����
 * @author Administrator
 *
 */
public class ProxyStar implements Transaction {
	/**
	 * ����Ľ�ɫ
	 */
	private Star star;
	
	public ProxyStar(Star star) {
		this.star = star;
	}
	
	@Override
	public void conder() {
		// TODO �Զ����ɵķ������
		System.out.println("��������̸");
	}

	@Override
	public void signContract() {
		// TODO �Զ����ɵķ������
		System.out.println("������ǩԼ");
	}

	@Override
	public void bookTicket() {
		// TODO �Զ����ɵķ������
		System.out.println("�����˶�Ʊ");
	}

	@Override
	public void sing() {
		// TODO �Զ����ɵķ������
		star.sing();
	}

	@Override
	public void colletMoney() {
		// TODO �Զ����ɵķ������
		System.out.println("��������β��");
	}
	
}
