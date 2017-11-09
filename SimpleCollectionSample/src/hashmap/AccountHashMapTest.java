/**
 * Set�� �����ϴ� �׸��� ������ �߰��� �� �ְ� ��������, �׸��� ã�� ���ؼ��� �׸� ���� ��Ȯ�� ���纻�� ������ �־�� �Ѵ�.
 * �̰��� �ڹٿ��� ����ϰ� �ִ� �Ϲ����� ������ �ƴϴ�.
 * Ű ������ ������ ������ �׸��� ������ �ʿ䰡 �����. ���� ���, �����ͺ��̽�ó�� ���̴�.
 * Map �ڷᱸ���� �̷��� ����� �����ϱ� ���Ͽ� Ű/�� ���� �����ϰ� ������, Ű�� ������ ������ �̿� �ش��ϴ� ���� ã�� �� �ֵ��� �����Ǿ� �ִ�.
 * ���� ���, �����ͺ��̽����� ����� ID�� ������, �̿� �ش��ϴ� ������� �Ż������� �ڷῡ ���� ���ڵ�� ����� �� �ִ� �Ͱ� ����.
 */

package hashmap;

//client
//Use a AccountManagementHashMap class
public class AccountHashMapTest {

	public static void main(String[] args) {

		AccountManagementHashMap manager = new AccountManagementHashMap();
		
		manager.insertAccount(35000, "1237", "percy");
		manager.insertAccount(15000, "1234", "james");
		manager.insertAccount(45000, "1236", "edward");
		manager.insertAccount(25000, "1238", "tomas");
		manager.insertAccount(55000, "1235", "andrew");
		
		manager.setDeposit(5000, "1234");
		manager.setDeposit(5000, "1235");
		manager.setDeposit(5000, "1236");
		manager.setDeposit(5000, "1237");
		manager.setDeposit(5000, "1238");
		
		manager.accountAllDisplay();
		
	}

}
