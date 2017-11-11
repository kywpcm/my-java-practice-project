package waitnotify;

//client
//has a VideoShop
public class VideoShopMain {

	public static VideoShop vShop = new VideoShop();  //클래스 변수
	
	public static void main(String[] args) {
		
		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();
		Person p4 = new Person();
		Person p5 = new Person();
		Person p6 = new Person();
		
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		p6.start();

	}

}
