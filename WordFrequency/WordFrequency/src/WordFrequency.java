import java.io.*;
import java.util.*;

public class WordFrequency {

    public static void main(String[] args)  {
        //读入
        String content = null;
        try {
            content = Reader.read("了不起的盖茨比英文.txt");
            List<Map.Entry<String, Integer>> list = Analysis.analysis(content);
            Output output = new Output();
            output.write(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
