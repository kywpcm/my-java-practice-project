package problems;

import java.util.Scanner;

/**
 * 별찍기 - 1 풀이
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	23443	14417	13020	63.308%
문제
첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제

입력
첫째 줄에 N (1<=N<=100)이 주어진다.

출력
첫째 줄부터 N번째 줄 까지 차례대로 별을 출력한다.

예제 입력  복사
5
예제 출력  복사
*
**
***
****
*****
힌트
출처
문제를 만든 사람: baekjoon
문제의 오타를 찾은 사람: grace0068 hchanhong
 * 
 * @author kywpcm
 *
 */
public class PrintStar {

	// ...
	
	public void printStar() {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		
		String starStr = "*";
		
		for (int i = 1; i <= n; i++) {
			System.out.println(starStr);
			starStr += "*";
		}
		
	}
	
}
