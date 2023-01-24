package goorm._01_bm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem01 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        String inputRes = null;
        try {
            input = br.readLine();
            inputRes = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] splitedInput = input.split("\\s"); // TODO : 공백 여러개
        if (splitedInput.length > 20) {
            System.out.println("숫자는 최대 20개 까지입니다.");
            return;
        }

        int length = splitedInput.length;
        String str1, str2, str3;
        List<String> sumEqualNumberStr = new ArrayList<>();
        for (int i = 0; i <= length - 3; i++) {
            str1 = splitedInput[i];
            for (int j = i + 1; j <= length - 2; j++) {
                str2 = splitedInput[j];
                for (int k = j + 1; k <= length - 1; k++) {
                    str3 = splitedInput[k];

                    try {
                        int num1 = Integer.parseInt(str1);
                        int num2 = Integer.parseInt(str2);
                        int num3 = Integer.parseInt(str3);
                        if (num1 + num2 + num3 == Integer.parseInt(inputRes)) {
                            int[] sortedNums = new int[3];
                            sortedNums[0] = num1;
                            sortedNums[1] = num2;
                            sortedNums[2] = num3;
                            Arrays.sort(sortedNums);
                            sumEqualNumberStr.add(sortedNums[0] + " " + sortedNums[1] + " " + sortedNums[2]);
                        }
                    } catch (NumberFormatException nfe) {
                        System.out.println("입력은 숫자 형식입니다.");
                        nfe.printStackTrace();
                        return;
                    }
                }
            }
        }

        if (sumEqualNumberStr.isEmpty()) {
            System.out.println("NO");
        } else {
            // 아래로 오름차순 정렬
            Collections.sort(sumEqualNumberStr, new Comparator<String>() {

                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2); // ascending order
//                return o2.compareTo(o1); // descending order
                }
            });

            // 중복 제거
            List<String> resultList = new ArrayList<String>();
            for (int i = 0; i < sumEqualNumberStr.size(); i++) {
                if (!resultList.contains(sumEqualNumberStr.get(i))) {
                    resultList.add(sumEqualNumberStr.get(i));
                }
            }

            for (String str : resultList) {
                System.out.println(str);
            }
        }
    }

}
