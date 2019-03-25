import org.junit.Ignore;
import org.junit.Test;

import java.lang.management.ManagementFactory;

@SuppressWarnings("Duplicates")
public class StringTest {

    private String input = "0123456789";

    @Test
    @Ignore
    public void stringPlus() {
        System.out.println("PID : " + ManagementFactory.getRuntimeMXBean().getName());

        String input = "";
        long bytes;
        for (int i = 1; i <= 100000000; i++) {
            // String '+'는 1.5부터 컴파일러가 StringBuilder로 바꿔서 내부적으로 실행시킨다.
            // but, '+' 결과가 리턴될 때마다 StringBuilder의 toString 메소드가 호출되서 new String() 하게 됨.
            // => 그냥 concat일 때는 +, 반복문일 때는 StringBuilder 고려 (백기선)
            // 최종적으로 char[] copy = new char[newLength] 때문에 java.lang.OutOfMemoryError: Java heap space 에러가 남.
            input = input + this.input;
            // String concat 메소드는 내부적으로 StringBuilder로 실행되진 않지만,
            // 얘도 최종 char[] copy = new char[newLength] 에서 java.lang.OutOfMemoryError: Java heap space 에러가 남.
//            input = input.concat(input);

            if (i % 10000 == 0) {
                bytes = input.length() * 2; // 유니코드 2bytes
                System.out.println(bytes + " bytes");
                System.out.println(bytes / 1000 + " Kbytes");
                System.out.println(bytes / 1000 / 1000 + "." + (bytes / 1000) % 1000 + " Mbytes");
            }
        }
    }

    @Test
    public void sBuilderAppend() {
        System.out.println("PID : " + ManagementFactory.getRuntimeMXBean().getName());

        StringBuilder inputBuilder = new StringBuilder();
        long bytes;
        for (int i = 1; i <= 100000000; i++) {
            inputBuilder.append(this.input);

            if (i % 10000 == 0) {
                bytes = inputBuilder.length() * 2; // 유니코드 2bytes
                System.out.println(bytes + " bytes");
                System.out.println(bytes / 1000 + " Kbytes");
                System.out.println(bytes / 1000 / 1000 + "." + (bytes / 1000) % 1000 + " Mbytes");
            }
        }
    }

    @Test
    public void sBufferbAppend() {
        System.out.println("PID : " + ManagementFactory.getRuntimeMXBean().getName());

        StringBuffer inputBuffer = new StringBuffer();
        long bytes;
        for (int i = 1; i <= 100000000; i++) {
            inputBuffer.append(this.input);

            if (i % 10000 == 0) {
                bytes = inputBuffer.length() * 2; // 유니코드 2bytes
                System.out.println(bytes + " bytes");
                System.out.println(bytes / 1000 + " Kbytes");
                System.out.println(bytes / 1000 / 1000 + "." + (bytes / 1000) % 1000 + " Mbytes");
            }
        }
    }

}
