package file.createfile;

import java.io.File;
import java.io.IOException;

public class CreateNewFile {
    public static void main(String[] args) {
        try{

            for (int i = 10; i < 48; i++) {
                File file = new File("D:\\Blog\\source\\_posts\\zuo_"+ i +".md");
                if(file.createNewFile())
                    System.out.println("�ļ�"+ i +"�����ɹ���");
                else
                    System.out.println("�����ˣ����ļ��Ѿ����ڡ�");
            }

        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}