package interrupt;

public class InterruptTest extends Thread {

	@Override
	public void run() {
		try {
			for(int i = 0; i < 100; i++) {
				System.out.println(i+1 + " counting...");
			}
			System.out.println("sleep for 10 seconds.....");
			sleep(10000);
		} catch (InterruptedException e) {
			System.out.println(e);
		} finally {
			System.out.println("end!");
		}
	}

	public static void main(String[] args) throws InterruptedException {

		InterruptTest it = new InterruptTest();
		it.start();
		Thread.sleep(3000);
		it.interrupt();  //�ڰ� �ִ� ����(non-runnable state)�� ������ ���� ��Ȳ�� ��������.
		//�ݴ�� ������ �����带 ���� �� ����� �� �ִ�. (���� ���ͷ�Ʈ �÷���)
		//������ ��õ������ ����

	}

}
