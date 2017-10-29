package main;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import entity.Product;

public class Main {

	public static void main(String[] args) {
		
		String str1 = new String("apple");
		String str2 = new String("apple");
		String str3 = str1;
		
		System.out.println("[str1 hashcode : " + str1.hashCode() + "]");
		System.out.println("[str2 hashcode : " + str2.hashCode() + "]");
		System.out.println("[str3 hashcode : " + str3.hashCode() + "]");
		/* identity check */
		if (str1 == str2) { // 메모리 참조값 체크 (변수값)
			System.out.println("str1과 str2는 별명 관계다.참조값이 같다.");
		}
		if (str1 == str3) {
			System.out.println("str1과 str3는 별명 관계다.참조값이 같다.");
		}
		/* equality check */
		if (str1.equals(str2)) { // String의 equals와 hashCode는 이미 오버라이딩 되어 있음.
			System.out.println("str1과 str2는 내용이 같은 객체다.");
		}
		
		
		// -------------------------------------------------------------
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
		// -------------------------------------------------------------
		
		
		Product product1 = new Product(111, "A", new BigDecimal(100));
		Product product2 = new Product(222, "B", new BigDecimal(75.50));
		Product product3 = new Product(333, "C", new BigDecimal(12.75));
		// 예를 들어, 제 3자 추가의 경우 등 (framework 등)
		Product product4 = new Product(111, "A", new BigDecimal(100)); // product1과 같음
		
		// Set은 중복키 등록 허용 안 함.
		// hash-based collection은 순서 보장 못 함.
		// Set은 데이터를 추가할 떄, 내부적으로 키 엘리먼트의 hashCode, equals 메소드 활용해서 add함..
		// Map도 마찬가지. 왜냐하면 Set이 내부적으로 Map으로 구현되어 있음.
		Set<Product> products = new HashSet<Product>();
		System.out.println(products.add(product1));
		System.out.println(products.add(product1)); // add 안 됨..
		System.out.println(products.add(product2));
		System.out.println(products.add(product3));
		// product1과 같으므로 add 되면 안 됨
		// 그런데 add 됨..
		// → Object의 hashCode, equals 오버라이딩 해야 함..!
		System.out.println(products.add(product4));
		
		System.out.println(products);
		
		// 객체의 의미상 equality를 보장하려면 Object의 equals 메소드 오바리이딩 해야 함..!
		if (product4.equals(product1)) {
			System.out.println("product4 is equal to product1.");
		}
		
		
		// Map은 중복키가 들어오면 덮어 씌운다.
		Map<Product, Integer> productMap = new HashMap<>();
		productMap.put(product1, 1);
		productMap.put(product2, 2);
		productMap.put(product3, 3);
		// 그런데, 키로 사용한 객체의 상태를 변경하면
		// hashCode 메소드에 영향을 줘서 (equals 메소드도 마찬가지)
		// 기존 저장한 hashCode와는 다른 hashCode 결과가 나온다.
		// 따라서 같은 키임에도 불구하고, 데이터가 저장 되버리고 만다.
//		product1.setPrice(new BigDecimal("50"));
		productMap.put(product1, 100); // 기존 product1 키의 데이터를 대치해서 저장한다.
		
		System.out.println(productMap);
		// -------------------------------------------------------------
		// good practice 요약
		// 1. HashMap의 키는 되도록 immutable 타입을 사용한다.
		// 2. Mutable 타입을 키로 쓸 경우 키로 사용 후 상태를 변경하지 않는다.
		// 3. HahsSet의 경우도 일단 Set 안에 넣은 object는 상태를 변경하지 않는다.
		// -------------------------------------------------------------
		
	}

}
