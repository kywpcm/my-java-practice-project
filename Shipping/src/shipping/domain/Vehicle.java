package shipping.domain;

public abstract class Vehicle {

	String name;

	Vehicle(String name) {
		this.name = name;
	}

	protected abstract double calcTripDistance();
	protected abstract double calcFuelEfficiency();

	public final double calcFuelNeeds() {  //template method..
		return calcTripDistance() / calcFuelEfficiency();
	}

	public String getName() {
		return name;
	}

}
