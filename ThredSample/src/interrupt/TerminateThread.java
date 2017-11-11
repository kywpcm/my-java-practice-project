package interrupt;

public class TerminateThread extends Thread {

	private boolean shouldTerminate = false;

	public TerminateThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println(this.getName() + " start");
		while(!shouldTerminate) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(this.getName() + " end");
	}
	
	public void setTerminateFlag(boolean flag) {
		this.shouldTerminate = flag;
	}
	
}
