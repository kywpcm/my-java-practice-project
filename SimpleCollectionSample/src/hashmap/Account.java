package hashmap;

//������ Ŭ����
//server..
//Data Model..
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
	
	//���
	public void withDraw(float money) {
		if(money > balance) {
			System.out.println("not enough money");
		} else {
			balance -= money;
		}
	}
	
	//�Ա�
	public void deposit(float money) {
		if(money <= 0) {
			System.out.println("not enough money");
		} else {
			balance += money;
		}
	}
	
	public String toString() {
		return accountName + "���� ���¹�ȣ�� " + accountNumber + "�̸�, ���� �ܰ�� " + balance + "�Դϴ�.";
	}

	public float getBalance() {
		return this.balance;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

}
