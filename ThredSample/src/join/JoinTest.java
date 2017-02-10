package join;

public class JoinTest extends Thread {

	private int start, end;
	public int sum;
	
	public JoinTest(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		for(int i = start; i <= end; i++) {
			sum += i;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		
		JoinTest jt1 = new JoinTest(1, 50);
		JoinTest jt2 = new JoinTest(51, 100);
		
		jt1.start();
		jt2.start();
		
		//주석 처리하면 스레드 작업이 끝나기전에 메인 스레드가 끝난다.
		jt1.join();  //main 스레드가 jt1 스레드가 죽을 때까지 Non-Runnable 상태가 된다.
		jt2.join();  //...
		
		int total = jt1.sum + jt2.sum;
		System.out.println("Last Total = " + total + ", jt1.sum = " + jt1.sum
				+ ", jt2.sum = " + jt2.sum);
		
	}

}
