package synchronization;

//server
//uses Bank
public class ParkWife extends Thread {

	@Override
	public void run() {
		SyncMain.myBank.minusMoney(1000);
		System.out.println("minusMoney(1000)" + SyncMain.myBank.getMoney());
	}
	
}
