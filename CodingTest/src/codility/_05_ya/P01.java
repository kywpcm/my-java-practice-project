package codility._05_ya;

public class P01 {

    public static void main(String[] args) {
        int N = 1000;
        P01 p01 = new P01();
        p01.solution(N);
    }

    public void solution(int N) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (i % 2 == 0) sb.append("Codility");
            if (i % 3 == 0) sb.append("Test");
            if (i % 5 == 0) sb.append("Coders");

            if (sb.toString().isEmpty())
                System.out.println(i);
            else {
                System.out.println(sb.toString());
                sb.delete(0, sb.length());
            }
        }
    }

}
