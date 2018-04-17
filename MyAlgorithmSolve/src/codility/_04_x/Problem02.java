package codility._04_x;

public class Problem02 {

    public static void main(String[] args) {

        /*
         * Arithmetic sequence 갯수 구하는 문제
         * 1, 3, 5
         * 1, 3, 5, 7, 9
         * 2, 2, 2
         * 7, 4, 1, -2
         * - 위는 모두 Arithmetic sequence
         * - 항이 3개 이상이고, 등차가 모두 같으면 Arithmetic sequence
         * - 1, 3, 7, 4, 2에는 Arithmetic sequence이 하나도 없음
         * - 주어진 배열에서 Arithmetic sequence 갯수를 모두 구하는 문제
         * -1, 1, 3, 3, 3, 2, 1, 0
         * (-1, 1, 3), (3, 3, 3), (3, 2, 1), (3, 2, 1, 0), (2, 1, 0) => 총 5개
         */

        int[] A = {-1, 1, 3, 3, 3, 2, 1, 0};

        Problem02 p01 = new Problem02();
        System.out.println(p01.solution(A));
    }

    public int solution(int[] A) {

        if (A.length < 3)
            return 0;

        int count = 0;

        for (int i = 0; i < A.length - 2; i++) {
            int diff = 0;
            int interval = 0;
            for (int j = i + 1; j < A.length; j++) {

                interval = interval + 1;

                if (interval >= 2) {
                    if (diff == A[j] - A[j-1]) {
                        // 카운트 세기
                        count++;
                    } else break;
                }

                diff = A[j] - A[j-1];
            }
        }

        return count;
    }

}
