package codility._02_11;

import java.util.ArrayList;
import java.util.List;

public class Problem01 {

    public static void main(String[] args) {

        Problem01 p01 = new Problem01();
        String S = ".We test coders. Give us a try?";
//		String S = ".Forget   CVs..Save time . x x!";
        System.out.println("largestCount : " + p01.solution(S));

    }

    public int solution(String S) {

        List<String> sentences = new ArrayList<>();
        int beginIndex = 0;
        for (int i = 0; i < S.length(); i++) {
            // test
            System.out.println(i + " : " + S.charAt(i));

            if (S.charAt(i) == '.' || S.charAt(i) == '?' || S.charAt(i) == '!') {
                sentences.add(S.substring(beginIndex, i));
                beginIndex = i + 1;
                // 마지막 구분자일 경우 처리
                if (i == S.length() - 1) {
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


        String[] words;
        int largestCount = 0;
        for (String sentence : sentences) {
            if (!sentence.isEmpty()) {
//				sentence = sentence.replaceAll("^\\s", "").replaceAll("\\s$", "") // => trim()
//						.replaceAll(" +", " "); // + : 어떤 문자가 1번 이상 나올 수 있음 (한정사)
                sentence = sentence.trim();

                words = sentence.split("\\s+");
                if (largestCount < words.length) {
                    largestCount = words.length;
                }
            }
        }

        return largestCount;
    }

}
