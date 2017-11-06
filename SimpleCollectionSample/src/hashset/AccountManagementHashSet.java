package hashset;

import java.util.HashSet;
import java.util.Iterator;

//������ Ŭ����
//service or server
//has Account classes (1:*)
public class AccountManagementHashSet {

	private HashSet<Account> accounts;

	public AccountManagementHashSet() {
		this(10);
	}
	
	public AccountManagementHashSet(int size) {
		accounts = new HashSet<Account>(size);
	}
	
	public void insertAccount(float money, String accountNumber, String accountName) {
		//key ��ü�� Account ��ü�̱� ������ Account Ŭ������
		//equals() �޼ҵ�� hashCode() �޼ҵ带 ������ �������̵� ����� �Ѵ�.
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
