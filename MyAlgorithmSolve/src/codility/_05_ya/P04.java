package codility._05_ya;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P04 {

    public static void main(String[] args) {
        int[] A = {5, 2, 4, 6, 3, 7};
        P04 p04 = new P04();
        System.out.println(p04.solution(A));
    }

    public int solution(int[] A) {
        Integer[] integerArray = Arrays.stream(A).boxed().toArray(Integer[]::new);
        // test
        System.out.println("integerArray : " + integerArray);
//        List<Integer> list = new ArrayList<>();
//        Collections.addAll(list, integerArray);

//        list.remove(0);
//        list.remove(list.size() - 1);

        // test
//        System.out.println("list : " + list);

//        integerArray = list.toArray(new Integer[0]);
//        Integer[] intArray = list.stream().mapToInt(Integer::intValue).toArray();
        Integer minValue = getMinValue(integerArray, integerArray.length - 1);
        // test
        System.out.println("minValue : " + minValue);

        int minValueIdx;
        while(true) {
            minValueIdx = Arrays.asList(integerArray).indexOf(minValue);
            if (minValueIdx != 0 && minValueIdx != integerArray.length - 1)
                break;
        }
//        int minValueIdx = Arrays.asList(integerArray).indexOf(minValue);
        // test
        System.out.println("minValueIdx : " + minValueIdx);

        Integer secMinValue = getSecMinValue(integerArray, integerArray.length - 1);
        System.out.println("secMinValue : " + secMinValue);

        int secMinValueIdx;
        while(true) {
            secMinValueIdx = Arrays.asList(integerArray).indexOf(secMinValue);
            if (secMinValueIdx != 0 && secMinValueIdx != integerArray.length - 1
                && secMinValueIdx != minValueIdx - 1 && secMinValueIdx != minValueIdx + 1)
                break;
        }
        // test
        System.out.println("secMinValueIdx : " + secMinValueIdx);

        return minValue + secMinValue;
    }

    private Integer getMinValue(Integer[] array, int idx) {
        Integer p;
        if (idx == 0)
            return array[idx];

        p = getMinValue(array, idx - 1);

        if (p < array[idx])
            return p;
        return array[idx];
    }

    private Integer getSecMinValue(Integer arr[], int n) {
        int i;
        Integer min = arr[0];
        Integer secondMin = min;

        for (i = 0; i < n; i++) {
            if (arr[i] < min) {
                secondMin = min;
                min = arr[i];
            } else if ((min < arr[i] && arr[i] < secondMin) || min.equals(secondMin))
                secondMin = arr[i];
        }

        return secondMin;
    }

}
