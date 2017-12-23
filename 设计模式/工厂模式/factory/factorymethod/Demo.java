package factory.factorymethod;

public class Demo {
	public static void main(String[] args) {
		Car c1 = new BydFactory().createCar();
		Car c2 = new AodiFactory().createCar();
		
		c1.run();
		c2.run();
	}
}
