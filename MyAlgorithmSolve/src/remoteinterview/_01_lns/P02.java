package remoteinterview._01_lns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P02 {

    // 3
    // 12
    // 24

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        try {
            input = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
//         System.out.println(input);

        List<Map<String, Integer>> list = primeFactor(Integer.parseInt(input));

        int factorCnt = 1;
        int size = list.size();
        if (size == 1) {
            System.out.print(list.get(0).get("prime") + "^" + list.get(0).get("count"));
            factorCnt *=  (list.get(0).get("count") + 1);
        } else if (size > 1) {
            System.out.print(list.get(0).get("prime") + "^" + list.get(0).get("count"));
            factorCnt *=  (list.get(0).get("count") + 1);
            for (int i = 1; i < size; i++) {
                Map<String, Integer> map = list.get(i);
                System.out.print(" * " + map.get("prime") + "^" + map.get("count") );
                factorCnt *=  (map.get("count") + 1);
            }
        }
        System.out.println("\n" + factorCnt);
    }

    private static List<Map<String, Integer>> primeFactor(int num) {
        List<Map<String, Integer>> list = new ArrayList<>();
        int n = 2;
        int cnt = 1;
        while (num > 1) {
            if (num % n == 0) {
                num = num / n;
                Map<String, Integer> map = new HashMap<>();
                map.put("prime", n);
                map.put("count", cnt);
                int lastIdx = list.size() - 1;
                if (!list.isEmpty() && list.get(lastIdx).get("prime") == n)
                    list.remove(lastIdx);
                list.add(map);
                cnt++;
            } else {
                n++;
                cnt = 1;
            }
        }
        // test
//        System.out.println(list);
        return list;
    }

}
