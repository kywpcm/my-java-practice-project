package waitnotify;

//server
//uses VideoShop
public class Person extends Thread {
	
	@Override
	public void run() {
//		synchronized (VideoShopMain.vShop) {  //VideoShop 객체로 전체 락을 걸면, 한꺼번에 대여할 수가 없다..
			try {
				String v = VideoShopMain.vShop.lendVideo();
				if(v == null) {
					System.out.println("There is no video...");
					return;
				}
				System.out.println(this.getName() + " : " + v + " 대여");
				System.out.println(this.getName() + " : " + v + " 보는 중...");
				sleep(5000);
				System.out.println(this.getName() + " : " + v + " 반납");
				VideoShopMain.vShop.returnVideo(v);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//		}
	}

}
