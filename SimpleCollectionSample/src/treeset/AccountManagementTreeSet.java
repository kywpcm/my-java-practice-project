package treeset;

import java.util.Iterator;
import java.util.TreeSet;

//������ Ŭ����
//service or server
//has Account classes (1:*)
public class AccountManagementTreeSet {

	private TreeSet<Account> accounts;

	public AccountManagementTreeSet() {
		accounts = new TreeSet<Account>(new Account());  //compare() �޼ҵ尡 �ִ� Ŭ������ �ν��Ͻ��� ���ڷ� �־� �����ؾ� �Ѵ�.
	}
	
	public void insertAccount(float money, String accountNumber, String accountName) {
		accounts.add(new Account(money, accountNumber, accountName));
	}
	
	public void setDeposit(float money, String accountNumber) {
//		Iterator ir = accounts.iterator();
		Iterator<Account> ir = accounts.iterator();  //generic ����� ����..
		while(ir.hasNext()) { 
//			Account account = (Account)ir.next();
			Account account = ir.next();  ////generic ����� ����..
			
			String tempNumber = account.getAccountNumber();
			if(accountNumber.equals(tempNumber)) {
				account.deposit(money);
				return;  //����!
			}
		}
		System.out.println("There is no account...");  //������..
	}
	
	public void setWithdraw(float money, String accountNumber) {
//		Iterator ir = accounts.iterator();
		Iterator<Account> ir = accounts.iterator();  //generic ����� ����..
		while(ir.hasNext()) { 
//			Account account = (Account)ir.next();
			Account account = ir.next();  ////generic ����� ����..
			
			String tempNumber = account.getAccountNumber();
			if(accountNumber.equals(tempNumber)) {
				account.withDraw(money);
				return;  //����!
			}
		}
		System.out.println("There is no account...");  //������..
	}
	
	public void accountAllDisplay() {
		Iterator ir = accounts.iterator();
		while(ir.hasNext()) {
			System.out.println(ir.next());
		}
	}
	
}
