package builderpattern;
/**
 * ��������Ľӿ�
 * ���������ɴ��ĸ������
 * @author Administrator
 *
 */
public interface AirBuilder {
	Engine createEngine();
	TrackCabin createTrackCabin();
	EscapeTower createEscapeTower();
}
