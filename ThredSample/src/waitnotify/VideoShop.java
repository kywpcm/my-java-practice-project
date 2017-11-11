package waitnotify;

import java.util.Vector;

//도메인 클래스
//service or server
//공유 리소스 클래스
public class VideoShop {

	private Vector<String> buffer = new Vector<>();
	
	public VideoShop() {
		buffer.add("tomas and his friends-1");
		buffer.add("tomas and his friends-2");
		buffer.add("tomas and his friends-3");
	}
	
	//그래서 메소드 락을 걸어준다.
	//한 명씩 비디오를 빌린다.
	public synchronized String lendVideo() throws InterruptedException {
		Thread t = Thread.currentThread();
		while(buffer.size() == 0) {  //video가 없을 경우,
			System.out.println(t.getName() + " waiting start");
			// wait 메소드를 실행한 스레드는 대기하면서 메소드 락을 잠시 풀어준다.
			// 그리고 this(VideoShop) 객체 대기 큐에 들어간다.
			this.wait();
			System.out.println(t.getName() + " waiting end");
		}
		
		if(buffer.size() > 0) {
			String v = this.buffer.remove(buffer.size()-1);
			return v;
		} else
			return null;
	}
	
	//메소드 락
	//한 명씩 비디오를 반납한다.
	public synchronized void returnVideo(String video) {
		this.buffer.add(video);
		// this(이 객체)에 wait 하고 있는 스레드 중 한 스레드를 선택해 재시작 되게 한다.
		this.notify();  //한 명만!
//		this.notifyAll();  //한꺼번에 모두!
	}
	
}
