package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import problems.PrintStar;

public class Main {

	public static void main(String[] args) {

		int comNum = 0;

		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			comNum = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("comNum : " + comNum);
		
		if (comNum > 0) {
			
			for (int i = 0; i < comNum; i++) {
				// test
				System.out.println("i : " + i);
				
				
			}
			
		} else {
			return;
		}
		
	}

}
