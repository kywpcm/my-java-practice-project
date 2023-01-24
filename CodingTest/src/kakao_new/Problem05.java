package kakao_new;

public class Problem05 {

    static final int MULTY = 65536;

    public static void main(String[] args) {

        JaccardSimilarity j1 = new JaccardSimilarity();

//        String str1 = "FRANCE";
//        String str2 = "french";
//        String str1 = "handshake";
//        String str2 = "shake hands";
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";
//        String str1 = "E=M*C^2";
//        String str2 = "e=m*c^2";

        System.out.println((int) (j1.proc(str1, str2) * MULTY));
    }

}
