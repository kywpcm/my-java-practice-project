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
		it.interrupt();  //�ڰ� �ִ� ���¸� ������ ���� ��Ȳ�� ��������..
		//������ �����带 ���� �� ����� �� �ִ�.
		//������ ��õ������ ����

	}

}
