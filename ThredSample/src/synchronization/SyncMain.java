package synchronization;

//client
//has a Bank
public class SyncMain {

	public static Bank myBank = new Bank(10000);  //Ŭ���� ����
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("���� " + myBank.getMoney());
		
		Park p = new Park();
		ParkWife pw = new ParkWife();
		
		p.start();
		pw.start();
	}

}
