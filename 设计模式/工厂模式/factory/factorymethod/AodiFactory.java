package factory.factorymethod;

public class AodiFactory implements CarFactory {

	@Override
	public Car createCar() {
		// TODO �Զ����ɵķ������
		return new Aodi();
	}

}
