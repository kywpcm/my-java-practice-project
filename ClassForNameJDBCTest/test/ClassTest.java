import org.junit.Test;

import java.sql.*;

public class ClassTest {

    /*
     * 참고
     * 1. http://devyongsik.tistory.com/292 - Class.class, Class 클래스
     * 2. http://devyongsik.tistory.com/293 - Class.forName(String className);
     * 3. http://devyongsik.tistory.com/294 - Class.forName(String className) 그리고 Service Provider Interface(SPI)
     */

    @Test
    public void testClassForName() {
        try {
            Class c = Class.forName("main.foo.Foo");
//            Class c = Class.forName("main.foo.Foo", true, this.getClass().getClassLoader()); // 위와 같음
            System.out.println(c);
//            System.out.println((Foo) c);
            System.out.println(c.getName());
            System.out.println(c.getClassLoader());
            System.out.println(this.getClass());
            System.out.println(this.getClass().getClassLoader());

            System.out.println();

            Class c2 = Class.forName("main.boo.Boo");
            System.out.println(c2);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }

    @Test
    public void testJDBC() throws ClassNotFoundException {
        /*****************************************************************
         * - java.sql 패키지 JDBC SPI(Service Provider Interface) 제공
         *   - Connection 인터페이스
         *   - DriverManager 클래스
         * - Vendor가 구현해야 하는 부분
         *   - Driver 클래스
         *   - Connection 구현체
         * - Class.forName 메소드 실행시 클래스 로더가 클래스를 로딩할 때, Driver 클래스의 static block이 실행되고,
         *   여기서 드라이버 객체를 DriverManager에 등록시킴.
         *****************************************************************/

        String url = "jdbc:mysql://localhost:3306/for_backend_master";
        String id = "root";
        String pw = "y98122514w";
//        Class.forName("com.mysql.jdbc.Driver");
//        Class.forName("oracle.jdbc.driver.OracleDriver");

        // try-with-resources (since 1.7)
        try (Connection conn = DriverManager.getConnection(url, id, pw);
             Statement stmt = conn.createStatement();
             PreparedStatement pstmt = conn.prepareStatement("select 1");
             CallableStatement cstmt = conn.prepareCall("select 1")) {

            System.out.println("제대로 연결되었습니다.");

            stmt.executeQuery("select 1");
            pstmt.executeQuery();
            cstmt.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

}
