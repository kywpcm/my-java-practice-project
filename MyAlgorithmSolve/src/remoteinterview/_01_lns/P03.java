package remoteinterview._01_lns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P03 {

    // 1 3
    // 7 10
    // 2 6
    // 15 20

    // 1 3
    // 2 6

    // 1 3
    // 6 10
    // 2 6
    // 15 20

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;

        List<String[]> list = new ArrayList<>();

        try {
            while (true) {
                input = br.readLine();
                if (input.equals("END")) break;
                String[] fromTo = input.split("\\s");
                list.add(fromTo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // test
//        for (String str[] : list)
//            System.out.println(str[0] + " " + str[1]);
//        System.out.println();

        for (int i = 0; i < list.size(); i++) {
            String[] fromTo1 = list.get(0);
            String[] fromTo2;
            if (i != list.size() - 1)
                fromTo2 = list.get(i + 1);
            else break;

            String[] newFromTo = new String[2];
            if (Integer.parseInt(fromTo1[1]) >= Integer.parseInt(fromTo2[0])) {
                newFromTo[0] = fromTo1[0];
                newFromTo[1] = fromTo2[1];
                list.remove(0); list.remove(i);
                list.add(0, newFromTo);
                i = -1;
            }
        }

        for (String str[] : list)
            System.out.println(str[0] + " " + str[1]);
    }

}
