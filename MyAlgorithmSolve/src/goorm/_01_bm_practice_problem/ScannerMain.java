package goorm._01_bm_practice_problem;

import java.util.Scanner;

public class ScannerMain {

    public static void main(String[] args) {
        // 123\r\n
        // abc\r\n
        // 123 한글 kywpcm is good!\r\n

        // Scanner는 표준 입력 Enter(newLine, 개행) 칠 때까지 입력을 받음
        Scanner scanner = new Scanner(System.in);

        // 구분자 token : 공백
        // Enter는 취급하지 않음
        int n = scanner.nextInt();
        System.out.println(n);

        // 구분자 token : 공백
        // Enter는 취급하지 않음
        String str = scanner.next();
        System.out.println(str);

        // 해결 방법
//        scanner.nextLine();

        // 구분자 token : 엔터
        // 공백도 데이터
        // Enter도 구분자 token으로 써야하기 때문에 들어옴
        String str2 = scanner.nextLine();
        System.out.println(str2);
    }

}
