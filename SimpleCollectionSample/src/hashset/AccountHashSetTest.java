/**
 * Set�� ���� �Ϲ����� ��� �뵵�� �����, �� ���� ������ Ȯ���ϴ� ���̹Ƿ� Set ���� Ư�� ��ü�� �ִ����� ���θ� ���� �� �� �ִ�.
 * �̷� ������ �˻��� Set �迭�� ���� �߿��� ���۷��̼��̸�, �Ϲ������� HashSet ������ ����Ѵ�.
 * ���� �˻��� ����ȭ �Ǿ� �ֱ� �����̴�.
 *******************************HashSet*************************************
 * Hash �˰����� �̿��Ͽ� ������
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
		
		//accountNumber�� ��������
		//Account Ŭ������ equals() �޼ҵ�� hashCode() �޼ҵ带 �������̵� �߱� ������,
		//�ߺ��� ���� ���� �ʰ� �ȴ�.
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
		
		String str1 = new String("Dog");  //String Ŭ���� �ȿ� equals()�� hashCode()�� �������̵� �Ǿ� �ֱ� ������
		String str2 = new String("Dog");  //�� ���� ���� ��ü�̴�.
		set.add(str1);
		set.add(str2);
		
		System.out.println(set);
	}

}
