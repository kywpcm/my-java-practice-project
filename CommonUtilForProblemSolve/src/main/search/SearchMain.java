package main.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchMain {

    public static void main(String[] args) {

        /* Array 검색 */

        // Primitive Type
        int[] intArr = {4, 1, 3, 5, 2};
        Arrays.sort(intArr); // n^2
        int index = Arrays.binarySearch(intArr, 4); // logn
        // => n^2 * logn
        System.out.println("indexOf 4 : " + index); // 위치
        if (index > 0) // 포함 여부
            System.out.println("contains 4 : true");
        else System.out.println("contains 4 : false");
        System.out.println();

        // Object Type
        Integer[] wIntArr = {4, 1, 3, 5, 2};
        // Comparator 생략하면 디폴트 오름차순 정렬
        Arrays.sort(wIntArr); // nlogn
        index = Arrays.binarySearch(wIntArr, 4); // logn
        // => n * (logn)^2

        // List
        List<Integer> list1 = Arrays.asList(wIntArr);
        System.out.println("indexOf 4 : " + list1.indexOf(4)); // 위치, O(n)..?
        System.out.println("contains 4 : " + list1.contains(4)); // 포함 여부, O(n)..?
        System.out.println();


        /* List 검색 */

        String[] strArr = {"apple", "banana", "cup", "desk", "egg"};
        List<String> list2 = Arrays.asList(strArr);
        System.out.println("key: 2 => contents: " + list2.get(2)); // 검색, O(1)
        System.out.println("indexOf cup : " + list2.indexOf("cup")); // contents 위치, O(n)..?
        System.out.println("contains cup : " + list2.contains("cup")); // contents 포함 여부, O(n)..?

        /* List-Map 검색 */


        Map<String, Object> map = new HashMap<>();
        map.keySet();
    }

}
