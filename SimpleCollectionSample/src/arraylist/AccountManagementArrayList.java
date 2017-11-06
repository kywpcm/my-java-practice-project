package arraylist;

import java.util.ArrayList;
import java.util.Iterator;

//도메인 클래스
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
	
	//이렇게 Iterator를 사용해도 되고,
	public void setDeposit(float money, String accountNumber) {
//		Iterator ir = accounts.iterator();
		Iterator<Account> ir = accounts.iterator();  //generic 사용
		while(ir.hasNext()) { 
//			Account account = (Account)ir.next();
			Account account = ir.next();  //generic 사용의 이점..
			
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
		// iterator 사용
//		Iterator ir = accounts.iterator();
//		while(ir.hasNext()) {
//			System.out.println(ir.next());
//		}
		
		// for-each statement (enhanced for loop)
		for (Account account : accounts) {
			// mutator를 통해 객체의 상태를 변경할 수 있다.
			account.deposit(99999);
		}
		for (Account account : accounts) {
			System.out.println(account);
		}
		
		// primitive 타입이나 immutable한 객체는 write는 안 되고, read 용도로 사용.
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		int index = 0; // for-each 문에서 index를 사용하고 싶을 때..
		for (int num : array) {
			num = num + 100;
//			array[index] = num + 100; // 이렇게 하면 write 가능
			System.out.println("current index is " + index++ + " ===> " + num);
		}
		index = 0;
		for (int num : array) {
			System.out.println("current index is " + index++ + " ===> " + num);
		}
		
		// ==================================
		// good practice
		// - for-each statement는 컬렉션 전체를 순회하고자 할 때
		// - 기존 for문과 성능 차이는 없다고 한다.
		// - but, iterator vs. for-each..?
		// ==================================
	}
	
}
