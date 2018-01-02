package codility.third;

public class Problem04 {

	public static void main(String[] args) {
		
		// binary search..
		
		Problem04 p04 = new Problem04();
//		int[] intAry= {1, 2, 5, 9, 9};
		int[] intAry= {1, 2, 5, 5, 9, 10, 11};
//		int searchNum = 5;
		int searchNum = 23;
		System.out.println("result : " + p04.solution(intAry, searchNum));

	}

	int solution(int[] A, int X) {

		int N = A.length;
		if (N == 0) {
			return -1;
		}
		
		int l = 0;
		int r = N - 1;
		while (l < r) {
			int m = (l + r) / 2;
			if (A[m] > X) {
				r = m - 1;
			} else if (A[m] < X) {
				l = m + 1;
			} else return m;
		}
		if (A[l] == X) {
			return l;
		}

		return -1;
	}
	
}
