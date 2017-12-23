package factory.abstractfactory;

public interface Engine {
	void start();
	void run();
}

class GoodEngine implements Engine {

	@Override
	public void start() {
		System.out.println("好的引擎启动快");		
	}

	@Override
	public void run() {
		System.out.println("好的引擎跑得快");		
	}
	
}

class BadEngine implements Engine {

	@Override
	public void start() {
		System.out.println("差的引擎启动慢");
	}

	@Override
	public void run() {
		System.out.println("差的引擎跑得慢");		
	}
	
}