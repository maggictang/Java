package builderpattern;
/**
 * 宇宙飞船
 * @author Administrator
 *
 */
public class AirShip {
	
	private Engine engine;
	private TrackCabin trackcabin;
	private EscapeTower escapetower;

	public AirShip() {
		super();
		// TODO 自动生成的构造函数存根
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
 * 发动机
 * @author Administrator
 *
 */
class Engine {

	public Engine() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
}
/**
 * 轨道舱
 * @author Administrator
 *
 */
class TrackCabin {

	public TrackCabin() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
}
/**
 * 逃逸塔
 * @author Administrator
 *
 */
class EscapeTower {

	public EscapeTower() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
}