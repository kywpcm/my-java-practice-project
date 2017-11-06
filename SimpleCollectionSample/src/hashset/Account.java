package hashset;

//도메인 클래스
//Entity or VO
public class Account {

	private float balance;
	private String accountNumber; // 비즈니스 PK라고 하자.
	private String accountName;
	
	public Account() {}

	public Account(float balance, String accountNumber, String accountName) {		
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.accountName = accountName;
	}
	
	public void withDraw(float money) {
		if(money > balance) {
			System.out.println("not enough money");
		} else {
			balance -= money;
		}
	}
	
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
	//HashSet의 add() 메소드 동작 중에 호출되어 진다.
	@Override
	public boolean equals(Object obj) {
		Account other = (Account)obj; // or that..
		return this.accountNumber.equals(other.getAccountNumber());
	}

	//메소드 오버라이딩..
	//HashSet의 add() 메소드 동작 중에 호출되어 진다.
	//equals() 메소드 오버라이딩으로 인해, accountNumber가 같으면 같은 객체라고 판단해야 하기 때문에
	//hashCode() 메소드도 적절히 오버라이딩 해준다.
	@Override
	public int hashCode() {
		return Integer.parseInt(accountNumber);
	}

}
