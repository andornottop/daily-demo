package file.copyfile;

import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;

public class CopyFileToolTest {
    public static void main(String[] args) throws IOException {
//��ȡҪ���Ƶ��ļ�
        File oldfile = new File("D:\\Blog\\source\\_posts\\zuo_9.md");
//Ҫ���ɵ����ļ���ָ��·�����û���򴴽���
        for (int i = 10; i < 48; i++) {
            File newfile = new File("D:\\Blog\\source\\_posts\\zuo_" + i + ".md");
//��ȡ��Ŀ¼
            File fileParent = newfile.getParentFile();
            System.out.println(newfile);
//�ж��Ƿ����
            if (!fileParent.exists()) {
// ������Ŀ¼�ļ���
                fileParent.mkdirs();
            }
//�ж��ļ��Ƿ����
            if (!newfile.exists()) {
//�����ļ�
                newfile.createNewFile();
            }


            FileCopyUtils.copy(oldfile,newfile);

        }
    }
}
