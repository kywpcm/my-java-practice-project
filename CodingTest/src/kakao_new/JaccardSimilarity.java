package kakao_new;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

class JaccardSimilarity {

    public double proc(String str1, String str2) {

        ArrayList<String> twoCharList1 = this.setTwoChar(str1);
        ArrayList<String> twoCharList2 = this.setTwoChar(str2);

        if (this.getIntersection(twoCharList1, twoCharList2) == 0) {
            return 1;
        } else {
            return this.getIntersection(twoCharList1, twoCharList2) / this.getUnion(twoCharList1, twoCharList2);
        }
    }

    private ArrayList<String> setTwoChar(String targetStr) {

        //공백 및 특수문자 제거
        targetStr = targetStr.replaceAll("\\p{Space}", "").replaceAll("[^\\uAC00-\\uD7A3xfe0-9a-zA-Z\\\\s]", "");
        ArrayList<String> twoCharList = new ArrayList<String>();

        for (int i = 0; i < targetStr.length() - 1; i++) {
            String strTemp = targetStr.substring(i, i + 2).toLowerCase();
            //숫자 포함여부 판단
            if (Pattern.matches("^[0-9]*$", strTemp.charAt(0) + "") == false && Pattern.matches("^[0-9]*$", strTemp.charAt(1) + "") == false)
                twoCharList.add(strTemp);
        }
        return twoCharList;
    }

    private double getUnion(ArrayList<String> targetOne, ArrayList<String> targetTwo) {
        Set<String> set = new HashSet<>();
        set.addAll(targetOne);
        set.addAll(targetTwo);
        return (double) set.size();
    }

    private double getIntersection(ArrayList<String> targetOne, ArrayList<String> targetTwo) {
        ArrayList<String> list = new ArrayList<String>();

        for (String strIter : targetOne) {
            if (targetTwo.contains(strIter)) {
                list.add(strIter);
            }
        }
        return (double) list.size();
    }

}
