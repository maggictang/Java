package factory.abstractfactory;

public interface Tyre {
	void revolve();
}

class GoodTyre implements Tyre {

	@Override
	public void revolve() {
		System.out.println("好的轮胎用的久");	
	}
	
}

class BadTyre implements Tyre {

	@Override
	public void revolve() {
		System.out.println("差的轮胎用不久");	
	}
	
}