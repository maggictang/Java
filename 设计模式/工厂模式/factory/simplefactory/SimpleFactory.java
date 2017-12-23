package factory.simplefactory;

public class SimpleFactory {
	public static void main(String[] args) {
		Car c1 = Factory.createCar("�µ�");
		Car c2 = Factory.createCar("���ǵ�");
		
		c1.run();
		c2.run();
	}
}

class Factory {
	public static Car createCar(String type) {
		if("���ǵ�".equals(type)) {
			return new Byd();
		}
		else if("�µ�".equals(type)) {
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