package hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

//도메인 클래스
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
	
	//Map 계열의 containsKey(), get() 메소드를 활용한다.
	public void setDeposit(float money, String accountNumber) {
		if(accounts.containsKey(accountNumber)) {
			Account account = accounts.get(accountNumber);
			account.deposit(money);
			return;
		}
		System.out.println("There is no account...");
	}
	
	//Map 계열의 containsKey(), get() 메소드를 활용한다.
	public void setWithdraw(float money, String accountNumber) {
		if(accounts.containsKey(accountNumber)) {
			Account account = accounts.get(accountNumber);
			account.withDraw(money);
			return;
		}
		System.out.println("There is no account...");
	}
	
	public void accountAllDisplay() {
		
		Set keySet = accounts.keySet();  //Map에 포함되어져 있는 key들의 Set을 리턴
		//(원래 정렬이 되면 안되지만, 이 부분에서 정렬이 되는 것 같다..)
		//Set은 Collection의 하위 인터페이스이므로..
		Iterator ir = keySet.iterator();
//		Collection values = accounts.values();  //Map에 포함되어져 있는 value들의 Collection view를 리턴
//		Iterator ir = values.iterator();
		
		while(ir.hasNext()) {
			String accountNumber = (String)ir.next();  //현재 Iterator 객체는 key를 담고있는 Set이 만들어낸 것이다.
//			String accountNumber = ((Account)ir.next()).getAccountNumber();
			Account account = accounts.get(accountNumber);
			System.out.println(account);
		}
	}
	
}
