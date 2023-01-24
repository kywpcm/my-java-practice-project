package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/longest-common-prefix/">
 *   https://leetcode.com/problems/longest-common-prefix/
 * </a>
 * <br>
 * Created by Kwon Youngwoo on 2022.11.14 6:33 PM
 */
public class P14 {

    public String longestCommonPrefix1(String[] strs) {
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String word = strs[i];

            if (prefix.length() > word.length()) {
                prefix = prefix.substring(0, prefix.length() - 1);
                i = 0;
                continue;
            } else {
                word = word.substring(0, prefix.length());
            }

            if (!word.contains(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                i = 0;
            }
        }

        return prefix;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    @Test
    public void testLongestCommonPrefix() {
//        String[] strings = {"flower", "flow", "flight"};
//        String[] strings = {"dog", "racecar", "car"};
        String[] strings = {"c","acc","ccc"};
//        String[] strings = {"ab", "a"};
//        String[] strings = {"cir", "car"};

//        Assertions.assertThat(longestCommonPrefix1(strings)).isEqualTo("fl");
//        Assertions.assertThat(longestCommonPrefix1(strings)).isEqualTo("");
        Assertions.assertThat(longestCommonPrefix2(strings)).isEqualTo("");
//        Assertions.assertThat(longestCommonPrefix1(strings)).isEqualTo("a");
//        Assertions.assertThat(longestCommonPrefix1(strings)).isEqualTo("c");
    }

    @Test
    public void testIndexOf() {
        String word = "kkcccapplebanana";
        String prefix = "apple";
        System.out.println(word.indexOf(prefix));
    }
}
