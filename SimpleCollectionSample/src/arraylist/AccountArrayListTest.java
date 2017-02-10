/**
 * 크기가 변하는(삽입, 삭제) 순차 리스트를 요구할 때, 배열과 같은 순차적인 표현은 부적당하다.
 * 따라서 각각의 노드들의 연결로서 이루어져 있는 리스트 구조가 필요하게 되었다.
 ************************ArrayList************************
 * 요소들을 무작위로 액세스 하는데 탁월하다.
 * List 중간에 요소들을 추가하거나 삭제할 때는 느림
 */

package arraylist;

//client..
//Use a AccountManagementArrayList class..
public class AccountArrayListTest {

	public static void main(String[] args) {

		AccountManagementArrayList manager = new AccountManagementArrayList();
		manager.insertAccount(15000, "1234_1", "james");
		manager.insertAccount(25000, "1234_2", "tomas");
		manager.insertAccount(35000, "1234_3", "percy");
		manager.insertAccount(45000, "1234_4", "edward");
		
		manager.setDeposit(5000, "1234_1");
		manager.setDeposit(5000, "1234_2");
		manager.setDeposit(5000, "1234_3");
		
		manager.accountAllDisplay();
		
	}

}
