package factory.abstractfactory;

public class GoodCarFactory implements CarFactory {

	@Override
	public Engine createEngine() {
		// TODO �Զ����ɵķ������
		return new GoodEngine();
	}

	@Override
	public Seat createSeat() {
		// TODO �Զ����ɵķ������
		return new GoodSeat();
	}

	@Override
	public Tyre createTyre() {
		// TODO �Զ����ɵķ������
		return new GoodTyre();
	}
	
}
