package etc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

/**
 * 기수 정렬 (Radix Sort)
 * Created by Kwon Youngwoo on 2020.03.30 1:26 오후
 */
public class RadixSort {

  public int[] radixSortLSD(int arraySize, int[] array) {

    int maaxDigit = getMaxDigitOfArray(array);

    // bucket 구성
    List<LinkedList<Integer>> counterBucket = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      counterBucket.add(i, new LinkedList<>());
    }

    int radix = 1;
    // O(dn)
    for(int i = 0; i < maaxDigit; i++, radix *= 10) { // 자릿수 순회 (d)
      for (int value : array) { // 각 array 순회 (n)
        int modularIndex =
            value / radix % 10; // 543 / 1 % 10 = 3, 543 / 10 % 10 = 4, 543 / 100 % 10 = 5
        LinkedList<Integer> counterNumbers = counterBucket.get(modularIndex);
        counterNumbers.offer(value);
        counterBucket.set(modularIndex, counterNumbers);
      }

      // 실제 ouput 배열(sorted)에 반영
      int pos = 0;
      for (LinkedList<Integer> counterNumbers : counterBucket) {
        while (!counterNumbers.isEmpty()) {
          array[pos++] = counterNumbers.poll();
        }
      }
    }

    return array;
  }

  private int getMaxDigitOfArray(int[] arrays) {
    int maxDigit = this.getDigitOfInteger(arrays[0]);
    for(int a : arrays) {
      int length = this.getDigitOfInteger(a);
      if (maxDigit < length)
        maxDigit = length;
    }
    return maxDigit;
  }

  // 참고: https://www.baeldung.com/java-number-of-digits-in-int
  private int getDigitOfInteger(int number) {
    int length = 0;
    long temp = 1;
    while (temp <= number) {
      length++;
      temp *= 10;
    }
    return length;
  }

  @Test
  public void testGetDigitOfInteger() {
    assertThat(getDigitOfInteger(143)).isEqualTo(3);
    assertThat(getDigitOfInteger(1)).isEqualTo(1);
    assertThat(getDigitOfInteger(0)).isEqualTo(0);
    assertThat(getDigitOfInteger(7953634)).isEqualTo(7);
  }

  @Test
  public void testGetMaxDigitOfArray() {
    int[] array = {0, 1, 10, 12, 135, 534, 6, 7, 60, 12345678, 7,7,7,7,7};
    assertThat(getMaxDigitOfArray(array)).isEqualTo(8);
  }

  @Test
  public void testRadixSortLSD() {
//    int[] array = {50, 20, 319, 218, 3, 99};
    int[] array = {51, 4, 3, 2, 1};
//    int[] array = {125, 383, 274, 96, 0, 9, 81, 72};
    assertThat(radixSortLSD(5, array))
        .isSorted()
        .containsExactly(1, 2, 3, 4, 51);
  }
}
