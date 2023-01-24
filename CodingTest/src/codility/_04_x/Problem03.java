package codility._04_x;

import java.util.Stack;

public class Problem03 {

    public static void main(String[] args) {

        // test
//        integerBitCountTest();

        String S = "13 DUP 4 POP 5 DUP + DUP + -";
//        String S = "5 6 + -";
//        String S = "3 DUP 5 - -";
//        String S = "0 1048575 DUP - POP POP";
//        String S = "1048576";
//        String S = "99999999999";
//        String S = "";
//        String S = "3 3 2 DUP POP + -";

        Problem03 p03 = new Problem03();
        System.out.println(p03.solution(S));
    }

    public int solution(String S) {

        if (S.isEmpty()) return -1;

        Stack<Integer> stack = new Stack<>();

        String[] ops = S.split("\\s");
        try {
            for (String op : ops) {
                switch (op) {
                    case "POP":
                        stack.pop();
                        break;
                    case "DUP":
                        stack.push(stack.peek());
                        break;
                    case "+":
                        plus(stack);
                        break;
                    case "-":
                        minus(stack);
                        break;
                    default: // Integer
                        Integer num = Integer.valueOf(op);
                        if (Integer.toBinaryString(num).length() > 20)
                            throw new NumberFormatException("Number Format Exception");
                        stack.push(num);
                        break;
                }
            }
        } catch (RuntimeException re) {
            return -1;
        }

        if (stack.isEmpty()) return -1;

        return stack.pop();
    }

    private void plus(Stack<Integer> stack) {
        Integer sum = stack.pop() + stack.pop();
        if (Integer.toBinaryString(sum).length() > 20)
            throw new ArithmeticException("Sum Overflow");
        stack.push(sum);
    }

    private void minus(Stack<Integer> stack) {
        Integer i1 = stack.pop();
        Integer i2 = stack.pop();
        Integer minus = i1 - i2;
        if (minus < 0)
            throw new ArithmeticException("Minus Underflow");
        stack.push(minus);
    }

    //    @Test
    public static void integerBitCountTest() {
        int a = 10;
        int b = 99999999;
        int c = 1048575;

        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(c));

        System.out.println(Integer.toBinaryString(a).length());
        System.out.println(Integer.toBinaryString(b).length());
        System.out.println(Integer.toBinaryString(c).length());
    }

}
