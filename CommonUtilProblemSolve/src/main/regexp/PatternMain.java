package main.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMain {

    public static void main(String[] args) {
        String input = "aaa kywpcm 123 kywpcm 가나다 kywpcm!!!";

//        String regex = "(kywpcm)";
        String regex = "(kywpcm)\\s?(가나다)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);

        System.out.println("시작.");
        System.out.println("input : " + input);
        System.out.println("Pattern : " + p.toString());
        System.out.println();
        int cnt = 0;
        while (m.find()) {
            cnt++;
            System.out.println("=======================" + cnt + "번 패턴 일치=====================");
            System.out.println("group : " + m.group());

            System.out.println("group(0) : " + m.group(0)); // group(0) = group()
            System.out.println("group(1) : " + m.group(1)); // regex에서 ()로 묶인 첫번째 그룹
//            System.out.println("group(2) : " + m.group(2)); // regex에서 ()로 묶인 두번째 그룹, 넘어가면 IOOB 익셉션 남
            System.out.println("group count : " + m.groupCount()); // group(0) 제외
            System.out.println();

            System.out.println("패턴 일치 start index : " + m.start());
            System.out.println("패턴 일치 end index : " + m.end());
            System.out.println();

            System.out.println("패턴과 input이 전체 일치하냐? " + m.matches()); // find() 수행
            System.out.println("=======================================================");
            System.out.println();
        }
    }

}
