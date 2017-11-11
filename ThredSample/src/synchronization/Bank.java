package synchronization;

//도메인 클래스
//service or server
//shared resource 대상 클래스
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
	
//	public synchronized void saveMoney(int save) {}  //메소드 방식
	public void saveMoney(int save) {
		try {
			Thread.sleep(3000);  //3초 정도 걸린다 치고..
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.setMoney(mMoney + save);
	}
	
	public void minusMoney(int minus) {
		//블록(여기서는 메소드 전체)을 수행하는데, 현재 Bank 클래스의 인스턴스를 활용해 lock을 건다.
		synchronized (this) { // 잠금
			// 수행
			try {
				Thread.sleep(1000);  //1초..
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.setMoney(mMoney - minus);
		} // 잠금 해제
	}
	
}
