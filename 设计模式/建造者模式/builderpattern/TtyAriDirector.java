package builderpattern;

public class TtyAriDirector implements AirDirector {
	private TtyAriBuilder builder;
	
	public TtyAriDirector(TtyAriBuilder builder) {
		super();
		this.builder = builder;
	}
	
	@Override
	public AirShip directAriShip() {
		Engine e = builder.createEngine();
		EscapeTower et = builder.createEscapeTower();
		TrackCabin tc = builder.createTrackCabin();
		
		AirShip ship = new AirShip();
		ship.setEngine(e);
		ship.setEscapetower(et);
		ship.setTrackcabin(tc);
		
		return ship;
		
	}

	

}
