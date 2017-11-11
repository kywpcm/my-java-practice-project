package priority;

public class PriorityThread extends Thread {

	@Override
	public void run() {
		int i = 0;
		System.out.println(this.getName() + " => [�켱��:" + this.getPriority() + "] ����");
		while(i < 10000) {
			i += 1;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(this.getName() + " => [�켱��:" + this.getPriority() + "] ����");
	}

}
