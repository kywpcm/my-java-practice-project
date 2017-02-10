package interrupt;

public class TerminateThread extends Thread {

	private boolean flag = false;

	public TerminateThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println(this.getName() + " start");
		while(!flag) {
			try {
				this.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(this.getName() + " end");
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
