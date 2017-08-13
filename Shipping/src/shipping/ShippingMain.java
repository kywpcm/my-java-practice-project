package shipping;

import shipping.domain.Company;
import shipping.domain.RiverBarge;
import shipping.domain.Truck;
import shipping.report.FuelNeedsReport;

public class ShippingMain {

	public static void main(String[] args) {

		//�̱�������
		Company company = Company.getInstance();
		
		//��ۼ��� �߰�
		//���� Ŭ������ �޴´�..
		//������ ���� �׿� �°�..
		company.addVehicle(new Truck(10000.0, "Truck1"));
		company.addVehicle(new Truck(15000.0, "Truck2"));
		company.addVehicle(new RiverBarge(500000.0, "RiverBarge1"));
		company.addVehicle(new Truck(9500.0, "Truck3"));
		company.addVehicle(new RiverBarge(750000.0, "RiverBarge2"));
		
		//����ϴ� ��ü
		//���⼭ ����Ʈ�� �����;� ��..
		FuelNeedsReport report = new FuelNeedsReport();
		report.generateText(System.out);  //���⼭ ���
		
	}

}
