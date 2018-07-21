import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.*;

public class AES256UtilTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testAES256Util() throws Exception {
        String key = "12345678901234561234567890123456"; // AES256: 32 bytes key
        AES256Util aes256 = new AES256Util(key);

        String text = "테스트 data";
        System.out.println("암호화 대상 data : " + text);
        String encodedText = aes256.aesEncode(text);
        System.out.println("인코딩 data : " + encodedText);
        String decodedText = aes256.aesDecode(encodedText);
        System.out.println("디코딩 data : " + decodedText);
    }

    @After
    public void tearDown() throws Exception {
    }

}
