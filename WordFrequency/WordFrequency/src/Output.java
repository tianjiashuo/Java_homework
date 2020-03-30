import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

public class Output {
    public static void write(List<Map.Entry<String, Integer>> list) throws IOException {
        //写入output.txt
        File resultFile = new File("D:" + File.separator + "output.txt");
        Writer wrt = new FileWriter(resultFile);
        for(Map.Entry<String,Integer> mapping:list){
            char[] c = (mapping.getKey()+" "+mapping.getValue()+"\n").toCharArray();
            wrt.write(c);
        }
        wrt.flush();
    }

}
