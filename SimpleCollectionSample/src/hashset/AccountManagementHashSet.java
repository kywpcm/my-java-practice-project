package hashset;

import java.util.HashSet;
import java.util.Iterator;

//도메인 클래스
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
		//key 객체가 Account 객체이기 때문에 Account 클래스에
		//equals() 메소드와 hashCode() 메소드를 적절히 오버라이딩 해줘야 한다.
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
