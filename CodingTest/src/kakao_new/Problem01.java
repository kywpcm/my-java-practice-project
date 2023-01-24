package kakao_new;

public class Problem01 {

    public static void main(String[] args) {

        // test
//        int a = 20; // 10100
//        int b = 28; // 11100
//
//        int aXorB = a ^ b;
//        System.out.println(aXorB);
//
//        String re = Integer.toBinaryString(aXorB);
//        System.out.println(re + "\n\n");
        // -----------


        Problem01 p01 = new Problem01();

//        int[] arr1 = {9, 20, 28, 18, 11};
//        int[] arr2 = {30, 1, 21, 17, 28};
//        String[] reArray = p01.sol(5, arr1, arr2);
        int[] arr1 = {46, 33, 33, 22, 31, 50};
        int[] arr2 = {27, 56, 19, 14, 14, 10};
        String[] reArray = p01.sol(6, arr1, arr2);

        for (String str : reArray) {
            System.out.println(str);
        }
    }

    public String[] sol(int n, int[] arr1, int[] arr2) {

        String[] retArray = new String[n];

        int aOrB;
        String strAOrB;
        for (int i = 0; i < n; i++) {
            aOrB = arr1[i] | arr2[i];
            strAOrB = Integer.toBinaryString(aOrB);
            strAOrB = String.format("%0" + n + "d", Integer.parseInt(strAOrB));
            // test
//            System.out.println(strAOrB);

            retArray[i] = strAOrB;
        }

        return retArray;
    }

}
