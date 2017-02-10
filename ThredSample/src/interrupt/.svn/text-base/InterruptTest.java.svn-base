package interrupt;

public class InterruptTest extends Thread {

	@Override
	public void run() {
		try {
			for(int i = 0; i < 100; i++) {
				System.out.println(i+1 + " counting...");
			}
			sleep(10000);
		} catch (InterruptedException e) {
			System.out.println(e);
		} finally {
			System.out.println("end!");
		}
	}

	public static void main(String[] args) {

		InterruptTest it = new InterruptTest();
		it.start();
		it.interrupt();  //자고 있는 상태를 억지로 깨운 상황을 만들어줬다..
		//억지로 스레드를 죽일 때 사용할 수 있다.
		//하지만 추천하지는 않음

	}

}
