package treeset;

import java.util.Comparator;
import java.util.HashSet;

//������ Ŭ����
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

	//���..
	public void withDraw(float money) {
		if(money > balance) {
			System.out.println("not enough money");
		} else {
			balance -= money;
		}
	}

	//�Ա�..
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
	//TreeSet�� add() �޼ҵ� ���� �߿� ȣ��Ǿ� ����.
	//������Ʈ �ϳ��� �� ������ �ڵ����� �ݹ�
	@Override
	public int compare(Object acc1, Object acc2) {  //���ϴ� �� ��ü�� �Ѿ�´�.
		int tempBalance1 = (int) ((Account)acc1).getBalance();
		int tempBalance2 = (int) ((Account)acc2).getBalance();
		return tempBalance1 - tempBalance2;  //�̷��� �������� ����..
//		return tempBalance2 - tempBalance1;  //�̷��� �������� ����..
	}

	//implements Comparable ���� ���..
	//������Ʈ �ϳ��� �� ������ �ڵ����� �ݹ�
	//	@Override
	//	public int compareTo(Object o) {  //�Ѿ�� �Ͱ� this ��ü�� ��
	//		return 0;
	//	}

}
