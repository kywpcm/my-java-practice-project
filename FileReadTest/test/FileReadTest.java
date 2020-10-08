import java.io.IOException;
import org.junit.Test;

/**
 * Created by Kwon Youngwoo on 2020.10.07 6:13 오후
 */
public class FileReadTest {

    @Test
    public void readDatafile() throws IOException {
        byte[] readedFile = FileRead.readDatafile("file/greeting.txt");
        System.out.println(new String(readedFile));
    }
}
