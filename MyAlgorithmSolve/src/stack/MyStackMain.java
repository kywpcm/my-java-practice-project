package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import stack.MyStack;

public class MyStackMain {

	public static void main(String[] args) {

		int comNum = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			comNum = Integer.parseInt(br.readLine()); // 입력
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("숫자만 입력해 주세요.");
			return;
		}
		
		if (comNum < 1 || comNum > 10000 ) {
			System.out.println("1 이상 10000 이하의 수를 입력해 주세요.");
			return;
		}
		
		// 스택 생성
		MyStack stack = new MyStack();
		String comStr = "";
		String[] command = {};
		if (comNum > 0) {
			
			for (int i = 0; i < comNum; i++) {
				
				try {
					comStr = br.readLine(); // 입력
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				// 명령어 파싱
				command = comStr.split(" ");
				
				// 스택 서비스 호출
				if (command[0].equals("push")) {
					
					int pushNum = -1;
					try {
						pushNum = Integer.parseInt(command[1]);
					} catch (Exception e) {
						System.out.println("push X 형식으로 입력해 주세요. (X : 양의 정수)");
//						continue;
					}
					
					if (1 <= pushNum && pushNum <= 100000) {
						stack.push(pushNum);
					} else {
						System.out.println("push X의 X는 1 이상 100000 이하 입니다. 다음 명령으로...");
					}
					
				} else if (command[0].equals("pop")) {
					System.out.println(stack.pop());
				} else if (command[0].equals("size")) {
					System.out.println(stack.size());
				} else if (command[0].equals("empty")) {
					System.out.println(stack.empty());
				} else if (command[0].equals("top")) {
					System.out.println(stack.top());
				} else {
					System.out.println("해당하는 스택 서비스 없어요. 다음 명령으로...");
				}
				
			}
			
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
			return;
		}
		
	}
	
}
