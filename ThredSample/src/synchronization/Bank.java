package synchronization;

//������ Ŭ����
//service or server
//shared resource ��� Ŭ����
public class Bank {

	private int mMoney;

	public Bank(int money) {
		this.mMoney = money;
	}

	public int getMoney() {
		return mMoney;
	}

	public void setMoney(int money) {
		this.mMoney = money;
	}
	
//	public synchronized void saveMoney(int save) {}  //�޼ҵ� ���
	public void saveMoney(int save) {
		try {
			Thread.sleep(3000);  //3�� ���� �ɸ��� ġ��..
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.setMoney(mMoney + save);
	}
	
	public void minusMoney(int minus) {
		//���(���⼭�� �޼ҵ� ��ü)�� �����ϴµ�, ���� Bank Ŭ������ �ν��Ͻ��� Ȱ���� lock�� �Ǵ�.
		synchronized (this) { // ���
			// ����
			try {
				Thread.sleep(1000);  //1��..
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.setMoney(mMoney - minus);
		} // ��� ����
	}
	
}
