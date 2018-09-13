package codility._05_ya;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02 {

    public static void main(String[] args) {
//        String S = "(())";
//        String S = "(())))(";
//        String S = "))";
//        String S = "((";
//        String S = "(";
//        String S = ")";
        String S = "())()(())(()())(((((((((((()))))))))))))()()()()()()()()())()()()()()((((((()))))()()())))()()";
        P02 p02 = new P02();
        System.out.println(p02.solution(S));
    }

    public int solution(String S) {
        int reValue = 0;

        String left = S.substring(0, S.length() / 2);
        String right = S.substring(S.length() / 2, S.length());
        // test
        System.out.println(left);
        System.out.println(right);

        // 패턴 매칭
        int leftCnt = 0;
        int rightCnt = 0;
        Pattern p = Pattern.compile("\\(");
        Matcher m = p.matcher(left);
        // 갯수 세기
        while (m.find()) {
            leftCnt++;
        }
        p = Pattern.compile("\\)");
        m = p.matcher(right);
        // 갯수 세기
        while (m.find()) {
            rightCnt++;
        }

        if (leftCnt < rightCnt) {
            for (int i = 0; i < right.length(); i++) {
                if (right.charAt(i) == '(') leftCnt++;
                else rightCnt--;

                if (leftCnt == rightCnt) {
                    reValue = left.length() + i + 1;
                    break;
                }
            }
        } else if (leftCnt > rightCnt) {
            for (int i = left.length() - 1; i >= 0; i--) {
                if (left.charAt(i) == '(') leftCnt--;
                else rightCnt++;

                if (leftCnt == rightCnt) {
                    reValue = left.length() - (i + 1);
                    break;
                }
            }
        } else reValue = left.length();

        return reValue;
    }

}
