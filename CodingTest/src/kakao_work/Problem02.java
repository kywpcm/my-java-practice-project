package kakao_work;

import java.io.*;
import java.util.Scanner;

public class Problem02 {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String args[]) throws Exception {

        // read the string filename
        String filename;
        filename = scan.nextLine();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            BufferedWriter bw = new BufferedWriter(new FileWriter("bytes_" + filename));
            int count = 0;
            long totalsize = 0;

            String s;
            while ((s = br.readLine()) != null) {
                // test
                System.out.println(s);

                String[] lineWords = s.split("\\s");

                String resByteSize = lineWords[lineWords.length - 1];
                if (Long.parseLong(resByteSize) > 5000) {
                    count++;
                    totalsize += Long.parseLong(resByteSize);
                }
            }
            br.close();

            bw.write(String.valueOf(count));
            bw.newLine();
            bw.write(String.valueOf(totalsize));

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
