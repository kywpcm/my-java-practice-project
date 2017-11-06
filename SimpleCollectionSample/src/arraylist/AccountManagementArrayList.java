package arraylist;

import java.util.ArrayList;
import java.util.Iterator;

//������ Ŭ����
//service or server
//has Account classes (1:*)
public class AccountManagementArrayList {

	ArrayList<Account> accounts;

	public AccountManagementArrayList() {
		this(10);
	}

	public AccountManagementArrayList(int size) {
		accounts = new ArrayList<Account>(size);
	}
	
	public void insertAccount(float money, String accountNumber, String accountName) {
		accounts.add(new Account(money, accountNumber, accountName));
	}
	
	//�̷��� Iterator�� ����ص� �ǰ�,
	public void setDeposit(float money, String accountNumber) {
//		Iterator ir = accounts.iterator();
		Iterator<Account> ir = accounts.iterator();  //generic ���
		while(ir.hasNext()) { 
//			Account account = (Account)ir.next();
			Account account = ir.next();  //generic ����� ����..
			
			String tempNumber = account.getAccountNumber();
			if(accountNumber.equals(tempNumber)) {
				account.deposit(money);
				return;  //����!
			}
		}
		System.out.println("There is no account...");  //������..
	}
	
	//index�� ���� ��ü�� ã�ƿ͵� �ȴ�.
	//ArrayList�� index�� ���� ������ ����Ѵ�.
	public void setWithdraw(float money, String accountNumber) {
		for(int i = 0; i < accounts.size(); i++) {
			Account account = accounts.get(i);  //�ε����� ã��..
			String tempNumber = account.getAccountNumber();
			if(tempNumber.equals(accountNumber)) {
				account.withDraw(money);
				return;
			}
		}
		System.out.println("There is no account...");  //������..
	}
	
	public void accountAllDisplay() {
		// iterator ���
//		Iterator ir = accounts.iterator();
//		while(ir.hasNext()) {
//			System.out.println(ir.next());
//		}
		
		// for-each statement (enhanced for loop)
		for (Account account : accounts) {
			// mutator�� ���� ��ü�� ���¸� ������ �� �ִ�.
			account.deposit(99999);
		}
		for (Account account : accounts) {
			System.out.println(account);
		}
		
		// primitive Ÿ���̳� immutable�� ��ü�� write�� �� �ǰ�, read �뵵�� ���.
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		int index = 0; // for-each ������ index�� ����ϰ� ���� ��..
		for (int num : array) {
			num = num + 100;
//			array[index] = num + 100; // �̷��� �ϸ� write ����
			System.out.println("current index is " + index++ + " ===> " + num);
		}
		index = 0;
		for (int num : array) {
			System.out.println("current index is " + index++ + " ===> " + num);
		}
		
		// ==================================
		// good practice
		// - for-each statement�� �÷��� ��ü�� ��ȸ�ϰ��� �� ��
		// - ���� for���� ���� ���̴� ���ٰ� �Ѵ�.
		// - but, iterator vs. for-each..?
		// ==================================
	}
	
}
