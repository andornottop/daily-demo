package file.createfile;

import java.io.File;
import java.io.IOException;

public class CreateNewFile {
    public static void main(String[] args) {
        try{

            for (int i = 10; i < 48; i++) {
                File file = new File("D:\\Blog\\source\\_posts\\zuo_"+ i +".md");
                if(file.createNewFile())
                    System.out.println("文件"+ i +"创建成功！");
                else
                    System.out.println("出错了，该文件已经存在。");
            }

        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}