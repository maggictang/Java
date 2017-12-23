package builderpattern;
/**
 * 构造唐天友牌的组件
 * @author Administrator
 *
 */
public class TtyAriBuilder implements AirBuilder{

	@Override
	public Engine createEngine() {
		// TODO 自动生成的方法存根
		System.out.println("创建了发动机");
		return new Engine();
	}

	@Override
	public TrackCabin createTrackCabin() {
		// TODO 自动生成的方法存根
		System.out.println("创建了轨道舱");
		return new TrackCabin();
	}

	@Override
	public EscapeTower createEscapeTower() {
		// TODO 自动生成的方法存根
		System.out.println("创建了逃逸塔");
		return new EscapeTower();
	}

}
