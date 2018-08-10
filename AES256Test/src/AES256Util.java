import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.Key;

public class AES256Util {

    private String iv;
    private Key keySpec;

    public AES256Util(String key) throws UnsupportedEncodingException {
        this.iv = key.substring(0, 16); // block size

        // key size
        byte[] keyBytes = new byte[32];
        byte[] b = key.getBytes("UTF-8");
        int len = b.length;
        if (len > keyBytes.length) {
            len = keyBytes.length;
        }
        System.arraycopy(b, 0, keyBytes, 0, len);

        this.keySpec = new SecretKeySpec(keyBytes, "AES");
    }

    // 암호화
    public String aesEncode(String str) throws Exception {
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes())); // IV: Initialization Vector, 초기화 벡터

        byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));

        return new String(Base64.encodeBase64(encrypted));
    }

    // 복호화
    public String aesDecode(String str) throws Exception {
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes("UTF-8")));

        byte[] byteStr = Base64.decodeBase64(str.getBytes());

        return new String(c.doFinal(byteStr), "UTF-8");
    }

}
