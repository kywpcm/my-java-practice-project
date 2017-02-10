package waitnotify;

import java.util.Vector;

//������ Ŭ����
//server
//���� ���ҽ� Ŭ����..
public class VideoShop {

	private Vector<String> buffer = new Vector<>();
	
	public VideoShop() {
		buffer.add("tomas and his friends-1");
		buffer.add("tomas and his friends-2");
		buffer.add("tomas and his friends-3");
	}
	
	//�׷��� �޼ҵ忡 �ɾ��ش�.
	public synchronized String lendVideo() throws InterruptedException {
		Thread t = Thread.currentThread();
		while(buffer.size() == 0) {  //video�� ���� ���,
			System.out.println(t.getName() + " waiting start");
			this.wait();  //��ٸ��� �Ѵ�.
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
		//�׸��� �ݳ��Ǹ� �˷��ش�.
		this.notify();  //�� ��!
//		this.notifyAll();  //�Ѳ����� ���!
	}
	
}
