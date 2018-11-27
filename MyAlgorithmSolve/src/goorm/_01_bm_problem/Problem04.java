package goorm._01_bm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class Problem04 {

  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;
    List<String> list = new ArrayList<>();
    try {
      while (true) {
        input = br.readLine();
        if (input.equals("END")) {
          break;
        }
        list.add(input);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    int tabSize = Integer.parseInt(list.get(0));
    list.remove(0);

    List<String> replacedCode = replaceTabToSpace(tabSize, list);

    for (String rCodeLine : replacedCode) {
      System.out.println(rCodeLine);
    }
  }

  public static List<String> replaceTabToSpace(int tabSize, List<String> code) {

    StringBuilder sb = new StringBuilder();
    List<String> replaceCode = new ArrayList<>();
    int spaceCnt = 0;

    for (String codeLine : code) {
      for (int i = 0; i < codeLine.length(); i++) {
        char c = codeLine.charAt(i);
        if (c == 32) { // space
          spaceCnt++;
          sb.append(c);
        } else if (c == 9) { // tab
          int diff = tabSize - (spaceCnt % tabSize);
          // tab 만큼 space 생성
          StringBuilder space = new StringBuilder();
          for (int j = 1; j <= diff; j++) {
            space.append(" ");
          }

          sb.append(space);
          spaceCnt = 0;
        } else { // other character
          // 나머지 전부 append 후 탈출
          sb.append(codeLine.substring(i));
          break;
        }
      }

      // 오른쪽 trim 후, list add
      replaceCode.add(sb.toString().replaceAll("(\\s|\t)*$", ""));
      sb.setLength(0); // StringBuilder 초기화
    }

    return replaceCode;
  }

  @Test
  public void replaceTabToSpaceTest() {
    List<String> code = new ArrayList<>();
    code.add("2");
    code.add("\tprintf");
    code.add(" \tprintf");
    code.add("  \tprintf");
    code.add("   \tprintf");
    code.add("    \tprintf");
    code.add("\tprintf printf\t\tprintf");
    code.add("\tprintf printf\t\tprintf ");
    code.add("\tprintf printf\t\tprintf\t");
    code.add("\tprintf printf\t\tprintf \t");
    code.add("\tprintf printf\t\tprintf         \t\t\t\t\t");

    int tabSize = Integer.parseInt(code.get(0));
    code.remove(0);

    List<String> replacedCode = replaceTabToSpace(tabSize, code);

    for (String rCodeLine : replacedCode) {
      System.out.println(rCodeLine);
    }
  }
}
