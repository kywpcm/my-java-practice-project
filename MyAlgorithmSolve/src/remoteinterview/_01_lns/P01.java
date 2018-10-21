package remoteinterview._01_lns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P01 {

    // 10 30 25 100 80 90 400 10 30
    // 10 20 10 10 10 20

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        try {
            input = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] prices = input.split("\\s");
        List<String> list = new ArrayList<>();
        for (String price : prices)
            list.add(price);
        // test
//        System.out.println(list);

        List<Integer> reList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!reList.contains(Integer.parseInt(list.get(i))))
                reList.add(Integer.parseInt(list.get(i)));
        }
        // test
//        System.out.println(reList);
        if (reList.size() < 3) {
            System.out.println("-1");
            return;
        }

        // 정렬
        reList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        // test
//        System.out.println(reList);

        System.out.println(reList.get(2));
    }

}
