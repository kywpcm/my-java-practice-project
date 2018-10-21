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
        System.out.println();



        /* Map 정렬 */

        // 1. key 기준 정렬

        // LinkedHashMap 사용
        // 넣는 순서대로 순서 보장
        Map<Integer, String> map = new LinkedHashMap<>();
//        Map<Integer, String> map = new HashMap<>();
        map.put(4, "권영우4");
        map.put(5, "권영우5");
        map.put(6, "권영우6");
        map.put(1, "권영우1");
        map.put(2, "권영우2");
        map.put(3, "권영우3");
        System.out.println(map);

        // TreeMap 사용
        // key 값을 기준으로 자동으로 정렬 해주는 자료구조
        Map<Integer, String> tm = new TreeMap<>(map);
        System.out.println(tm);


        // 2. value 기준 정렬
        // 임의의 리스트를 만들어서 정렬한다.
        System.out.println(map);
        List<Map.Entry<Integer, String>> list2 = new ArrayList<>(map.entrySet());
//        list2.addAll(map.keySet());
        list2.sort(new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {

                return o1.getValue().compareTo(o2.getValue());
            }
        });
        System.out.println(list2);
        // 리스트를 다시 맵으로 만들어 준다.
        Map<Integer, String> map2 = new LinkedHashMap<>();
        for (Map.Entry<Integer, String> e : list2)
            map2.put(e.getKey(), e.getValue());
        System.out.println(map2);



        /* Selection Sort (선택 정렬) - n^2 */

        /* Insertion Sort (삽입 정렬) n^2 */

        /* Bubble Sort (거품 정렬) n^2 */

        /* Quick Sort (빠른 정렬) nlogn or n^2 */

        /* Merge Sort (합병 정렬) - nlogn */

        /* Heap Sort (힙 정렬) - nlogn */

    }

}
