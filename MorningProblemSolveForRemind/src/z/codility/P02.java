package z.codility;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.junit.Test;

/**
 * Created by Kwon Youngwoo on 2020.03.30 8:11 오후
 */
public class P02 {

  public int solution(int[] A) {

    Number[] numbers = new Number[A.length];
    for (int i = 0; i < A.length; i++) {
      numbers[i] = new Number(A[i], getSumOfDigit(A[i]));
    }

    Map<Integer, Set<Number>> map = new LinkedHashMap<>();
    for (Number number : numbers) {
      if (!map.containsKey(number.sumOfDigit)) {
        Set<Number> set = new TreeSet<>(new Comparator<Number>() {
          @Override
          public int compare(Number o1, Number o2) {
            return o1.num - o2.num;
          }
        });
        set.add(number);
        map.put(number.sumOfDigit, set);
      } else {
        Set<Number> set = map.get(number.sumOfDigit);
        set.add(number);
      }
    }

    int max = 0;
    for (Map.Entry<Integer, Set<Number>> entry : map.entrySet()) {
      int largestNum = 0;
      int secondLargestNum = 0;

      TreeSet<Number> treeSet = (TreeSet<Number>) entry.getValue();
      if (treeSet.size() > 1) {
        largestNum = treeSet.last().num;
        secondLargestNum = treeSet.lower(treeSet.last()).num;
        int newMax = largestNum + secondLargestNum;
        if (max < newMax) max = newMax;
      }
    }

    return max > 0 ? max : -1;
  }

  private int getSumOfDigit(int num) {
    int sum = 0;
    while (num > 0) {
      sum = sum + num % 10;
      num = num / 10;
    }
    return sum;
  }

  private class Number {
    int num;
    int sumOfDigit;

    public Number(int num, int sumOfDigit) {
      this.num = num;
      this.sumOfDigit = sumOfDigit;
    }
  }

  @Test
  public void test() {
//    int[] array = {51, 71, 17, 42};
//    int[] array = {42, 33, 60};
    int[] array = {51, 32, 43};
    System.out.println(solution(array));
  }
}
