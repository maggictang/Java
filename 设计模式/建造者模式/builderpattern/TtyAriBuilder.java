package builderpattern;
/**
 * �����������Ƶ����
 * @author Administrator
 *
 */
public class TtyAriBuilder implements AirBuilder{

	@Override
	public Engine createEngine() {
		// TODO �Զ����ɵķ������
		System.out.println("�����˷�����");
		return new Engine();
	}

	@Override
	public TrackCabin createTrackCabin() {
		// TODO �Զ����ɵķ������
		System.out.println("�����˹����");
		return new TrackCabin();
	}

	@Override
	public EscapeTower createEscapeTower() {
		// TODO �Զ����ɵķ������
		System.out.println("������������");
		return new EscapeTower();
	}

}
