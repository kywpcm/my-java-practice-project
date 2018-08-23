package goorm._01_bm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem03 {

    /*
     * 입력 1
     * 2018/7/3 배민은행의 구조도를 손에 넣었다. 필요한 장비는 이런거 저런거 해서 각자 준비해야한다.
     * 타깃 은행은 잠실에 있는 배민은행으로 한다. 18년06월13일
     * 배민은행앞 별다방에서 18-06-12에 만나기로 함
     * END
     */

    /*
     * 입력 2
     * 배민은행앞 별다방에서 18-06-12에 만나기로 함
     * 타깃 은행은 잠실에 있는 배민은행으로 한다. 18년06월13일
     * 2018/7/3 배민은행의 구조도를 손에 넣었다. 필요한 장비는 이런거 저런거 해서 각자 준비해야한다.
     * END
     */

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        try {
            while (true) {
                String input = br.readLine();
                if (input.equals("END")) break;
                list.add(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // test
        for (String str : list)
            System.out.println("str : " + str);

        // String patternStr = "(19|20)\\d{2}[- /.]*(0[1-9]|1[012])[- /.]*(0[1-9]|[12][0-9]|3[01])"; // 날자를 패턴으로 지정

//        Pattern p = Pattern.compile("(20)?\\d{2}[/\\-년]+(0?[1-9]|1[012])[/\\-월]+(0?[1-9]|[12][0-9]|3[01])[일]?");
//        List<String> dateList = new ArrayList<>();
//        // 입력 순서대로
//        for (int i = 0; i < 3; i++) {
//            Matcher m = p.matcher(list.get(i));
//            String date = "";
//            if (m.find()) {
//                date = m.group();
//                String[] splitedStr = date.split("[/|\\-|[년월일]]");
//                if (splitedStr[0].length() == 2) { // 17, 18, ...
//                    splitedStr[0] = "20" + splitedStr[0];
//                }
//                if (splitedStr[1].length() == 1) { // 1 ~ 9
//                    splitedStr[1] = "0" + splitedStr[1];
//                }
//                if (splitedStr[2].length() == 1) { // 1 ~ 9
//                    splitedStr[2] = "0" + splitedStr[2];
//                }
//
//                dateList.add(splitedStr[0] + splitedStr[1] + splitedStr[2]);
//            }
//        }
//
//        // test
//        for (String str : dateList)
//            System.out.println(str);


        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
