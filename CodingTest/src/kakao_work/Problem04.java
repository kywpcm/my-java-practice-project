package kakao_work;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem04 {

//  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {

//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//    String s = scanner.nextLine();
//    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
//
//    int res = programmerStrings(s);
//
//    bufferedWriter.write(String.valueOf(res));
//    bufferedWriter.newLine();
//
//    bufferedWriter.close();
//    scanner.close();

    String s = "progxrammerrxproxgrammer";
//    String s = "xprogxrmaxemrppprmmograeiruu";
//    String s = "programmerprogrammer";
//    String s = "pro";
//    String s = "programmer";
    int res = programmerStrings(s);
    System.out.println("result : " + res);
  }

  static int programmerStrings(String s) {

    // programmer

    String subStr1;
    String subStr2;
    int indexCnt = 0;
    for (int i = 10; i < s.length() - 10; i++) {
      subStr1 = s.substring(0, i); // 0 ~ 9
      subStr2 = s.substring(i + 1); // 11 ~

      if (haveCharsInStrs("p", 1, subStr1, subStr2) && haveCharsInStrs("r", 3, subStr1, subStr2) &&
          haveCharsInStrs("o", 1, subStr1, subStr2) && haveCharsInStrs("g", 1, subStr1, subStr2) &&
          haveCharsInStrs("a", 1, subStr1, subStr2) && haveCharsInStrs("m", 2, subStr1, subStr2) &&
          haveCharsInStrs("e", 1, subStr1, subStr2)) {
        indexCnt++;
      }
    }

    return indexCnt;
  }

  private static boolean haveCharsInStrs(String ch, int cnt, String subStr1, String subStr2) {
    Pattern pattern = Pattern.compile(ch);
    Matcher matcher1 = pattern.matcher(subStr1);
    Matcher matcher2 = pattern.matcher(subStr2);

    int mCnt = 0;
    while (matcher1.find() && matcher2.find()) {
      mCnt++;
      if (mCnt == cnt) {
        return true;
      }
    }
    return false;
  }
}
