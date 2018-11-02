import org.junit.Test;

import java.io.*;

/**
 *
 */
public class FileExtractor {

    private String keyword;
    private File writeFile;
    private BufferedWriter bw;

//    public FileExtractor() {}

    public FileExtractor(String keyword) {
        this.keyword = keyword;
        this.writeFile = new File("./" + keyword + ".txt");
        try {
            this.bw = new BufferedWriter(new FileWriter(writeFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void makeOneFileOfKeywordLine(String path, String extension) {
        File dir = new File(path);
        File[] files = dir.listFiles();
        if (files == null) return;

        try {
            for (File file : files) {
                if (file.isFile()) { // 파일
                    String fileName = file.getName();
                    int pos = fileName.lastIndexOf(".");
                    String fileExtension = fileName.substring(pos + 1);

                    if (fileExtension.equals(extension)) { // 확장자 검사
                        BufferedReader br = new BufferedReader(new FileReader(file));
                        String line;
                        while ((line = br.readLine()) != null) {
                            if (line.contains(keyword) && writeFile.canWrite()) {
                                // test
                                System.out.println("::::: " + line);

                                bw.write(line + System.getProperty("line.separator"));
//                                bw.write(line);
                            }
                        }
                        br.close();
                    }
                } else if (file.isDirectory()) { // 디렉토리
//                    System.out.println("디렉토리 이름 = " + file.getName());
                    // 서브 디렉토리가 존재하면 재귀로 다시 탐색
                    makeOneFileOfKeywordLine(file.getCanonicalPath(), extension);
                }
            }
//            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void t1() {
//        FileExtractor fe = new FileExtractor("이기범");
//        fe.makeOneFileOfKeywordLine("C:\\Users\\Youngwoo Max Kwon\\Downloads", "txt");
//    }

}
