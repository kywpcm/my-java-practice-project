package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import problems.PrintStar;

public class Main {

	public static void main(String[] args) {

		int comNum = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			comNum = Integer.parseInt(br.readLine()); // 입력
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String comStr = "";
		if (comNum > 0) {
			
			for (int i = 0; i < comNum; i++) {
				
				try {
					comStr = br.readLine(); // 입력
				} catch (IOException e) {
					e.printStackTrace();
				}
				// test
				System.out.println("comStr : " + comStr);
				
				// 명령어 파싱..
				
				// 스택 클래스 서비스 호출..
			}
			
		} else {
			return;
		}
		
	}

}
