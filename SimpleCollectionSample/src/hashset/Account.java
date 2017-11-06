package hashset;

//������ Ŭ����
//Entity or VO
public class Account {

	private float balance;
	private String accountNumber; // ����Ͻ� PK��� ����.
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
		return accountName + "���� ���¹�ȣ�� " + accountNumber + "�̸�, ���� �ܰ�� " + balance + "�Դϴ�.";
	}

	public float getBalance() {
		return this.balance;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	//�޼ҵ� �������̵�..
	//HashSet�� add() �޼ҵ� ���� �߿� ȣ��Ǿ� ����.
	@Override
	public boolean equals(Object obj) {
		Account other = (Account)obj; // or that..
		return this.accountNumber.equals(other.getAccountNumber());
	}

	//�޼ҵ� �������̵�..
	//HashSet�� add() �޼ҵ� ���� �߿� ȣ��Ǿ� ����.
	//equals() �޼ҵ� �������̵����� ����, accountNumber�� ������ ���� ��ü��� �Ǵ��ؾ� �ϱ� ������
	//hashCode() �޼ҵ嵵 ������ �������̵� ���ش�.
	@Override
	public int hashCode() {
		return Integer.parseInt(accountNumber);
	}

}
