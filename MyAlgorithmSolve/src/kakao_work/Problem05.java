package kakao_work;

public class Problem05 {

  public static void main(String[] args) {
    int a = 1234;
    int b = 1213;
    long res = findSimilar(a, b);
    System.out.println("result : " + res);
  }

  static long findSimilar(long a, long b) {

    long ret;
    String strA = String.valueOf(a);
    String strB = String.valueOf(b);

    if (strA.length() != strB.length()) // not similar
      getNumberOfCases(strB);
    else {
      boolean aHaveBChars = true;
      for (int i = 0; i < strB.length(); i++) {
        if (!strA.contains(String.valueOf(strB.charAt(i))))
          aHaveBChars = false;
      }

      if (!aHaveBChars)
        ret = getNumberOfCases(strB); // not similar
      else ret = getNumberOfCases(strA); // similar
    }

    return -1;
  }

  // TODO
  private static long getNumberOfCases(String numStr) {

    char[] charArray = numStr.toCharArray();
    for (int i = 0; i < numStr.length(); i++) {
      int cntNum = 0;
      for (int j = i + 1; j < numStr.length(); j++) {
        if (charArray[i] == charArray[j])
          cntNum++;
      }
//            factorial(cntNum);
    }

    return -1;
  }
}
