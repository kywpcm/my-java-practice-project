package shipping.domain;

public class Truck extends Vehicle {

	private final double FUEL_EFFICIENCY_OF_TRUCK = 10.0;
	
	private double mMaxLoad;
	
	public Truck(double maxLoad, String name) {
		super(name);
		this.mMaxLoad = maxLoad;
	}
	
	@Override
	public double calcTripDistance() {
		return mMaxLoad;
	}
	
	@Override
	public double calcFuelEfficiency() {
		return FUEL_EFFICIENCY_OF_TRUCK;
	}
	
}
