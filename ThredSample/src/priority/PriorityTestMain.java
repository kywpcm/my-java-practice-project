package priority;

public class PriorityTestMain {

	public static void main(String[] args) {

		PriorityThread pt = new PriorityThread();
		pt.setPriority(Thread.MIN_PRIORITY);
		pt.start();

		PriorityThread pt2 = new PriorityThread();
		pt2.setPriority(Thread.MAX_PRIORITY);
		pt2.start();

	}

}
