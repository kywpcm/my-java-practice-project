package goorm._01_bm_practice_problem;

import java.util.Scanner;

public class Problem02 {

    /*
     * 윤년 (Leap Year)
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String resStr;

        if (n != 0 && n % 4 == 0) {
            // 윤년
            resStr = "Leap Year";
            if (n % 100 == 0) {
                // 평년
                resStr = "Not Leap Year";
                if (n % 400 == 0) {
                    // 윤년
                    resStr = "Leap Year";
                }
            }
        } else resStr = "Not Leap Year";

        System.out.println(resStr);
    }

}
