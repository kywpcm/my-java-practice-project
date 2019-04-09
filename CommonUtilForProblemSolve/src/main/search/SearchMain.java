package main.search;

import java.awt.*;
import java.util.*;
import java.util.List;

public class SearchMain {

    public static void main(String[] args) {

        /* Array 검색 */

        // 1. sort 후, Arrays.binarySearch
        // Primitive Type
        int[] intArr = {4, 1, 3, 5, 2};
        Arrays.sort(intArr); // n^2
        int index = Arrays.binarySearch(intArr, 4); // logn
        // => n^2 + logn

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
        // => nlogn + logn

        // 2. Arrays.asList 후, List 검색
        List<Integer> list1 = Arrays.asList(wIntArr);
        System.out.println("indexOf 4 : " + list1.indexOf(4)); // 위치, O(n)
        System.out.println("contains 4 : " + list1.contains(4)); // 포함 여부, O(n)
        System.out.println();



        /* List 검색 */

        String[] strArr = {"apple", "banana", "cup", "desk", "egg"};
        List<String> list2 = Arrays.asList(strArr);
        System.out.println("key: 2 => contents: " + list2.get(2)); // 검색, O(1)
        System.out.println("indexOf cup : " + list2.indexOf("cup")); // contents 위치, O(n)
        System.out.println("contains cup : " + list2.contains("cup")); // contents 포함 여부, O(n)
        System.out.println();

        /* List-Map 검색 */
        // List가 아니라 Map 자체를 순회해야 하는 경우
        List<Map<String, Object>> list3 = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>(); map1.put("name", "apple"); map1.put("count", 2);
        list3.add(map1);
        Map<String, Object> map2 = new HashMap<>(); map2.put("name", "banana"); map2.put("count", 3);
        list3.add(map2);
        Map<String, Object> map3 = new HashMap<>(); map3.put("name", "cup"); map3.put("count", 4);
        list3.add(map3);
        Map<String, Object> map4 = new HashMap<>(); map4.put("name", "desk"); map4.put("count", 5);
        list3.add(map4);
        Map<String, Object> map5 = new HashMap<>(); map5.put("name", "egg"); map5.put("count", 6);
        list3.add(map5);
        System.out.println(list3);

        // 1. Map.entrySet - n^2
        for (Map<String, Object> hMap : list3) {
            for (Map.Entry<String, Object> entry : hMap.entrySet())  { // Map 안의 name=apple, count=2 각각이 entry 임.
//                System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
                // Do something...
                // apple의 count 갯수
                if (entry.getKey().equals("name") && entry.getValue().equals("apple")) // 찾고자 하는 키가 name
                    System.out.println("apple count : " + hMap.get("count"));
            }
        }

        // 2. Map.keySet - n^2
        for (Map<String, Object> hMap : list3) {
            for (String key : hMap.keySet()) {
//                System.out.println("key : " + key + ", value : " + hMap.get(key));
                // Do something...
                // count가 4인 물건
                if ("count".equals(key) && (Integer) hMap.get(key) == 4) { // 찾고자 하는 키가 count
                    System.out.println("count가 4인 물건 : " + hMap.get("name"));
                }
            }
        }
        System.out.println();

        // 3. Iterator
        // List 혹은 Set 인터페이스를 구현하는 컬렉션은 iterator()가 컬렉션의 특징에 맞게 적절히 설계되어 있다.
        Iterator<Map<String, Object>> iter = list3.iterator();
        while(iter.hasNext()) {
            Map<String, Object> hMap = iter.next();
            Iterator<String> iter2 = hMap.keySet().iterator();
            while (iter2.hasNext()) {
                String key = iter2.next();
                System.out.println("key : " + key + ", value : " + hMap.get(key));
                // Do something...
            }
        }
    }

}
