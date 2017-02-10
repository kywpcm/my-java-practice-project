package synchronization;

//server
//uses Bank
public class Park extends Thread {

	@Override
	public void run() {
		//Bank 클래스 객체를 사용하여 Lock을 걸었기 때문에 공유 리소스인 Bank에 다른 스레드는 접근하지 못한다.
		synchronized (SyncMain.myBank) {
			SyncMain.myBank.saveMoney(3000);
			System.out.println("saveMoney(3000)" + SyncMain.myBank.getMoney());	
		}
	}
	
}
