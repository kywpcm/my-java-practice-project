package shipping.domain;

import java.util.ArrayList;

public class Company {

	private static Company instance = new Company();
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	private Company() {}
	
	public static Company getInstance() {
		if(instance == null) {
			instance = new Company();
		}
		return instance;
	}
	
	public void addVehicle(Vehicle vehicle) {  //polymorphism..
		vehicles.add(vehicle);
	}

	public Vehicle getVehicle(int index) {  //polymorphism..
		return vehicles.get(index);
	}
	
	public int getFleetSize() {
		return vehicles.size();
	}

}
