package synchronization;

//client
//has a Bank
public class SyncMain {

	public static Bank myBank = new Bank(10000);  //클래스 변수
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("원금 " + myBank.getMoney());
		
		Park p = new Park();
		ParkWife pw = new ParkWife();
		
		p.start();
		pw.start();
	}

}
