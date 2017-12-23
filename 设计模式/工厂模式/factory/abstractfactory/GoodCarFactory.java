package factory.abstractfactory;

public class GoodCarFactory implements CarFactory {

	@Override
	public Engine createEngine() {
		// TODO 自动生成的方法存根
		return new GoodEngine();
	}

	@Override
	public Seat createSeat() {
		// TODO 自动生成的方法存根
		return new GoodSeat();
	}

	@Override
	public Tyre createTyre() {
		// TODO 自动生成的方法存根
		return new GoodTyre();
	}
	
}
