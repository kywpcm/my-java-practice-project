/**
 * Set의 가장 일반적인 사용 용도는 멤버쉽, 즉 존재 유무를 확인하는 것이므로 Set 내에 특정 객체가 있는지의 여부를 쉽게 알 수 있다.
 * 이런 이유로 검색이 Set 계열의 가장 중요한 오퍼레이션이며, 일반적으로 HashSet 구현을 사용한다.
 * 빠른 검색에 최적화 되어 있기 때문이다.
 *******************************HashSet*************************************
 * Hash 알고리즘을 이용하여 구현됨
 * O(1)
 */

package hashset;

import java.util.HashSet;
import java.util.Iterator;

//client
//Use a AccountManagementHashSet class
public class AccountHashSetTest {

	public static void main(String[] args) {

		AccountManagementHashSet manager = new AccountManagementHashSet();
		manager.insertAccount(15000, "1237", "james");
		manager.insertAccount(25000, "1238", "tomas");
		manager.insertAccount(45000, "1236", "edward");
		manager.insertAccount(35000, "1235", "percy1");
		
		//accountNumber를 기준으로
		//Account 클래스에 equals() 메소드와 hashCode() 메소드를 오버라이딩 했기 때문에,
		//중복된 값은 들어가지 않게 된다.
		manager.insertAccount(55000, "1236", "percy2");
		manager.insertAccount(65000, "1236", "percy3");
		
		manager.setDeposit(5000, "1234");
		manager.setDeposit(5000, "1235");
		manager.setDeposit(5000, "1236");
		
		manager.accountAllDisplay();
		
		System.out.println();
		
		//example..
		HashSet set = new HashSet();
		Account acc1 = new Account(100, "123", "test1");
		Account acc2 = new Account(200, "123", "test2");
		set.add(acc1);
		set.add(acc2);
		Iterator ir = set.iterator();
		while(ir.hasNext()) {
			System.out.println(ir.next());
		}
		System.out.println();
		
		String str1 = new String("Dog");  //String 클래스 안에 equals()와 hashCode()가 오버라이딩 되어 있기 때문에
		String str2 = new String("Dog");  //이 둘은 같은 객체이다.
		set.add(str1);
		set.add(str2);
		
		System.out.println(set);
	}

}
