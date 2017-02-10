
public class RemoteData {

	public String name = "이름없음";
	public String addr = "주소없음";
	
	public RemoteData() {}

	public RemoteData(String name, String addr) {
		this.name = name;
		this.addr = addr;
	}
	
	public void sayHello() {
		System.out.println(this.name + " Hello!!!");
	}
	
	public void sayHello(String name) {
		this.name = name;
		System.out.println(this.name + " Hello!!!");
	}
	
	public void goodBye() {
		System.out.println(this.name + " Good Bye~!!!");
	}

	@Override
	public String toString() {
		return super.toString() + ":" + name + ":" + addr;
	}
	
}
