package leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/n-th-tribonacci-number/">
 *   https://leetcode.com/problems/n-th-tribonacci-number/
 * </a>
 * <br>
 * Created by Kwon Youngwoo on 2022.11.08 9:30 AM
 */
public class P1137 {

    public int tribonacciRecursion(int n) {
        int result = 0;

        if (n == 0) {
            result = 0;
        } else if (n == 1) {
            result = 1;
        } else if (n == 2) {
            result = 1;
        } else if (n >= 3) {
            result = tribonacciRecursion(n - 1) + tribonacciRecursion(n - 2) + tribonacciRecursion(n - 3);
        }

        return result;
    }

    public int tribonacciDP(int n) {
        int[] tribonacciSeq = new int[38];
        tribonacciSeq[0] = 0;
        tribonacciSeq[1] = 1;
        tribonacciSeq[2] = 1;

        if (n < 3) {
            return tribonacciSeq[n];
        }

        int i = 3;
        while (i <= n) {
            tribonacciSeq[i] = tribonacciSeq[i - 1] + tribonacciSeq[i - 2] + tribonacciSeq[i - 3];
            i++;
        }

        return tribonacciSeq[n];
    }

    @Test
    public void testTribonacci() {
        assertThat(tribonacciDP(0)).isEqualTo(0);
        assertThat(tribonacciDP(1)).isEqualTo(1);
        assertThat(tribonacciDP(2)).isEqualTo(1);
        assertThat(tribonacciDP(3)).isEqualTo(2);
        assertThat(tribonacciDP(4)).isEqualTo(4);
        assertThat(tribonacciDP(25)).isEqualTo(1389537);
    }
}
