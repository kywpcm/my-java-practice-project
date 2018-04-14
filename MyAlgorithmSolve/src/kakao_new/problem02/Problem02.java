package kakao_new.problem02;

import java.util.Stack;

public class Problem02 {

    public static void main(String[] args) {

        Problem02 p02 = new Problem02();
        System.out.println(p02.sol("10S2D*3T"));
    }

    public int sol(String inScores) {

        Stack stack = new Stack();

//        char[] chScores = inScores.toCharArray();
        for (int i = 0; i < inScores.length(); i++) {
            char ch = inScores.charAt(i);
            String singleStr = String.valueOf(ch);

            // score
            String ifTen = "";
            if (i != inScores.length() - 1)
                ifTen = singleStr + String.valueOf(inScores.charAt(i + 1));
            if ( "10".equals(ifTen) ) {
                stack.push("10");
                i = i + 1;
            } else {
                stack.push(singleStr);
            }
        }
        // test
        for (int i = 1; i  <= 15; i++) {
            System.out.println(stack.pop());
        }

        return 0;
    }

}
