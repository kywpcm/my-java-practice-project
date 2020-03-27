package leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;

/**
 * Created by Kwon Youngwoo on 2020.03.26 5:07 오후
 */
public class P1209 {

  String[] abc = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

  public String removeDuplicates(String s, int k) {
    String regExp = makeRegExp(k);

    Pattern pattern = Pattern.compile(regExp);
    Matcher matcher = pattern.matcher(s);

    if (!matcher.find()) {
      return s;
    }
    matcher.reset();

    String replaced = null;
    while (matcher.find()) {
      replaced = matcher.replaceAll("");
    }

    return this.removeDuplicates(replaced, k);
  }

  private String makeRegExp(int k) {
    StringBuilder sb = new StringBuilder();
    sb.append("(");

    for (String s : abc) {
      for (int j = 0; j < k; j++) {
        sb.append(s);
      }
      if (s.equals("z")) sb.append(")");
      else sb.append(")|(");
    }

    return sb.toString();
  }

  @Test
  public void testRemoveDuplicates() {
    assertThat(removeDuplicates("pbbcggttciiippooaais", 2)).isEqualTo("ps");
//    assertThat(removeDuplicates("deeedbbcccbdaa", 3)).isEqualTo("aa");
//    assertThat(removeDuplicates("abcd", 2)).isEqualTo("abcd");
  }

  @Test
  public void testMakeRegExp() {
    String s = makeRegExp(5);
    System.out.println(s);
  }
}
