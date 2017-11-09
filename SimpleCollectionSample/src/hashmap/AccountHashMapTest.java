/**
 * Set은 존재하는 항목을 빠르게 발견할 수 있게 해주지만, 항목을 찾기 위해서는 항목에 대한 정확한 복사본을 가지고 있어야 한다.
 * 이것은 자바에서 사용하고 있는 일반적인 참조가 아니다.
 * 키 정보를 가지고 연관된 항목을 참조할 필요가 생겼다. 예를 들면, 데이터베이스처럼 말이다.
 * Map 자료구조는 이러한 기능을 제공하기 위하여 키/값 쌍을 저장하고 있으며, 키를 가지고 있으면 이에 해당하는 값을 찾을 수 있도록 구성되어 있다.
 * 예를 들면, 데이터베이스에서 고용자 ID를 가지고, 이에 해당하는 고용자의 신상정보를 자료에 대한 레코드로 사용할 수 있는 것과 같다.
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
