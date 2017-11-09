/**
 * Set�� �����ϴ� �׸��� ������ �߰��� �� �ְ� ��������, �׸��� ã�� ���ؼ��� �׸� ���� ��Ȯ�� ���纻�� ������ �־�� �Ѵ�.
 * �̰��� �ڹٿ��� ����ϰ� �ִ� �Ϲ����� ������ �ƴϴ�.
 * Ű ������ ������ ������ �׸��� ������ �ʿ䰡 �����. ���� ���, �����ͺ��̽�ó�� ���̴�.
 * Map �ڷᱸ���� �̷��� ����� �����ϱ� ���Ͽ� Ű/�� ���� �����ϰ� ������, Ű�� ������ ������ �̿� �ش��ϴ� ���� ã�� �� �ֵ��� �����Ǿ� �ִ�.
 * ���� ���, �����ͺ��̽����� ����� ID�� ������, �̿� �ش��ϴ� ������� �Ż������� �ڷῡ ���� ���ڵ�� ����� �� �ִ� �Ͱ� ����. 
 */

package treemap;

//client
//Use a AccountManagementTreeMap class
public class AccountHashMapTest {

	public static void main(String[] args) {

		AccountManagementTreeMap manager = new AccountManagementTreeMap();
		
		//����� sorting �Ǽ� ���̰�..
		manager.insertAccount(25000, new AccountNumber("1236"), "percy");
		manager.insertAccount(15000, new AccountNumber("1234"), "james");
		manager.insertAccount(35000, new AccountNumber("1237"), "edward");
		manager.insertAccount(55000, new AccountNumber("1235"), "tomas");
		manager.insertAccount(45000, new AccountNumber("1238"), "andrew");
		
		manager.setDeposit(5000, new AccountNumber("1234"));
		manager.setDeposit(5000, new AccountNumber("1235"));
		manager.setDeposit(5000, new AccountNumber("1236"));
		manager.setDeposit(5000, new AccountNumber("1237"));
		manager.setDeposit(5000, new AccountNumber("1238"));
		
		manager.accountAllDisplay();
		
	}

}
