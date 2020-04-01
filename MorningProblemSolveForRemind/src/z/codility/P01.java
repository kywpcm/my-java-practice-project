package z.codility;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Test;

/**
 * Created by Kwon Youngwoo on 2020.03.30 8:10 오후
 */
public class P01 {

  public int solution(int[] A) {

    Map<Integer, NumberCount> map = new LinkedHashMap<>();

    for (int a : A) {
      if (!map.containsKey(a)) {
        map.put(a, new NumberCount(1));
      } else {
        NumberCount numberCountObj = map.get(a);
        numberCountObj.count++;
      }
    }

    int max = 0;
    for (Map.Entry<Integer, NumberCount> entry : map.entrySet()) {
      NumberCount numberCountObj = entry.getValue();
      if (entry.getKey() == numberCountObj.count) {
        if (max < numberCountObj.count) max = numberCountObj.count;
      }
    }

    return max;
  }

  private class NumberCount {
    public int count;

    public NumberCount(int count) {
      this.count = count;
    }
  }

  @Test
  public void test() {
    int[] array = {3, 8, 2, 3, 3, 2};
    System.out.println(solution(array));
  }
}
