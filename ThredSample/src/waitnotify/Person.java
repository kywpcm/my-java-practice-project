package waitnotify;

//client
//uses VideoShop
public class Person extends Thread {
	
	@Override
	public void run() {
//		synchronized (VideoShopMain.vShop) {  //VideoShop 객체로 전체 락을 걸면, 대여와 반납을 동시에 할 수 없다.
			try {
				String v = VideoShopMain.vShop.lendVideo(); // 대여
				if(v == null) {
					System.out.println("There is no video...");
					return;
				}
				System.out.println(this.getName() + " : " + v + " 대여");
				System.out.println(this.getName() + " : " + v + " 보는 중...");
				sleep(5000);
				System.out.println(this.getName() + " : " + v + " 반납");
				VideoShopMain.vShop.returnVideo(v); // 반납
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//		}
	}

}
