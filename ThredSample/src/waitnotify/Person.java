package waitnotify;

//client
//uses VideoShop
public class Person extends Thread {
	
	@Override
	public void run() {
//		synchronized (VideoShopMain.vShop) {  //VideoShop ��ü�� ��ü ���� �ɸ�, �뿩�� �ݳ��� ���ÿ� �� �� ����.
			try {
				String v = VideoShopMain.vShop.lendVideo(); // �뿩
				if(v == null) {
					System.out.println("There is no video...");
					return;
				}
				System.out.println(this.getName() + " : " + v + " �뿩");
				System.out.println(this.getName() + " : " + v + " ���� ��...");
				sleep(5000);
				System.out.println(this.getName() + " : " + v + " �ݳ�");
				VideoShopMain.vShop.returnVideo(v); // �ݳ�
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//		}
	}

}
