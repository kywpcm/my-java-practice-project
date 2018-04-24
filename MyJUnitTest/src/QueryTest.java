import org.junit.Test;

public class QueryTest {

    private String input = "/*\n" +
            " * 쿼리 주석 제거 테스트\n" +
            " */\n" +
            "/**\n" +
            " * [PRODUCT_NAME description]\n" +
            " * @type {String}\n" +
            " */\n" +
            "/*\n" +
            " * 쿼리 주석 제거 테스트2\n" +
            " *\n" +
            " */\n" +
            "/*\n" +
            " * 쿼리 주석 제거 테스트3\n" +
            "\n" +
            " */\n" +
            "/* TYPE: 20 */\n" +
            "/* 매출수량 */\n" +
            "/*****************************************************   작업 완료    ***********************************************************/\n" +
            "SELECT /*+ 힌트*/\n" +
            "\t   T1.CODE\n" +
            "\t   , T1.NAME\n" +
            "\t   , T1.DATE\n" +
            "\t   , IFNULL(T2.SALES_COUNT, 0) AS SALES_COUNT\n" +
            "\t   \n" +
            "  FROM (SELECT PRODUCT_CD CODE, PRODUCT_NAME NAME, '201701' AS DATE FROM TB_CNC_PRODUCT WHERE PRODUCT_NAME = '나일론')\n" +
            "  \t\tT1 LEFT OUTER JOIN\n" +
            "\t\t(\n" +
            "\t\t\tSELECT\n" +
            "\t\t\t\tPLANT_CD\n" +
            "\t\t\t\t, PLANT_NAME\n" +
            "\t\t\t    , DATE_FORMAT(SALES_DATE, '%Y%m') SALES_DATE\n" +
            "\t\t\t    , (SUM(IF(ORDER_FLAG = 'ZOS', IF(UNIT = 'TO', SALES_COUNT * 1000, SALES_COUNT), 0))\n" +
            "\t\t\t    \t- SUM(IF(ORDER_FLAG = 'ZRES', IF(UNIT = 'TO', SALES_COUNT * 1000, SALES_COUNT), 0))) SALES_COUNT\n" +
            "\t\t\tFROM TB_CNC_BUSINESS\n" +
            "\t\t\tWHERE DATE_FORMAT(SALES_DATE, '%Y%m') BETWEEN '201701' AND '201704'\n" +
            "\t\t\t  AND BUSINESS_PART = '섬유'\n" +
            "-- \t\t\t  AND PLANT_NAME = '나일론'\n" +
            "\t\t\t  AND PLANT_NAME IN ('나일론', '아크릴', '스판덱스', 'LMF', '아라미드', '면방', '화섬방')\n" +
            "\t\t\t  AND EXCEL IS NULL\n" +
            "\t\t\tGROUP BY PLANT_CD, DATE_FORMAT(SALES_DATE, '%Y%m')\n" +
            "\t\t\t\n" +
            "\t\t\tUNION ALL\n" +
            "\t\t\t\n" +
            "\t\t\tSELECT\n" +
            "\t\t\t\tPLANT_CD\n" +
            "\t\t\t\t, PLANT_NAME\n" +
            "\t\t\t    , '2017.01 ~ 04' SALES_DATE\n" +
            "\t\t\t    , (SUM(IF(ORDER_FLAG = 'ZOS', IF(UNIT = 'TO', SALES_COUNT * 1000, SALES_COUNT), 0))\n" +
            "\t\t\t    \t- SUM(IF(ORDER_FLAG = 'ZRES', IF(UNIT = 'TO', SALES_COUNT * 1000, SALES_COUNT), 0))) SALES_COUNT\n" +
            "\t\t\tFROM TB_CNC_BUSINESS\n" +
            "\t\t\tWHERE DATE_FORMAT(SALES_DATE, '%Y%m') BETWEEN '201701' AND '201704'\n" +
            "\t\t\t  AND BUSINESS_PART = '섬유'\n" +
            "-- \t\t\t  AND PLANT_NAME = '나일론'\n" +
            "\t\t\t  AND PLANT_NAME IN ('나일론', '아크릴', '스판덱스', 'LMF', '아라미드', '면방', '화섬방')\n" +
            "\t\t\t  AND EXCEL IS NULL\n" +
            "\t\t\tGROUP BY PLANT_CD\n" +
            "\t\t\t\n" +
            "\t\t\tUNION ALL\n" +
            "\t\t\t\n" +
            "\t\t\tSELECT\n" +
            "\t\t\t\tPLANT_CD\n" +
            "\t\t\t\t, PLANT_NAME\n" +
            "\t\t\t    , DATE_FORMAT(SALES_DATE, '%Y') SALES_DATE\n" +
            "\t\t\t    , (SUM(IF(ORDER_FLAG = 'ZOS', IF(UNIT = 'TO', SALES_COUNT * 1000, SALES_COUNT), 0))\n" +
            "\t\t\t    \t- SUM(IF(ORDER_FLAG = 'ZRES', IF(UNIT = 'TO', SALES_COUNT * 1000, SALES_COUNT), 0))) SALES_COUNT\n" +
            "\t\t\tFROM TB_CNC_BUSINESS\n" +
            "\t\t\tWHERE DATE_FORMAT(SALES_DATE, '%Y') BETWEEN '2017' AND '2017'\n" +
            "\t\t\t  AND BUSINESS_PART = '섬유'\n" +
            "-- \t\t\t  AND PLANT_NAME = '나일론'\n" +
            "\t\t\t  AND PLANT_NAME IN ('나일론', '아크릴', '스판덱스', 'LMF', '아라미드', '면방', '화섬방')\n" +
            "\t\t\t  AND EXCEL IS NULL\n" +
            "\t\t\tGROUP BY PLANT_CD, DATE_FORMAT(SALES_DATE, '%Y')\n" +
            "\t\t\t\n" +
            "\t\t\tUNION ALL\n" +
            "\t\t\t\n" +
            "\t\t\tSELECT\n" +
            "\t\t\t\tPLANT_CD\n" +
            "\t\t\t\t, PLANT_NAME\n" +
            "\t\t\t    , DATE_FORMAT(SALES_DATE, '%Y%m') SALES_DATE\n" +
            "\t\t\t    , (SUM(IF(ORDER_FLAG = 'ZOS', IF(UNIT = 'TO', SALES_COUNT * 1000, SALES_COUNT), 0))\n" +
            "\t\t\t    \t- SUM(IF(ORDER_FLAG = 'ZRES', IF(UNIT = 'TO', SALES_COUNT * 1000, SALES_COUNT), 0))) SALES_COUNT\n" +
            "\t\t\tFROM TB_CNC_BUSINESS\n" +
            "\t\t\tWHERE DATE_FORMAT(SALES_DATE, '%Y%m') BETWEEN '201801' AND '201804'\n" +
            "\t\t\t  AND BUSINESS_PART = '섬유'\n" +
            "-- \t\t\t  AND PLANT_NAME = '나일론'\n" +
            "\t\t\t  AND PLANT_NAME IN ('나일론', '아크릴', '스판덱스', 'LMF', '아라미드', '면방', '화섬방')\n" +
            "\t\t\t  AND EXCEL IS NULL\n" +
            "\t\t\tGROUP BY PLANT_CD, DATE_FORMAT(SALES_DATE, '%Y%m')\n" +
            "\t\t\t\n" +
            "\t\t\tUNION ALL\n" +
            "\t\t\t\n" +
            "\t\t\tSELECT\n" +
            "\t\t\t\tPLANT_CD\n" +
            "\t\t\t\t, PLANT_NAME\n" +
            "\t\t\t    , '2018.01 ~ 04' SALES_DATE\n" +
            "\t\t\t    , (SUM(IF(ORDER_FLAG = 'ZOS', IF(UNIT = 'TO', SALES_COUNT * 1000, SALES_COUNT), 0))\n" +
            "\t\t\t    \t- SUM(IF(ORDER_FLAG = 'ZRES', IF(UNIT = 'TO', SALES_COUNT * 1000, SALES_COUNT), 0))) SALES_COUNT\n" +
            "\t\t\tFROM TB_CNC_BUSINESS\n" +
            "\t\t\tWHERE DATE_FORMAT(SALES_DATE, '%Y%m') BETWEEN '201801' AND '201804'\n" +
            "\t\t\t  AND BUSINESS_PART = '섬유'\n" +
            "-- \t\t\t  AND PLANT_NAME = '나일론'\n" +
            "\t\t\t  AND PLANT_NAME IN ('나일론', '아크릴', '스판덱스', 'LMF', '아라미드', '면방', '화섬방')\n" +
            "\t\t\t  AND EXCEL IS NULL\n" +
            "\t\t\tGROUP BY PLANT_CD\n" +
            "\t\t\t\n" +
            "\t\t\tUNION ALL\n" +
            "\t\t\t\n" +
            "\t\t\tSELECT\n" +
            "\t\t\t\tPLANT_CD\n" +
            "\t\t\t\t, PLANT_NAME\n" +
            "\t\t\t    , DATE_FORMAT(SALES_DATE, '%Y') SALES_DATE\n" +
            "\t\t\t    , (SUM(IF(ORDER_FLAG = 'ZOS', IF(UNIT = 'TO', SALES_COUNT * 1000, SALES_COUNT), 0))\n" +
            "\t\t\t    \t- SUM(IF(ORDER_FLAG = 'ZRES', IF(UNIT = 'TO', SALES_COUNT * 1000, SALES_COUNT), 0))) SALES_COUNT\n" +
            "\t\t\tFROM TB_CNC_BUSINESS\n" +
            "\t\t\tWHERE DATE_FORMAT(SALES_DATE, '%Y') BETWEEN '2018' AND '2018'\n" +
            "\t\t\t  AND BUSINESS_PART = '섬유'\n" +
            "-- \t\t\t  AND PLANT_NAME = '나일론'\n" +
            "\t\t\t  AND PLANT_NAME IN ('나일론', '아크릴', '스판덱스', 'LMF', '아라미드', '면방', '화섬방')\n" +
            "\t\t\t  AND EXCEL IS NULL\n" +
            "\t\t\tGROUP BY PLANT_CD, DATE_FORMAT(SALES_DATE, '%Y')\n" +
            "\t\t) T2\n" +
            "\t\tON T1.NAME = T2.PLANT_NAME AND T1.DATE = T2.SALES_DATE";


    public String removeComment(String query) {
//		return query.replaceAll("/\\*(?:.|[\\n\\r])*?\\*/\n", "");
        return query.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)", "");
    }

    public String removeCommentMo(String query) {
        int length = query.length();
        int curIdx = 0;
        int startIdx = 0;
        int endIdx = 0;
        String resStr = "";

        while (curIdx < length) {
            startIdx = query.indexOf("*/", curIdx);
            endIdx = query.indexOf("/*", startIdx);

            if (endIdx == -1) {
                resStr = resStr + query.substring(startIdx + 2, length);
                curIdx = length;
            } else {
                resStr = resStr + query.substring(startIdx + 2, endIdx);
                curIdx = endIdx;
            }
        }

        return resStr;
    }

    @Test
    public void testRemoveComment() {
        // StringBuilder vs. String
        // => 문자열이 많이 길어지면 StringBuilder가 더 빠름
        // => StringTest 클래스 참조
        StringBuilder sb = new StringBuilder(this.input);
        for (int i = 1; i <= 10; i++) {
            sb.append(sb);
        }
        String input = sb.toString();
//        String input = this.input;
//        for (int i = 1; i <= 17; i++) {
//            input = input + input;
//        }

        String reStr = removeComment(input);
//        System.out.println(reStr);
//        Assert.assert
    }

    @Test
    public void testRemoveCommentMo() {
        StringBuilder sb = new StringBuilder(this.input);
        for (int i = 1; i <= 10; i++) {
            sb.append(sb);
        }
        String input = sb.toString();

        String reStr = removeCommentMo(input);
//        System.out.println(reStr);
    }

}
