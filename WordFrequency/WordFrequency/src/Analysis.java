import java.util.*;

public class Analysis {
    public static List analysis(String content) {
        String[] contents = content.split("\\s+");//按空格+分割
        Map<String, Integer> map = new HashMap<>();
        //存入map
        for (int i = 0; i < contents.length; i++) {
            if (map.containsKey(contents[i])) {
                map.put(contents[i], map.get(contents[i]) + 1);
            } else {
                map.put(contents[i], 1);
            }
        }
        //排序
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        //将map.entrySet()转换成list
        //然后通过比较器来实现排序
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            //降序排序
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return list;
    }
}
