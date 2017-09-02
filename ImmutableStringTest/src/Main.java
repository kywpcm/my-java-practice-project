
public class Main {

	public static void main(String[] args) {

		String str = "String is immutable object";

		Main obj = new Main();
		
		System.out.println(str);
		System.out.println("hash code : " + str.hashCode());
		obj.getHashCode(str);
		System.out.println(str);

	}

	public void getHashCode(String immStr) {
		System.out.println("hash code : " + immStr.hashCode());
		immStr = immStr + "111";
		System.out.println("hash code : " + immStr.hashCode());
		immStr = immStr + "222";
		System.out.println("hash code : " + immStr.hashCode());
	}

}
