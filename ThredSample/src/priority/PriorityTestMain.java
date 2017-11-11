package priority;

public class PriorityTestMain {

	public static void main(String[] args) throws InterruptedException {

		PriorityThread pt = new PriorityThread();
		pt.setPriority(Thread.MIN_PRIORITY);
		pt.start();

		PriorityThread pt2 = new PriorityThread();
		pt2.setPriority(Thread.MAX_PRIORITY);
//		Thread.sleep(1000); // main 스레드 1초 sleep..
		pt2.start();

	}

}
