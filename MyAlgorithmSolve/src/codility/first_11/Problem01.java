package codility.first_11;

public class Problem01 {

	public static void main(String[] args) {

		Problem01 p01 = new Problem01();
		p01.solution(78, 195378678);
		
	}

	public int solution(int A, int B) {

		String strA = String.valueOf(A);
		String strB = String.valueOf(B);
		
		int rtnIndex = strB.indexOf(strA);
		// test
		System.out.println(rtnIndex);
		
		return rtnIndex;
	}
	
}
