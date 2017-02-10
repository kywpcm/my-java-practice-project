package shipping.report;

import java.io.PrintStream;

import shipping.domain.Company;
import shipping.domain.RiverBarge;
import shipping.domain.Truck;
import shipping.domain.Vehicle;

public class FuelNeedsReport {
	
	public void generateText(PrintStream output) {
		
		Company company = Company.getInstance();
		Vehicle vehicle;
		
		double fuel;
		double total_fuel = 0.0;
		
		for(int i = 0; i < company.getFleetSize(); i++) {
			
			vehicle = company.getVehicle(i);
			
			fuel = vehicle.calcFuelNeeds();  //template method È£Ãâ
			output.println("Vehicle " + vehicle.getName() + " needs " + fuel + " liters of fuel,");
//			if(vehicle instanceof Truck) {
//				output.println("Vehicle " + ((Truck) vehicle).getName() + " needs " + fuel + " liters of fuel,");
//			} else if(vehicle instanceof RiverBarge) {
//				output.println("Vehicle " + ((RiverBarge) vehicle).getName() + " needs " + fuel + " liters of fuel,");
//			}
			total_fuel = total_fuel + fuel;
		}
		
		output.println();
		output.println("Total fuel needs is " + total_fuel + " liters.");
	}
	
}
