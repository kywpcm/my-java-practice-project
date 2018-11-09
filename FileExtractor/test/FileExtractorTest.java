import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FileExtractorTest {

    private FileExtractor fe = new FileExtractor();

    @Before
    public void setUp() throws Exception {
        fe = new FileExtractor();
    }

    @Test
    public void makeOneFileOfKeywordLine() {
        fe.makeOneFileOfKeywordLine("홍길동", "./", "txt");
    }

    @After
    public void tearDown() throws Exception {
        fe.close();
    }

}