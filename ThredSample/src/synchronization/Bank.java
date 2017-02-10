package synchronization;

//도메인 클래스
//server
//shared resource 클래스..
public class Bank {

	private int money = 10000;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
//	public synchronized void saveMoney(int save) {}  //메소드 방식
	public void saveMoney(int save) {
		int money = this.getMoney();
		try {
			Thread.sleep(3000);  //3초 정도 걸린다 치고..
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.setMoney(money + save);
	}
	
	public void minusMoney(int minus) {
		//블록(여기서는 메소드 전체)을 수행하는데, 현재 Bank 클래스의 인스턴스를 활용하여 lock을 건다.
		synchronized (this) {
			int money = this.getMoney();
			try {
				Thread.sleep(200);  //0.2초..
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.setMoney(money - minus);
		}
	}
	
}
