package fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciNumbersMain {

	public static void main(String[] args) throws IOException {

		FibonacciNumbersMain me = new FibonacciNumbersMain();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("피보나치 수열의 길이를 입력해 주세요 ===> ");
		int length = Integer.parseInt(br.readLine());

		me.printFibonacci(length);

	}

	public void printFibonacci(int length) {

		long[] fiboArray;
		if (length > 0) {
			fiboArray = new long[length];
			if (length == 1) {
				System.out.println("1");
				return;
			} else if (length == 2) {
				System.out.println("1 1");
				return;
			} else if (length > 2) {
				fiboArray[0] = 1;
				fiboArray[1] = 1;
			}
		} else {
			System.out.println("양의 정수를 입력해 주세요.");
			return;
		}

		String fiboStr = "1 1";
		for (int i = 2; i < length; i++) {

			fiboArray[i] = fiboArray[i-1] + fiboArray[i-2];
			fiboStr = fiboStr + " " + String.format("%d", fiboArray[i]);
			// double number..
//			fiboStr = fiboStr + " " + String.format("%d", (long)fiboArray[i]);
//			fiboStr = fiboStr + " " + String.format("%.0f", fiboArray[i]);
		}

		System.out.println(fiboStr);

	}

}
