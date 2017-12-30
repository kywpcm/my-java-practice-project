
public class Main {

	public static void main(String[] args) {

		/*
		 * 참고
		 * - 에버노트 : [Java] 정규식 (regular expression)
		 * - http://blog.daum.net/feelsogreat/83
		 * - https://blog.outsider.ne.kr/360
		 */
		
		System.out.println("1. " + "aaa101bbb".replaceAll("101", "❤"));
		System.out.println("2. " + "aaa?bbb".replaceAll("[?]", "❤"));
		System.out.println("3. " + "aaa!bbb".replaceAll("!", "❤"));
		System.out.println("4. " + "aaa\nbbb".replaceAll("\n", "❤"));
		System.out.println("5. " + "aaa\"bbb".replaceAll("\"", "❤"));
		System.out.println("6. " + "aaa\\bbb".replaceAll("\\\\", "❤"));
		System.out.println("7. " + "aaa(bbb".replaceAll("\\(", "❤"));
		System.out.println("8. " + "aaa[bbb".replaceAll("\\[", "❤"));
		
		System.out.println("9. " + "aaabbb".replaceAll("^a", "❤"));
		System.out.println("10. " + "aaabbb".replaceAll("b$", "❤"));
		System.out.println("11. " + "abcdef1234".replaceAll("[a-c]", "❤")); // or
		System.out.println("12. " + "abcdef1234".replaceAll("[a-c0-9]", "❤"));
		System.out.println("13. " + "abcdef1234".replaceAll("[a-c0-9]{1,16}", "❤"));
		System.out.println("14. " + "abcdef1234".replaceAll("[a-c0-9]{3,16}", "❤")); // {3, 16}은 앞의 캐릭터들([a-c0-9])이 최소 3개에서 15개 이하로 나와야 함
		System.out.println("15. " + "abcdef1234".replaceAll("[a-c0-9]{4,16}", "❤"));
		System.out.println("16. " + "abcdef1234".replaceAll("[a-c0-9]{5,16}", "❤"));
		System.out.println("17. " + "abcdef1234".replaceAll("[0-9]{3}", "❤"));
		System.out.println("18. " + "abcdef1234".replaceAll("[0-9]{4}", "❤")); // 정확히 4개
		System.out.println("19. " + "abcdef1234".replaceAll("[0-9]{5}", "❤"));
		System.out.println("20. " + "abcdef1234abcdef1234abcdef1234".replaceAll("(abc)", "❤")); // 그룹화
		System.out.println("21. " + "abcdef1234abcdef1234abcdef1234".replaceAll("([a-c]|[0-9])", "❤"));
		
		/*
		 * . : 어떤 문자라도 1글자가 올 수 있음 (wild card)
		 * ? : 어떤 문자가 0번 또는 1번 나올 수 있음 (한정사)
		 * * : 어떤 문자가 0번 이상 나올수 있음 (한정사)
		 * + : 어떤 문자가 1번 이상 나올 수 있음 (한정사)
		 * ※ 한정사는 바로 앞의 문자에 적용된다.
		 */
		System.out.println("22. " + "ABa4BC44B".replaceAll("..B", "❤"));
		System.out.println("23. " + "ABa4BC44B".replaceAll("4.B", "❤"));
		System.out.println("24. " + "ABa4BC44B".replaceAll("4?B", "❤"));
		System.out.println("25. " + "ABa4BC44B".replaceAll("4*B", "❤"));
		System.out.println("25. " + "ABa4BC44B".replaceAll("4+B", "❤"));
		
		System.out.println("26. " + "ac41B4777B".replaceAll("4*B", "❤"));
		System.out.println("27. " + "ac41B4777B".replaceAll("4.*B", "❤"));
		System.out.println("28. " + "ac41B4777B".replaceAll("4.?B", "❤"));
		
	}

}
