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
		
		JoinTest jt1 = new JoinTest(1, 5000);
		JoinTest jt2 = new JoinTest(5001, 10000);
		
		jt1.start();
		jt2.start();
		
		//�ּ� ó���ϸ� ������ �۾��� ������ ���� ���� �����尡 ���� ������.
		jt1.join();  //main �����尡 jt1 �����尡 ���� ������ Non-Runnable ���°� �ȴ�.
		jt2.join();  //main �����尡 jt2 �����尡 ���� ������ Non-Runnable ���°� �ȴ�.
		
		int total = jt1.sum + jt2.sum;
		System.out.println("Last Total = " + total + ", jt1.sum = " + jt1.sum
				+ ", jt2.sum = " + jt2.sum);
		
	}

}
