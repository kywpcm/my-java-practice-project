package codility._02_11;

public class Problem02 {

    public static void main(String[] args) {

        String E = "10:00";
        String L = "13:21";
//        String E = "09:42";
//        String L = "11:42";
//        String E = "00:00";
//        String L = "23:59";

        Problem02 p02 = new Problem02();
        System.out.println("total fee : " + p02.solution(E, L));
    }

    public int solution(String E, String L) {

        int totalFee = 2;

        int hourE;
        int minE;
        int totalMinE;
        int hourL;
        int minL;
        int totalMinL;

        int LMinusE;

        // String to time
        String[] strEs = new String[2];
        strEs = E.split(":");
        hourE = Integer.parseInt(strEs[0]);
        minE = Integer.parseInt(strEs[1]);
        totalMinE = hourE * 60 + minE;

        String[] strLs = new String[2];
        strLs = L.split(":");
        hourL = Integer.parseInt(strLs[0]);
        minL = Integer.parseInt(strLs[1]);
        totalMinL = hourL * 60 + minL;

        LMinusE = totalMinL - totalMinE; // 642 - 582

        // 요금 계산
        if (0 <= LMinusE && LMinusE <= 60) {
            totalFee = totalFee + 3;
        } else if (LMinusE > 60) {
            LMinusE = LMinusE - 60;
            totalFee += 3;

            totalFee = totalFee + (LMinusE / 60) * 4;
            if (LMinusE % 60 > 0)
                totalFee = totalFee + 4;
        }

        return totalFee;
    }

}
