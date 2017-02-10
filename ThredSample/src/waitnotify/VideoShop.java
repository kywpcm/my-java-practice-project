package waitnotify;

import java.util.Vector;

//도메인 클래스
//server
//공유 리소스 클래스..
public class VideoShop {

	private Vector<String> buffer = new Vector<>();
	
	public VideoShop() {
		buffer.add("tomas and his friends-1");
		buffer.add("tomas and his friends-2");
		buffer.add("tomas and his friends-3");
	}
	
	//그래서 메소드에 걸어준다.
	public synchronized String lendVideo() throws InterruptedException {
		Thread t = Thread.currentThread();
		while(buffer.size() == 0) {  //video가 없을 경우,
			System.out.println(t.getName() + " waiting start");
			this.wait();  //기다리게 한다.
			System.out.println(t.getName() + " waiting end");
		}
		
		if(buffer.size() > 0) {
			String v = this.buffer.remove(buffer.size()-1);
			return v;
		} else
			return null;
	}
	
	public synchronized void returnVideo(String video) {
		this.buffer.add(video);
		//그리고 반납되면 알려준다.
		this.notify();  //한 명만!
//		this.notifyAll();  //한꺼번에 모두!
	}
	
}
