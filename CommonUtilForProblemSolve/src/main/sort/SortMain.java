package main.sort;

import java.util.*;

public class SortMain {

    public static void main(String[] args) {

        /* Create List */
        // 1. Arrays.asList()
        // 구현체는 ArrayList
        List<String> list = Arrays.asList("banana", "apple", "cup", "egg", "fire~", "desk");
        if (list instanceof ArrayList) System.out.println("ArrayList");
        else if (list instanceof List) System.out.println("List");

        /* List to Array */
        // 1. List.toArray()
//        String[] array = (String[]) list.toArray();
        // 2. List.toArray(T[])
        // param 배열의 형태로 런타임시에 리스트를 새로운 배열에 dump
        // 새로운 배열의 size는 param 배열의 size와 리스트의 size로 결정
        String[] array = list.toArray(new String[0]);
        System.out.println();



        /* 리스트 Sort */
        // 1.Collections.sort - 내부에서 List.sort 호출
        System.out.println("list before sort : " + list);
        Collections.sort(list, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2); // ascending order
//                return o2.compareTo(o1); // descending order
            }
        });
        // 2.List.sort (since 1.8) - 내부에서 Arrays.sort 사용
        list.sort(new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
//                return o1.compareTo(o2); // ascending order
                return o2.compareTo(o1); // descending order
            }
        });
        System.out.println("sorted list : " + list);
        System.out.println();



        /* 배열 Sort */
        for (String item : array)
            System.out.println("array before sort : " + item);
        // 1. Arrays.sort - primitive type
        // DualPivotQuicksort 사용. 평균 nlogn 기대할 수 있지만, 최악의 경우 n^2
//        int[] intArr = {4, 1, 3, 5, 2};
//        Arrays.sort(intArr);
        // 2. Arrays.sort - object type
        // Merge Sort 또는 TimSort 사용. 최악의 경우도 nlogn
        Arrays.sort(array, new Comparator<String>() { // Comparator 생략하면 디폴트 오름차순 정렬

            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2); // ascending order
//                return o2.compareTo(o1); // descending order
            }
        });
        for (String item : array)
            System.out.println("sorted array : " + item);



        /* Selection Sort (선택 정렬) - n^2 */

        /* Insertion Sort (삽입 정렬) n^2 */

        /* Bubble Sort (거품 정렬) n^2 */

        /* Quick Sort (빠른 정렬) nlogn or n^2 */

        /* Merge Sort (합병 정렬) - nlogn */

        /* Heap Sort (힙 정렬) - nlogn */

    }

}
