package remoteinterview._01_lns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

        String[] prices = input != null ? input.split("\\s") : new String[0];

        // 중복 제거
        // 1. not contains 사용
//        List<Integer> reList = new ArrayList<>();
//        for (String price : prices) {
//            if (!reList.contains(Integer.parseInt(price)))
//                reList.add(Integer.parseInt(price));
//        }
        // 2. Set 사용
        Integer[] iPrices = new Integer[prices.length];
        for (int i = 0; i < prices.length; i++)
            iPrices[i] = Integer.parseInt(prices[i]);
        Set<Integer> priceSet = new HashSet<>(Arrays.asList(iPrices));
        iPrices = priceSet.toArray(new Integer[0]);

        if (priceSet.size() < 3) {
            System.out.println("-1");
            return;
        }

        // 정렬
//        reList.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
//            }
//        });
        Arrays.sort(iPrices);

//        System.out.println(reList.get(2));
        System.out.println(iPrices[2]);
    }

}
