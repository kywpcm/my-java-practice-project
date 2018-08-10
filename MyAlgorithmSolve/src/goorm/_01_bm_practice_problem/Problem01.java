package goorm._01_bm_practice_problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem01 {

    /*
     * 약수 구하기
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> resList = new ArrayList<>();
        for (int modNum = 1; modNum <= n; modNum++) {
            if (n % modNum == 0)
                resList.add(modNum);
        }

        for (Integer resNum : resList) {
            System.out.print(resNum + " ");
        }
        System.out.println();
    }

}
