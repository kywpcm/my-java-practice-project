import java.io.*;

/**
 *
 */
public class FileExtractor {

    private static final String OUT_FILE_NAME = "../out/out.txt";
    private static final String SOURCE_FILE_LIST_DIR_NAME = "../out/source_file_list/";

    private File outFile;
    private BufferedWriter bw;

    public FileExtractor() {
        this.outFile = new File(OUT_FILE_NAME);
        try {
            this.bw = new BufferedWriter(new FileWriter(outFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void makeOneFileOfKeywordLine(String keyword, String path, String extension) {
        File dir = new File(path);
        File[] fileList = dir.listFiles();
        if (fileList == null) return;

        boolean shouldCopyFile = false;
        try {
            for (File file : fileList) {
                if (file.isFile()) { // 파일
                    String fileName = file.getName();
                    int pos = fileName.lastIndexOf(".");
                    String fileExtension = fileName.substring(pos + 1);

                    if (fileExtension.equals(extension) && !fileName.equals(OUT_FILE_NAME)) { // 확장자 검사 && out 파일 제외
                        BufferedReader br = new BufferedReader(new FileReader(file));
                        String line;

                        while ((line = br.readLine()) != null) {
                            if (line.contains(keyword) && outFile.canWrite()) {
                                // test
                                System.out.println(line);

                                bw.write(line + System.getProperty("line.separator"));
                                shouldCopyFile = true;
                            }
                        }
                        bw.flush();
                        br.close();

                        // 대상 파일 copy
                        if (shouldCopyFile) {
                            File fileMakesDir = new File(SOURCE_FILE_LIST_DIR_NAME);
                            if (!fileMakesDir.exists())
                                fileMakesDir.mkdirs();
                            this.copyFile(file, new File(SOURCE_FILE_LIST_DIR_NAME + fileName));

                            shouldCopyFile = false;
                        }
                    }
                } else if (file.isDirectory()) { // 디렉토리
                    // 서브 디렉토리가 존재하면 재귀로 다시 탐색
                    makeOneFileOfKeywordLine(keyword, file.getCanonicalPath(), extension);
                }
            }
//            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void copyFile(File srcFile, File targetFile) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(targetFile);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException io) {
                io.printStackTrace();
            }
        }
    }

    public void close() {
        try {
            this.bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
