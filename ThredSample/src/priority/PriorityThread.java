package priority;

public class PriorityThread extends Thread {

	@Override
	public void run() {
		int i = 0;
		System.out.print(this.getName());
		System.out.println("[우선권:" + this.getPriority() + "]시작\t");
		while(i < 10000) {
			i += 1;
			try {
				this.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print(this.getName());
		System.out.println("[우선권:" + this.getPriority() + "]종료\t");
	}

}
