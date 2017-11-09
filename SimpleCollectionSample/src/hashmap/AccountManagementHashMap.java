package hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

//������ Ŭ����
//service or server
//has Account classes (1:*)
public class AccountManagementHashMap {

	private HashMap<String, Account> accounts;

	public AccountManagementHashMap() {
		accounts = new HashMap<String, Account>();
	}
	
	public void insertAccount(float balance, String accountNumber, String accountName) {
		accounts.put(accountNumber, new Account(balance, accountNumber, accountName));
	}
	
	//Map �迭�� containsKey(), get() �޼ҵ带 Ȱ���Ѵ�.
	public void setDeposit(float money, String accountNumber) {
		if(accounts.containsKey(accountNumber)) {
			Account account = accounts.get(accountNumber);
			account.deposit(money);
			return;
		}
		System.out.println("There is no account...");
	}
	
	//Map �迭�� containsKey(), get() �޼ҵ带 Ȱ���Ѵ�.
	public void setWithdraw(float money, String accountNumber) {
		if(accounts.containsKey(accountNumber)) {
			Account account = accounts.get(accountNumber);
			account.withDraw(money);
			return;
		}
		System.out.println("There is no account...");
	}
	
	public void accountAllDisplay() {
		
		Set keySet = accounts.keySet();  //Map�� ���ԵǾ��� �ִ� key���� Set�� ����
		//(���� ������ �Ǹ� �ȵ�����, �� �κп��� ������ �Ǵ� �� ����..)
		//Set�� Collection�� ���� �������̽��̹Ƿ�..
		Iterator ir = keySet.iterator();
//		Collection values = accounts.values();  //Map�� ���ԵǾ��� �ִ� value���� Collection view�� ����
//		Iterator ir = values.iterator();
		
		while(ir.hasNext()) {
			String accountNumber = (String)ir.next();  //���� Iterator ��ü�� key�� ����ִ� Set�� ���� ���̴�.
//			String accountNumber = ((Account)ir.next()).getAccountNumber();
			Account account = accounts.get(accountNumber);
			System.out.println(account);
		}
	}
	
}
