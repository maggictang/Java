package factory.factorymethod;

public class BydFactory implements CarFactory {

	@Override
	public Car createCar() {
		// TODO 自动生成的方法存根
		return new Byd();
	}

}
