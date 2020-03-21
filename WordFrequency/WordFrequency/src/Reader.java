import java.io.*;

class AddException extends Exception{
    public AddException(String msg){
        super(msg);
    }
}

public class Reader {
    public static String read(String name) throws IOException {
        File file = new File("D:" + File.separator + name);
        //判断是否存在
        if (!file.exists()) {
            try {
                throw new AddException("文件不存在");
            }
            catch (AddException e){
                e.printStackTrace();
            }
        }
        //判断是否可读
        if(!file.canRead()){
            try {
                throw new AddException("m没有读权限");
            }
            catch (AddException e){
                e.printStackTrace();
            }
        }
        //读入
        //使用文件输入流实例化BufferedReader类对象
        String str = null;    //接收输入数据
        String content = "";
            BufferedReader buf = new BufferedReader(new FileReader(file));
            while ((str = buf.readLine()) != null) {    //判断是否存在
                content += " " + str;
            }
            buf.close();

        //判断编码
        if(!GetFileCharset.checkUTF(content)){
            try {
                throw new AddException("文件编码不正确");
            }
            catch (AddException e){
                e.printStackTrace();
            }
        }

        return content;
    }
}
