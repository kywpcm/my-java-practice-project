package synchronization;

//client
//uses Bank
public class Park extends Thread {

	@Override
	public void run() {
		//Bank 클래스 객체를 사용해 Lock을 걸었기 때문에 공유 리소스인 Bank에 다른 스레드는 접근하지 못한다.
		synchronized (SyncMain.myBank) { // 잠금
			// 수행
			SyncMain.myBank.saveMoney(3000);
			System.out.println("saveMoney(3000)" + SyncMain.myBank.getMoney());	
		} // 잠금 해제
	}
	
}
