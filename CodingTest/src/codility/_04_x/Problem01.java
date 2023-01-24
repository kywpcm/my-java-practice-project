package codility._04_x;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem01 {

    public static void main(String[] args) {

        /*
         * 이메일 리스트 구하는 문제
         * - 이름은 최대 Mary Jane Watson-Parker와 같이 first (middle) last로 올 수 있음
         * - last name엔 '-'이 포함될 수 있음
         * - 모두 소문자
         * - doeJ@example.com이 원하는 이메일 주소 형식
         * - 단, 같은 doeJ이 있을 경우 doeJ2, doeJ3과 같은 식으로 넘버링
         * - 입력 이름 순서와 출력 이메일 순서는 같아야 함
         */

        String S = "John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";
        String C = "Example";

        Problem01 p01 = new Problem01();
        System.out.println(p01.solution(S, C));
    }


    public String solution(String S, String C) {

        StringBuilder sb = new StringBuilder();

        String s = S.toLowerCase();
        String c = C.toLowerCase();

        String[] names = s.split(", ");
        String fullName;
        String[] partialNames;
        String lastName;
        String firstNameInit;
        for (int i = 0; i < names.length; i++) { // 각 이름 loop

            fullName = names[i];
            partialNames = fullName.split("\\s");

            lastName = partialNames[partialNames.length - 1].replaceAll("-", "");
            firstNameInit = partialNames[0].substring(0, 1);

            // 패턴 매칭
            int cnt = 0;
            if (sb.length() > 0) {
                Pattern p = Pattern.compile(lastName + firstNameInit);
                Matcher m = p.matcher(sb.toString());
                // 갯수 세기
                while (m.find()) {
                    cnt++;
                }
            }

            if (cnt > 0)
                sb.append(lastName).append(firstNameInit).append(cnt + 1).append("@").append(c).append(".com");
            else sb.append(lastName).append(firstNameInit).append("@").append(c).append(".com");
            if (i != names.length - 1) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }

}
