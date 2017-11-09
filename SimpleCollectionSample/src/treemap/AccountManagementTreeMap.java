package treemap;

import treemap.Account;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

//도메인 클래스
//service or server
//has Account classes (1:*)
public class AccountManagementTreeMap {

	//key로 custom 객체를 사용한다.
	//AccountNumber로 sorting할 것이다.
	private TreeMap<AccountNumber, Account> accounts;
	
	public AccountManagementTreeMap() {
													  //인자는 Comparator 객체..
		accounts = new TreeMap<AccountNumber, Account>(new AccountNumber());  //Comparator를 구현하여, compare() 메소드를 오버라이딩 해야 한다.  
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
