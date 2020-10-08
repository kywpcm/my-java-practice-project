import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Kwon Youngwoo on 2020.10.07 6:08 오후
 */
public class FileRead {

    public static byte[] readDatafile(String filePath) throws IOException {
        File file = new File(filePath);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        byte[] readByteFromBuffer = new byte[bis.available()]; // size 바꿔보기
        byte[] outByte = new byte[(int) file.length()];

        int length;
        int destPos = 0;
        while ((length = bis.read(readByteFromBuffer, 0, readByteFromBuffer.length)) > 0) {
            System.arraycopy(readByteFromBuffer, 0, outByte, destPos, length);
            destPos += length;
        }

        bis.close();

        return outByte;
    }
}
