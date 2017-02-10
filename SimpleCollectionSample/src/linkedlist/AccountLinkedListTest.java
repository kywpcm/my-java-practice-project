/**
 * 크기가 변하는(삽입, 삭제) 순차 리스트를 요구할 때, 배열과 같은 순차적인 표현은 부적당하다.
 * 따라서 각각의 노드들의 연결로서 이루어져 있는 리스트 구조가 필요하게 되었다.
 ******************LinkedList**********************
 * 최적의 순차 액세스를 제공하며, List 중간에 추가, 삭제가 빠름
 * 무작위 액세스는 상대적으로 느림
 * ArrayList보다는 광범위한 기능을 갖고 있다.
 */

package linkedlist;

import java.util.LinkedList;
import java.util.ListIterator;

//client..
//더 많은 기능은 메소드를 직접 입력해 테스트 해 보자..
//ListIterator와 혼합해서 사용하면 데이터 핸들링이 유리함
public class AccountLinkedListTest {

	public static void main(String[] args) {

		LinkedList<Account> accounts = new LinkedList<Account>();  //자료구조 api로 바로 쓴다..
		accounts.add(new Account(15000, "1234_1", "james"));
		accounts.add(new Account(25000, "1234_2", "tomas"));
		accounts.add(new Account(35000, "1234_3", "edward"));
		accounts.add(new Account(45000, "1234_4", "percy"));
		
		System.out.println(accounts.getFirst());
		System.out.println(accounts.getLast());
		System.out.println();
		
		accounts.push(new Account(55000, "1234_5", "phoby"));  //This method is equivalent to addFirst()
		System.out.println(accounts.getFirst());
		System.out.println();
		
		ListIterator<Account> ir = accounts.listIterator();
		System.out.println(ir.next());  //엘리먼트 리턴하고, 커서 증가
		System.out.println(ir.next());  
		System.out.println(ir.previous());  //커서 감소하소, 엘리먼트 리턴
	}

}
