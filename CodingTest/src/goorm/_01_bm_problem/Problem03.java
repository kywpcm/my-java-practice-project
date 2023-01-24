package goorm._01_bm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem03 {

    /*
     * 입력 1
     * 2018/7/3 배민은행의 구조도를 손에 넣었다. 필요한 장비는 이런거 저런거 해서 각자 준비해야한다.
     * 타깃 은행은 잠실에 있는 배민은행으로 한다. 18년06월13일
     * 배민은행앞 별다방에서 18-06-12에 만나기로 함
     * END
     */

    /*
     * 출력 1
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

        Pattern p = Pattern.compile("(20|\\d{2})?\\d{2}[/\\-년]+(0?[1-9]|1[012])[/\\-월]+(3[01]|[12][0-9]|0?[1-9])[일]?");

        List<Map<String, String>> memoDateList = new ArrayList<>();
        Map<String, String> map;
        // 입력 순서대로
        for (String memo : list) {
            Matcher m = p.matcher(memo);
            String date;
            if (m.find()) {
                map = new HashMap<>();
                map.put("memo", memo);

                date = m.group();
                // test
                System.out.println("date : " + date);

                String[] splitedDate = date.split("[/\\-년월일]");
                if (splitedDate[0].length() == 2) // 17, 18, ...
                    splitedDate[0] = "20" + splitedDate[0];
                if (splitedDate[1].length() == 1) // 1 ~ 9
                    splitedDate[1] = "0" + splitedDate[1];
                if (splitedDate[2].length() == 1) // 1 ~ 9
                    splitedDate[2] = "0" + splitedDate[2];

                map.put("date", splitedDate[0] + splitedDate[1] + splitedDate[2]);

                memoDateList.add(map);
            }
        }

        // test
        for (Map<String, String> item : memoDateList)
            System.out.println(item);

        // sort
        memoDateList.sort(new Comparator<Map<String, String>>() {
            @Override
            public int compare(Map<String, String> o1, Map<String, String> o2) {
                return o1.get("date").compareTo(o2.get("date")); // ascending order
//                return o2.compareTo(o1); // descending order
            }
        });
        for (Map<String, String> item : memoDateList)
            System.out.println(item.get("memo"));

        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
