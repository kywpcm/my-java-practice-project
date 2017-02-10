package shipping.domain;

public class RiverBarge extends Vehicle {

	private final double FUEL_EFFICIENCY_OF_RIVERBARGE = 20.0;
	
	private double mMaxLoad;
	
	public RiverBarge(double maxLoad, String name) {
		super(name);
		this.mMaxLoad = maxLoad;
	}

	@Override
	public double calcTripDistance() {
		return mMaxLoad;
	}
	
	@Override
	public double calcFuelEfficiency() {
		return FUEL_EFFICIENCY_OF_RIVERBARGE;
	}

}
