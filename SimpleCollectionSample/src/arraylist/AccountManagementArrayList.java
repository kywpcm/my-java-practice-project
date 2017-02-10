package arraylist;

import java.util.ArrayList;
import java.util.Iterator;

//도메인 클래스
//server..
//has a Account class.. (1:*)
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
	
	//이렇게 Iterator를 사용해도 되고,
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
	
	//index를 통해 객체를 찾아와도 된다.
	//ArrayList는 index를 통한 접근을 허용한다.
	public void setWithdraw(float money, String accountNumber) {
		for(int i = 0; i < accounts.size(); i++) {
			Account account = accounts.get(i);  //인덱스로 찾음..
			String tempNumber = account.getAccountNumber();
			if(tempNumber.equals(accountNumber)) {
				account.withDraw(money);
				return;
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
