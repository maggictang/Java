package builderpattern;
/**
 * ����ɴ�
 * @author Administrator
 *
 */
public class AirShip {
	
	private Engine engine;
	private TrackCabin trackcabin;
	private EscapeTower escapetower;

	public AirShip() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}
	
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public TrackCabin getTrackcabin() {
		return trackcabin;
	}
	public void setTrackcabin(TrackCabin trackcabin) {
		this.trackcabin = trackcabin;
	}
	public EscapeTower getEscapetower() {
		return escapetower;
	}
	public void setEscapetower(EscapeTower escapetower) {
		this.escapetower = escapetower;
	}
		
}
/**
 * ������
 * @author Administrator
 *
 */
class Engine {

	public Engine() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}
	
}
/**
 * �����
 * @author Administrator
 *
 */
class TrackCabin {

	public TrackCabin() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}
	
}
/**
 * ������
 * @author Administrator
 *
 */
class EscapeTower {

	public EscapeTower() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}
	
}