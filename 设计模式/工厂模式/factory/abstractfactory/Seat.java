package factory.abstractfactory;

public interface Seat {
	void massage();
}

class GoodSeat implements Seat {

	@Override
	public void massage() {
		System.out.println("�õ������������");
	}
	
}

class BadSeat implements Seat {

	@Override
	public void massage() {
		System.out.println("����������������");
	}
	
}