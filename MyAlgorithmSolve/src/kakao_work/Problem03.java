package kakao_work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem03 {

    public static void main(String[] args) {

//        int[] collection = {4, 6, 12, 8};
        int[] collection = {1, 3, 4};
//        int[] collection = {1, 2, 3, 4, 5};
//        int[] collection = {1, 3};
        int d = 7;

        Problem03 m03 = new Problem03();
        int[] re = m03.hackerCards(collection, d);
        for (int i = 0; i < re.length; i++)
            System.out.println(re[i]);
    }

    public int[] hackerCards(int[] collection, int d) {

        List<Integer> list = new ArrayList<>();
//        int[] result = new int[100000];
        Arrays.sort(collection);

        int diff;
        int min;
//        int index = 0;
        for (int i = 0; i < collection.length; i++) {
            if (i == 0)
                diff = collection[i] - 0;
            else diff = collection[i] - collection[i - 1];

            if (diff > 1) {

                int numOfDiff = diff - 1;
                for (int inc = 1; inc <= numOfDiff; inc++) {
                    if (i == 0)
                        min = 0 + inc;
                    else min = collection[i - 1] + inc;

                    d = d - min;
//                    result[index++] = min;
                    list.add(min);
                    if (min >= d) {
                        int[] array = new int[list.size()];
                        int size = 0;
                        for (Integer a : list) {
                            array[size++] = a;
                        }
                        return array;
                    }
                }
            }
        }

        list.add(d);
        int[] array = new int[list.size()];
        int size = 0;
        for (Integer a : list) {
            array[size++] = a;
        }
        return array;
    }

}
