package main;

import java.util.*;

public class SortMain {

    public static void main(String[] args) {

        /* Create List */
        List<String> list = Arrays.asList("banana", "apple", "cup", "egg", "fire~", "desk");
        if (list instanceof ArrayList)
            System.out.println("ArrayList");
        else if (list instanceof List)
            System.out.println("List");

        /* List to Array */
        // 1.
        String[] array = (String[]) list.toArray();
        // 2.
        // param 배열의 형태로 런타임시에 리스트를 새로운 배열에 dump
        // 새로운 배열의 size는 param 배열의 size와 리스트의 size로 결정
//        String[] array = list.toArray(new String[0]);

        System.out.println();


        /* Collections 클래스 sort  */
        System.out.println("list before sort : " + list);
        Collections.sort(list, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2); // ascending order
//                return o2.compareTo(o1); // descending order
            }
        });
        /* List 인터페이스 구현체들의 sort (since 1.8) */
        list.sort(new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
//                return o1.compareTo(o2); // ascending order
                return o2.compareTo(o1); // descending order
            }
        });
        System.out.println("sorted list : " + list);


        System.out.println();


        /* Arrrays 클래스 sort */
        for (String item : array)
            System.out.println("array before sort : " + item);
        // 1.
        Arrays.sort(array);
        // 2.
//        Arrays.sort(array, new Comparator<String>() {
//
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2); // ascending order
////                return o2.compareTo(o1); // descending order
//            }
//        });
        for (String item : array)
            System.out.println("sorted array : " + item);


        /* Selection Sort (선택 정렬) */

        /* Insertion Sort (삽입 정렬) */

        /* Bubble Sort (거품 정렬) */

        /* Quick Sort (빠른 정렬) */

        /* Heap Sort (힙 정렬) */

    }

}
