/**
 * Set의 가장 일반적인 사용 용도는 멤버쉽, 즉 존재 유무를 확인하는 것이므로 Set 내에 특정 객체가 있는지의 여부를 쉽게 알 수 있다.
 * 이런 이유로 검색이 Set 계열의 가장 중요한 오퍼레이션이며, 일반적으로 HashSet 구현을 사용한다.
 * 빠른 검색에 최적화 되어 있기 때문이다.
 *******************************TreeSet*************************************
 * 트리 구조로 이루어짐
 * 정렬된 결과를 원한다면 HashSet보다 TreeSet을 사용함
 * O(log2n)
 */

package treeset;

//client..
//Use a AccountManagementTreeSet class..
public class AccountTreeSetTest {
	
	public static void main(String[] args) {
		
		AccountManagementTreeSet manager = new AccountManagementTreeSet();
		
		manager.insertAccount(35000, "1234", "percy");
		manager.insertAccount(15000, "1236", "james");
		manager.insertAccount(45000, "1237", "edward");
		manager.insertAccount(25000, "1235", "tomas1");
		manager.insertAccount(20000, "1235", "tomas2");
		
		manager.setDeposit(5000, "1234");
		manager.setDeposit(5000, "1235");
		manager.setDeposit(5000, "1236");
		
		manager.accountAllDisplay();  //balance 기준으로 sorting 되서 나온다.
		
	}

}
