package z.codility;

import org.junit.Test;

/**
 * Created by Kwon Youngwoo on 2020.03.30 8:11 오후
 */
public class P04 {

  public String solution(String S, String C) {

    StringBuilder sb = new StringBuilder();
    boolean isFirstCornerCase = true;
    int count = 1;

    String[] names = S.split("; ");
    for (String name : names) {
      String[] splitName = name.split(" ");
      int part = splitName.length;

      String lastName = splitName[part - 1];
      String fitstName = splitName[0];
      String emailAccount = lastName.replace("-", "") + "_" + fitstName;
      String temp = "<" + emailAccount + "@" + C + ".com>";
      String email = temp.toLowerCase();

      if (isFirstCornerCase) {
        sb.append(name).append(" ").append(email);
        isFirstCornerCase = false;
      } else {
        String lowerEmailAccount = emailAccount.toLowerCase();
        if (sb.toString().contains(lowerEmailAccount)) {
          int index = sb.toString().lastIndexOf(lowerEmailAccount);
          String num = sb.toString().substring(index + lowerEmailAccount.length(), index + lowerEmailAccount.length() + 1);
          if (num.equals("@"))
            email = email.replace(lowerEmailAccount, lowerEmailAccount + 2);
          else
            email = email.replace(lowerEmailAccount, lowerEmailAccount + (Integer.parseInt(num) + 1));
        }

        sb.append("; ").append(name).append(" ").append(email);
      }
    }

    return sb.toString();
  }

  @Test
  public void test() {
    String S = "John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker";
    String C = "Example";

    System.out.println(solution(S, C));
  }
}
