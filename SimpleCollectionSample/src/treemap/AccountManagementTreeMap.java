package treemap;

import treemap.Account;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

//������ Ŭ����
//service or server
//has Account classes (1:*)
public class AccountManagementTreeMap {

	//key�� custom ��ü�� ����Ѵ�.
	//AccountNumber�� sorting�� ���̴�.
	private TreeMap<AccountNumber, Account> accounts;
	
	public AccountManagementTreeMap() {
													  //���ڴ� Comparator ��ü..
		accounts = new TreeMap<AccountNumber, Account>(new AccountNumber());  //Comparator�� �����Ͽ�, compare() �޼ҵ带 �������̵� �ؾ� �Ѵ�.  
	}
	
	public void insertAccount(float balance, AccountNumber accountNumber, String accountName) {
		accounts.put(accountNumber, new Account(balance, accountNumber.getAccountNumber(), accountName));
	}
	
	public void setDeposit(float money, AccountNumber accountNumber) {
		if(accounts.containsKey(accountNumber)) {
			Account account = accounts.get(accountNumber);
			account.deposit(money);
			return;
		}
		System.out.println("There is no account...");
	}
	
	public void setWithdraw(float money, AccountNumber accountNumber) {
		if(accounts.containsKey(accountNumber.getAccountNumber())) {
			Account account = accounts.get(accountNumber.getAccountNumber());
			account.withDraw(money);
			return;
		}
		System.out.println("There is no account...");
	}
	
	public void accountAllDisplay() {
		
		Set keySet = accounts.keySet();
		Iterator ir = keySet.iterator();
//		Collection values = accounts.values();
//		Iterator ir = values.iterator();
		
		while(ir.hasNext()) {
			Account account = accounts.get(ir.next());
			System.out.println(account);
		}
	}
	
}
