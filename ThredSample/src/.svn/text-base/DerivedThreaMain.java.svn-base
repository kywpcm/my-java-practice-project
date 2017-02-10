
public class DerivedThreaMain {

	public static void main(String[] args) {
		System.out.println("main start");
		
		DerivedThread dt1 = new DerivedThread();
		DerivedThread dt2 = new DerivedThread();
		
		Thread t1 = new Thread(dt1);
		Thread t2 = new Thread(dt2);
		t1.start();
		t2.start();
		
		System.out.println("main end");
	}

}
