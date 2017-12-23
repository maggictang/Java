package factory.abstractfactory;

public interface Seat {
	void massage();
}

class GoodSeat implements Seat {

	@Override
	public void massage() {
		System.out.println("好的椅子坐的舒服");
	}
	
}

class BadSeat implements Seat {

	@Override
	public void massage() {
		System.out.println("坏的椅子坐的难受");
	}
	
}