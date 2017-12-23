package factory.simplefactory;

public class SimpleFactory {
	public static void main(String[] args) {
		Car c1 = Factory.createCar("奥迪");
		Car c2 = Factory.createCar("比亚迪");
		
		c1.run();
		c2.run();
	}
}

class Factory {
	public static Car createCar(String type) {
		if("比亚迪".equals(type)) {
			return new Byd();
		}
		else if("奥迪".equals(type)) {
			return new Aodi();
		}
		else {
			return null;
		}
	}
	
	public static Car createAodi() {
		return new Aodi();
	}
	
	public static Car createByd() {
		return new Byd();
	}
}