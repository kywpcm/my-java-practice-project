package shipping;

import shipping.domain.Company;
import shipping.domain.RiverBarge;
import shipping.domain.Truck;
import shipping.report.FuelNeedsReport;

public class ShippingMain {

	public static void main(String[] args) {

		//싱글톤으로
		Company company = Company.getInstance();
		
		//운송수단 추가
		//상위 클래스로 받는다..
		//꺼내올 때도 그에 맞게..
		company.addVehicle(new Truck(10000.0, "Truck1"));
		company.addVehicle(new Truck(15000.0, "Truck2"));
		company.addVehicle(new RiverBarge(500000.0, "RiverBarge1"));
		company.addVehicle(new Truck(9500.0, "Truck3"));
		company.addVehicle(new RiverBarge(750000.0, "RiverBarge2"));
		
		//계산하는 객체
		//여기서 리스트를 가져와야 함..
		FuelNeedsReport report = new FuelNeedsReport();
		report.generateText(System.out);  //여기서 계산
	}

}
