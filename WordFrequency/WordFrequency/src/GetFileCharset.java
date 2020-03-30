public class GetFileCharset {
    public static boolean checkUTF(String str) {
        boolean flag = java.nio.charset.Charset.forName("UTF-8").newEncoder().canEncode(str);
        return flag;
    }
}
