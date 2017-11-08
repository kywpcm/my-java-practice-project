package treeset;

import java.util.Comparator;
import java.util.HashSet;

//도메인 클래스
//server..
//Data Model..
public class Account implements Comparator {

	private float balance;
	private String accountNumber;
	private String accountName;

	public Account() {}

	public Account(float balance, String accountNumber, String accountName) {		
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.accountName = accountName;
	}

	//출금..
	public void withDraw(float money) {
		if(money > balance) {
			System.out.println("not enough money");
		} else {
			balance -= money;
		}
	}

	//입금..
	public void deposit(float money) {
		if(money <= 0) {
			System.out.println("not enough money");
		} else {
			balance += money;
		}
	}

	public String toString() {
		return accountName + "님의 계좌번호는 " + accountNumber + "이며, 현재 잔고는 " + balance + "입니다.";
	}

	public float getBalance() {
		return this.balance;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	//메소드 오버라이딩..
	//TreeSet의 add() 메소드 동작 중에 호출되어 진다.
	//엘리먼트 하나가 들어갈 때마다 자동으로 콜백
	@Override
	public int compare(Object acc1, Object acc2) {  //비교하는 두 객체가 넘어온다.
		int tempBalance1 = (int) ((Account)acc1).getBalance();
		int tempBalance2 = (int) ((Account)acc2).getBalance();
		return tempBalance1 - tempBalance2;  //이러면 오름차순 정렬..
//		return tempBalance2 - tempBalance1;  //이러면 내림차순 정렬..
	}

	//implements Comparable 했을 경우..
	//엘리먼트 하나가 들어갈 때마다 자동으로 콜백
	//	@Override
	//	public int compareTo(Object o) {  //넘어온 것과 this 객체와 비교
	//		return 0;
	//	}

}
