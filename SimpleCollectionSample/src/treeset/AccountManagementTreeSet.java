package treeset;

import java.util.Iterator;
import java.util.TreeSet;

//도메인 클래스
//service or server
//has Account classes (1:*)
public class AccountManagementTreeSet {

	private TreeSet<Account> accounts;

	public AccountManagementTreeSet() {
		accounts = new TreeSet<Account>(new Account());  //compare() 메소드가 있는 클래스의 인스턴스를 인자로 넣어 생성해야 한다.
	}
	
	public void insertAccount(float money, String accountNumber, String accountName) {
		accounts.add(new Account(money, accountNumber, accountName));
	}
	
	public void setDeposit(float money, String accountNumber) {
//		Iterator ir = accounts.iterator();
		Iterator<Account> ir = accounts.iterator();  //generic 사용의 이점..
		while(ir.hasNext()) { 
//			Account account = (Account)ir.next();
			Account account = ir.next();  ////generic 사용의 이점..
			
			String tempNumber = account.getAccountNumber();
			if(accountNumber.equals(tempNumber)) {
				account.deposit(money);
				return;  //리턴!
			}
		}
		System.out.println("There is no account...");  //없으면..
	}
	
	public void setWithdraw(float money, String accountNumber) {
//		Iterator ir = accounts.iterator();
		Iterator<Account> ir = accounts.iterator();  //generic 사용의 이점..
		while(ir.hasNext()) { 
//			Account account = (Account)ir.next();
			Account account = ir.next();  ////generic 사용의 이점..
			
			String tempNumber = account.getAccountNumber();
			if(accountNumber.equals(tempNumber)) {
				account.withDraw(money);
				return;  //리턴!
			}
		}
		System.out.println("There is no account...");  //없으면..
	}
	
	public void accountAllDisplay() {
		Iterator ir = accounts.iterator();
		while(ir.hasNext()) {
			System.out.println(ir.next());
		}
	}
	
}
