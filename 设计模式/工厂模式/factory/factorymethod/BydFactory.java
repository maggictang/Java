package factory.factorymethod;

public class BydFactory implements CarFactory {

	@Override
	public Car createCar() {
		// TODO �Զ����ɵķ������
		return new Byd();
	}

}
