package synchronization;

//server
//uses Bank
public class Park extends Thread {

	@Override
	public void run() {
		//Bank Ŭ���� ��ü�� ����Ͽ� Lock�� �ɾ��� ������ ���� ���ҽ��� Bank�� �ٸ� ������� �������� ���Ѵ�.
		synchronized (SyncMain.myBank) {
			SyncMain.myBank.saveMoney(3000);
			System.out.println("saveMoney(3000)" + SyncMain.myBank.getMoney());	
		}
	}
	
}
