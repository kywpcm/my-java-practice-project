import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
            Class c = Class.forName("foo.Foo");
//            Class c = Class.forName("foo.Foo", true, this.getClass().getClassLoader()); // 위와 같음
            System.out.println(c);
//            System.out.println((Foo) c);
            System.out.println(c.getName());
            System.out.println(c.getClassLoader());
            System.out.println(this.getClass());
            System.out.println(this.getClass().getClassLoader());

            System.out.println();

            Class c2 = Class.forName("boo.Boo");
            System.out.println(c2);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }

    @Test
    public void testJDBC() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/for_backend_master";
            String id = "root";
            String pw = "y98122514w";

//            Class.forName("com.mysql.jdbc.Driver");
//            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, id, pw);

            System.out.println("제대로 연결되었습니다.");
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

}
