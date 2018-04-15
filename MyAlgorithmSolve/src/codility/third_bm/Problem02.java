package codility.third_bm;

import java.util.*;

public class Problem02 {

    public static void main(String[] args) {

        Problem02 p02 = new Problem02();
        String str = "photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
                "john.png, London, 2015-06-20 15:13:22\n" +
                "myFriends.png, Warsaw, 2013-09-05 14:07:13\n" +
                "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n" +
                "pisatower.jpg, Paris, 2015-07-22 23:59:59\n" +
                "BOB.jpg, London, 2015-08-05 00:02:03\n" +
                "notredame.png, Paris, 2015-09-01 12:00:00\n" +
                "me.jpg, Warsaw, 2013-09-06 15:40:22\n" +
                "a.png, Warsaw, 2016-02-13 13:33:50\n" +
                "b.jpg, Warsaw, 2016-01-02 15:12:22\n" +
                "c.jpg, Warsaw, 2016-01-02 14:34:30\n" +
                "d.jpg, Warsaw, 2016-01-02 15:15:01\n" +
                "e.png, Warsaw, 2016-01-02 09:49:09\n" +
                "f.png, Warsaw, 2016-01-02 10:55:32\n" +
                "g.jpg, Warsaw, 2016-02-29 22:13:11";
        System.out.println("result : " + p02.solution(str));

    }

    public String solution(String S) {

        String resultStr = "";

        // 1. list-map 구조 자료 만들기
        String[] strRows = S.split("\\n");
        String[] strCols = null;
        List<Map<String, Object>> photoList = new ArrayList<>(); // TODO : generic Object
        Map<String, Object> photoItem = null;

        for (int i = 0; i < strRows.length; i++) {
            strCols = strRows[i].replaceAll("\\s", "").split(",");
            photoItem = new HashMap<>();
            photoItem.put("file", strCols[0]);
            photoItem.put("city", strCols[1]);
            photoItem.put("time", strCols[2].replaceAll("[-:]", ""));
            photoList.add(photoItem);
        }
        // test
        System.out.println("photoList : " + photoList);
        for (Map<String, Object> item : photoList) {
            System.out.println(item);
        }

        // 2. city 기준 시간 순서에 따른 index 부여
        // 원본 백업
        List<Map<String, Object>> orgPhotoList = new ArrayList<>();
        orgPhotoList.addAll(photoList);
        // 도시별
        List<Map<String, Object>> photoListByCity = null;
        // 정렬 index 부여된 전체 list
        List<Map<String, Object>> indexedPhotoList = new ArrayList<>();

        while (photoList.size() != 0) {

            String city = (String) photoList.get(0).get("city");

            // 한 도시별 loop
            photoListByCity = new ArrayList<>();
            for (int j = 0; j < photoList.size(); j++) {

                String otherCity = (String) photoList.get(j).get("city");
                if (city.equals(otherCity)) {
                    photoListByCity.add(photoList.get(j));
                    photoList.remove(j);
                    j--;
                }
            } // 한 도시 loop 끝

            // test
            System.out.println("photoListByCity : " + photoListByCity);
            Collections.sort(photoListByCity, new Comparator<Map<String, Object>>() {
                @Override
                public int compare(Map<String, Object> first, Map<String, Object> second) {

                    return ((String) first.get("time")).compareTo((String) second.get("time")); // ascending order
//					return ( (String)second.get("time") ).compareTo( (String)first.get("time") ); // descending order
                }
            });
            // test
            System.out.println("photoListByCity : " + photoListByCity);

//			if (0 < photoListByCity.size() && photoListByCity.size() < 10) {
//				"aaa".foma
//			}
            int index = 1;
            for (Map<String, Object> map : photoListByCity) {
                if (0 < photoListByCity.size() && photoListByCity.size() < 10) {
                    map.put("index", index);
                } else if (10 <= photoListByCity.size() && photoListByCity.size() < 100) {
                    map.put("index", String.format("%02d", index));
                } else
                    map.put("index", String.format("%03d", index));
                index++;
            }
            // test
            System.out.println("photoListByCity : " + photoListByCity);
            indexedPhotoList.addAll(photoListByCity);

        }

        // 최종 list
        List<Map<String, Object>> finalPhotoList = new ArrayList<>();
        for (int i = 0; i < orgPhotoList.size(); i++) {

            Map<String, Object> orgItem = orgPhotoList.get(i);
            String time = (String) orgItem.get("time"); // key
            String index = "";
            for (int j = 0; j < indexedPhotoList.size(); j++) {
                if (time.equals((String) indexedPhotoList.get(j).get("time"))) {
                    index = String.valueOf(indexedPhotoList.get(j).get("index"));
                }
            }

            String city = (String) orgItem.get("city");
            city += index;
            String[] file = ((String) orgItem.get("file")).split("[.]");
            String ext = file[1];
            city = city + "." + ext;

            Map<String, Object> finalItem = new HashMap<String, Object>();
            finalItem.put("file", city);
            finalPhotoList.add(finalItem);
        }
        // test
        System.out.println("finalPhotoList : " + finalPhotoList);
        for (Map<String, Object> item : finalPhotoList) {
            System.out.println(item);

            resultStr = resultStr + item.get("file") + "\n";
        }

        return resultStr;
    }

}
