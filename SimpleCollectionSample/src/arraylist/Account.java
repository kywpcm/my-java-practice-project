package arraylist;

//도메인 클래스
//Entity or VO
public class Account {

	private float balance;
	private String accountNumber;
	private String accountName;
	
	public Account() {}

	public Account(float balance, String accountNumber, String accountName) {		
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.accountName = accountName;
	}
	
	//인출..
	public void withDraw(float money) {
		if(money > balance) {
			System.out.println("not enough money");
		} else {
			balance -= money;
		}
	}
	
	//예금..
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

}
