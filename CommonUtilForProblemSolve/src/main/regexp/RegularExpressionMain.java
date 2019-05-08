package main.regexp;

public class RegularExpressionMain {

	public static void main(String[] args) {

		/*
		 * 참고
		 * - 에버노트 : [Java] 정규식 (regular expression)
		 * - http://blog.daum.net/feelsogreat/83
		 * - https://blog.outsider.ne.kr/360
		 */
		
		System.out.println("1. " + "101aaab1b0b1".replaceAll("101", "❤")); // (101)과 동일
		System.out.println("2. " + "aaa?bbb".replaceAll("[?]", "❤"));
		System.out.println("3.1 " + "aaa?bbb".replaceAll("\\?", "❤"));
		System.out.println("3.2 " + "aaa.bbb".replaceAll("\\.", "❤"));
		System.out.println("3.3 " + "aaa(bbb".replaceAll("\\(", "❤"));
		System.out.println("3.4 " + "aaa[bbb".replaceAll("\\[", "❤"));
		System.out.println("4. " + "aaa!bbb".replaceAll("!", "❤"));
		System.out.println("5. " + "aaa\"bbb".replaceAll("\"", "❤"));
		System.out.println("6.1 " + "aaa\nbbb".replaceAll("\n", "❤"));
		System.out.println("6.2 " + "aaa\nbbb".replaceAll("\\n", "❤"));
		System.out.println("7.1 " + "aaa\n\rbbb".replaceAll("\n\r", "❤"));
		System.out.println("7.2 " + "aaa\n\rbbb".replaceAll("\\n\\r", "❤"));
		System.out.println("8.1 " + "aaa\tbbb".replaceAll("\t", "❤"));
		System.out.println("8.2 " + "aaa\tbbb".replaceAll("\\t", "❤"));
		System.out.println("9. " + "aaa bbb".replaceAll("\\s", "❤"));
		System.out.println("10. " + "aaa\\bbb".replaceAll("\\\\", "❤"));
		
		System.out.println("11. " + "aaabbb".replaceAll("^a", "❤"));
		System.out.println("12. " + "aaabbb".replaceAll("b$", "❤"));
		System.out.println("13. " + "abcdef1a2b3c4d".replaceAll("[a-c]", "❤")); // or // [a-c] == [abc]
		System.out.println("14. " + "abcdef1234".replaceAll("[a-c0-9]", "❤"));
		System.out.println("15. " + "abcdef1234".replaceAll("[a-c0-9]{1,16}", "❤"));
		System.out.println("16. " + "abcdef1234".replaceAll("[a-c0-9]{3,16}", "❤")); // {3, 16}은 앞의 캐릭터들([a-c0-9])이 최소 3개에서 최대 15개 이하로 나와야 함
		System.out.println("17. " + "abcdef1234".replaceAll("[a-c0-9]{4,16}", "❤"));
		System.out.println("18. " + "abcdef1234".replaceAll("[a-c0-9]{5,16}", "❤"));
		System.out.println("19. " + "abcdef1234".replaceAll("[0-9]{3}", "❤"));
		System.out.println("20. " + "abcdef1234".replaceAll("[0-9]{4}", "❤")); // 정확히 4개
		System.out.println("21. " + "abcdef1234".replaceAll("[0-9]{5}", "❤"));
		System.out.println("22. " + "abcdef1234abcdef1234abcdef1234".replaceAll("(abc)", "❤")); // 그룹화
		System.out.println("23. " + "abcdef1234abcdef1234abcdef1a2b3c4d".replaceAll("([a-c]|[0-9])", "❤"));
		System.out.println("24. " + "abcdef1234abcdef1234abcdef1a2b3c4d".replaceAll("[a-c0-9]", "❤"));
		System.out.println("25. " + "abcdef1234abcdef1234abcdef1a2b3c4d".replaceAll("([a-c0-9])", "❤"));
		System.out.println("26. " + "abcdef1234abcdef1234abcdef1a2b3c4d".replaceAll("([a-c0-9]XXX)", "❤"));
		System.out.println("27. " + "abcdef1234abcdef1234abcdef1a2b3c4XXXd".replaceAll("([a-c0-9]XXX)", "❤"));

		/*
		 * . : 어떤 문자라도 1글자가 올 수 있음 (wild card)
		 * ? : 어떤 문자가 0번 또는 1번 나올 수 있음 (한정사)
		 * * : 어떤 문자가 0번 이상 나올수 있음 (한정사)
		 * + : 어떤 문자가 1번 이상 나올 수 있음 (한정사)
		 * ※ 한정사는 바로 앞의 문자에 적용된다.
		 */
		System.out.println("28. " + "ABa4BC44B".replaceAll("..B", "❤"));
		System.out.println("29. " + "ABa4BC44B".replaceAll("4.B", "❤"));
		System.out.println("30. " + "ABa4BC44B".replaceAll("4?B", "❤"));
		System.out.println("31. " + "ABa4BC44B".replaceAll("4*B", "❤"));
		System.out.println("32. " + "ABa4BC44B".replaceAll("4+B", "❤"));
		
		System.out.println("33. " + "ac41B4777B".replaceAll("4*B", "❤"));
		System.out.println("34. " + "ac41B4777B".replaceAll("4.*B", "❤"));
		System.out.println("35. " + "ac41B4777B".replaceAll("4.?B", "❤"));

		// practice
		String regex = "(20|\\d{2})?\\d{2}[/\\-년]+(0?[1-9]|1[012])[/\\-월]+(3[01]|[12][0-9]|0?[1-9])[일]?";
		System.out.println("36. " + "2018/7/3".replaceAll(regex, "❤"));
		System.out.println("37. " + "2018/07/03".replaceAll(regex, "❤"));
		System.out.println("38. " + "18/12/31".replaceAll(regex, "❤"));
		System.out.println("39. " + "1918/12/31".replaceAll(regex, "❤"));
		System.out.println("40. " + "18년06월13일".replaceAll(regex, "❤"));
		System.out.println("41. " + "18년6월07일".replaceAll(regex, "❤"));
		System.out.println("42. " + "1918년6월07일".replaceAll(regex, "❤"));
		System.out.println("43. " + "18-06-12".replaceAll(regex, "❤"));
		System.out.println("44. " + "18-6-3".replaceAll(regex, "❤"));
		System.out.println("45. " + "18-6-03".replaceAll(regex, "❤"));
		System.out.println("46. " + "2018-6-03".replaceAll(regex, "❤"));
		System.out.println("47. " + "1918-01-01".replaceAll(regex, "❤"));

		// Pattern-Matcher 생각하면서 이해
		// () : capturing group
		// (?:) : non-capturing group
		// 참고 : https://stackoverflow.com/questions/3512471/what-is-a-non-capturing-group-what-does-do
	}

}
