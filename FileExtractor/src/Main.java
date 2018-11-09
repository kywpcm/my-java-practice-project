public class Main {

    public static void main(String[] args) {
        FileExtractor fe = new FileExtractor();
        fe.makeOneFileOfKeywordLine(args[0], args[1], args[2]);
        fe.close();
    }

}
