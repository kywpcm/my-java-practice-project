package interrupt;

import java.io.IOException;

public class TerminateThreaMain {

	public static void main(String[] args) throws IOException {
		System.out.println("main start");
		
		TerminateThread tt1 = new TerminateThread("A");
		TerminateThread tt2 = new TerminateThread("B");
		TerminateThread tt3 = new TerminateThread("C");
		
		tt1.start();
		tt2.start();
		tt3.start();
		
		int i;
		System.out.println("종료할 스레드를 선택하세요. A, B, C, M?\n");
		while(true) {
			i = System.in.read(); // ..!?
			if(i == 'A')
				tt1.setTerminateFlag(true);
			else if(i == 'B')
				tt2.setTerminateFlag(true);
			else if(i == 'C')
				tt3.setTerminateFlag(true);
			else if(i == 'M') {
				tt1.setTerminateFlag(true);
				tt2.setTerminateFlag(true);
				tt3.setTerminateFlag(true);
				System.out.println("main end");
				break;
			}
		}
	}

}
