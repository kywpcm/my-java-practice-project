package main;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import vo.Product;

public class Main {

	public static void main(String[] args) {
		
		String str1 = new String("apple");
		String str2 = new String("apple");
		String str3 = str1;

		System.out.println("[str1 hashcode : " + str1.hashCode() + "]");
		System.out.println("[str2 hashcode : " + str2.hashCode() + "]");
		System.out.println("[str3 hashcode : " + str3.hashCode() + "]");
		/* identity check */
		if (str1 == str2) { // 메모리 참조값 체크
			System.out.println("str1과 str2는 별명 관계다.참조값이 같다.");
		}
		if (str1 == str3) {
			System.out.println("str1과 str3는 별명 관계다.참조값이 같다.");
		}
		/* equality check */
		if (str1.equals(str2)) { // String의 equals와 hashCode는 이미 오버라이딩 되어 있음.
			System.out.println("str1과 str2는 내용이 같은 객체다.");
		}
		
		/* ※ String null, "" 체크 */
		// - null과 ""는 다르다.
		// - nullable 해도 되는 객체인지, not null인 객체인지 상황에 따라 판단 필요..
		// * equals 메소드 vs. empty 메소드
		//   - String 클래스에 오버라이딩된 equals 메소드는 무겁다.. (까보면 안다)
		//   - 그러로 empty 메소드를 쓰자..!!
		//   - 참고로 "".equals()의 장점은 그냥 null 익셉션을 피할 수 있다는 것..
		str1 = "";
		if (str1 != null && !"".equals(str1)) {
			System.out.println("여기 실행하고 싶을 떄...");
		} else {
			System.out.println("null or \"\"");
		}
		if (str1 != null) {
			if (!str1.isEmpty()) { // !"".equals(str1)와 같다.
				System.out.println("여기 실행하고 싶을 떄...");
			} else {
				System.out.println("\"\"");
				System.out.println("필드는 정의되었지만, 값 할당 안 됨...");
			}
		} else {
			System.out.println("null");
			System.out.println("DB 프레임워크 맵핑 안 됨...");
		}
		
		
		Product product1 = new Product(111, "A", new BigDecimal(100));
		Product product2 = new Product(222, "B", new BigDecimal(75.50));
		Product product3 = new Product(333, "C", new BigDecimal(12.75));
		// 예를 들어, 제 3자 추가의 경우 등 (framework 등)
		Product product4 = new Product(111, "A", new BigDecimal(100));
		
		// Set은 중복키 등록 허용 안 함.
		// hash-based collection은 순서 보장 못 함. 
		// Set은 데이터를 추가할 떄, 내부적으로 키 엘리먼트의 hashCode, equals 메소드 활용해서 add함..
		// Map도 마찬가지. 왜냐하면 Set이 내부적으로 Map으로 구현되어 있다.
		Set<Product> products = new HashSet<Product>();
		products.add(product1);
		products.add(product1); // add 안 됨..
		products.add(product2);
		products.add(product3);
		// product1과 같으므로 add 되면 안 됨
		// 그런데 add 됨..
		// → Object의 hashCode, equals 오버라이딩 해야 함..!
		products.add(product4);
		
		System.out.println(products);
		
		// 객체의 의미상 equality를 보장하려면 Object의 equals 메소드 오바리이딩 해야 함..!
		if (product4.equals(product1)) {
			System.out.println("product4 is equal to product1.");
		}
		
	}

}
