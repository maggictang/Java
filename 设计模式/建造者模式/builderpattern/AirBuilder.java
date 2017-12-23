package builderpattern;
/**
 * 创建组件的接口
 * 用来创建飞船的各个组件
 * @author Administrator
 *
 */
public interface AirBuilder {
	Engine createEngine();
	TrackCabin createTrackCabin();
	EscapeTower createEscapeTower();
}
