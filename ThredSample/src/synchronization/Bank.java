package synchronization;

//������ Ŭ����
//server
//shared resource Ŭ����..
public class Bank {

	private int money = 10000;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
//	public synchronized void saveMoney(int save) {}  //�޼ҵ� ���
	public void saveMoney(int save) {
		int money = this.getMoney();
		try {
			Thread.sleep(3000);  //3�� ���� �ɸ��� ġ��..
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.setMoney(money + save);
	}
	
	public void minusMoney(int minus) {
		//���(���⼭�� �޼ҵ� ��ü)�� �����ϴµ�, ���� Bank Ŭ������ �ν��Ͻ��� Ȱ���Ͽ� lock�� �Ǵ�.
		synchronized (this) {
			int money = this.getMoney();
			try {
				Thread.sleep(200);  //0.2��..
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.setMoney(money - minus);
		}
	}
	
}
