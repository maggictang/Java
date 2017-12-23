package factory.abstractfactory;

public interface Tyre {
	void revolve();
}

class GoodTyre implements Tyre {

	@Override
	public void revolve() {
		System.out.println("�õ���̥�õľ�");	
	}
	
}

class BadTyre implements Tyre {

	@Override
	public void revolve() {
		System.out.println("�����̥�ò���");	
	}
	
}