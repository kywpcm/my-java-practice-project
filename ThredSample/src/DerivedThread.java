
public class DerivedThread implements Runnable {

	@Override
	public void run() {
		
		String curThread = Thread.currentThread().toString();
		
		for(int i = 0; i < 200; i++) {
			System.out.println(curThread + " " + i);
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
	}
	
}
