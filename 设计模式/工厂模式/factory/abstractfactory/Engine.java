package factory.abstractfactory;

public interface Engine {
	void start();
	void run();
}

class GoodEngine implements Engine {

	@Override
	public void start() {
		System.out.println("�õ�����������");		
	}

	@Override
	public void run() {
		System.out.println("�õ������ܵÿ�");		
	}
	
}

class BadEngine implements Engine {

	@Override
	public void start() {
		System.out.println("�������������");
	}

	@Override
	public void run() {
		System.out.println("��������ܵ���");		
	}
	
}