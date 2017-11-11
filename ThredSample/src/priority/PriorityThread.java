package priority;

public class PriorityThread extends Thread {

	@Override
	public void run() {
		int i = 0;
		System.out.println(this.getName() + " => [우선권:" + this.getPriority() + "] 시작");
		while(i < 10000) {
			i += 1;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(this.getName() + " => [우선권:" + this.getPriority() + "] 종료");
	}

}
