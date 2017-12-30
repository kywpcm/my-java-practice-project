package codility_second;

import java.util.ArrayList;

public class Problem01 {

	public static void main(String[] args) {

		Problem01 p01 = new Problem01();
		String S = ".We test coders. Give us a try?";
//		String S = ".Forget   CVs..Save time . x x!";
		System.out.println("largestCount : " + p01.solution(S));
		
	}

	public int solution(String S) {
		
		ArrayList<String> sentences = new ArrayList<>();
		int beginIndex = 0;
		for (int i = 0; i < S.length(); i++) {
			// test
			System.out.println(i + " : " + S.charAt(i));
			
			if (S.charAt(i) == '.' || S.charAt(i) == '?' || S.charAt(i) == '!') {
				sentences.add(S.substring(beginIndex, i));
				beginIndex = i + 1;
				// 마지막 구분자일 경우 처리
				if (beginIndex == S.length()) {
					sentences.add("");
				}
			}
			// 마지막 문자일 경우 처리
			if (i == S.length() - 1 && (S.charAt(i) != '.' && S.charAt(i) != '?' && S.charAt(i) != '!')) {
				sentences.add(S.substring(beginIndex, S.length()));
			}
		}
		
		// test
		System.out.println("sentences.length : " + sentences.size());
		for (String str : sentences) {
			System.out.println(str);
		}

		
		String[] words = null;
		int largestCount = 0;
		for (String sentence : sentences) {
			if (!sentence.isEmpty()) {
				sentence = sentence.replaceAll("^\\s", "").replaceAll("\\s$", "") // => trim()
						.replaceAll(" +", " ");

				words = sentence.split("\\s");
				if (largestCount < words.length) {
					largestCount = words.length;
				}
			}
		}
		
		return largestCount;
	}
	
}
