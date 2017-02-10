package synchronization;

//client
public class SyncMain {

	public static Bank myBank = new Bank();  //클래스 변수
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("원금 " + myBank.getMoney());
		
		Park p = new Park();
		ParkWife pw = new ParkWife();
		
		p.start();
		Thread.sleep(200);
		pw.start();
	}

}
