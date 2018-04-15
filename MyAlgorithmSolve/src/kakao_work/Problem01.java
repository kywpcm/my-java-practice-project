package kakao_work;

public class Problem01 {

    public static void main(String[] args) {

        String inStr = "23511011501782351112179911801562340161171141148";

        Problem01 m01 = new Problem01();
        String re = m01.decode(inStr);
        System.out.println(re);
    }

    static String decode(String encoded) {

        StringBuilder sb = new StringBuilder();

        String encStr = ( new StringBuffer(encoded) ).reverse().toString();

        String token2;
        String token3;
        int i = 0;
        while (i <= encStr.length() - 2) {
            if (i == encStr.length() - 2) {
                token2 = encStr.substring(i);
            } else token2 = encStr.substring(i, i + 2);

            if ((65 <= Integer.parseInt(token2) && Integer.parseInt(token2) <= 99) || Integer.parseInt(token2) == 32) {
                sb.append((char)Integer.parseInt(token2));
                i = i + 2;
            } else {
                token3 = encStr.substring(i, i + 3);
                sb.append((char)Integer.parseInt(token3));
                i = i + 3;
            }
        }

        return sb.toString();
    }

}
