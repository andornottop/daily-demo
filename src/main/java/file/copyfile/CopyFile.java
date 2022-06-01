package file.copyfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) throws IOException {
//��ȡҪ���Ƶ��ļ�
        File oldfile = new File("D:\\Blog\\source\\_posts\\zuo_9.md");
//�ļ������������ڶ�ȡҪ���Ƶ��ļ�
//Ҫ���ɵ����ļ���ָ��·�����û���򴴽���
        for (int i = 10; i < 48; i++) {
            FileInputStream fileInputStream = new FileInputStream(oldfile);

            File newfile = new File("D:\\Blog\\source\\_posts\\zuo_" + i + ".md");
//��ȡ��Ŀ¼
            File fileParent = newfile.getParentFile();
            System.out.println(fileParent);
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

//���ļ������
            FileOutputStream fileOutputStream = new FileOutputStream(newfile);
            byte[] buffer = new byte[1024];
            int len;
//���ļ�����Ϣ��ȡ�ļ��������������ȡ�����Ϊ-1�ʹ����ļ�û�ж�ȡ��ϣ���֮�Ѿ���ȡ���
            while ((len = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
                fileOutputStream.flush();
            }
            fileInputStream.close();
            fileOutputStream.close();

        }
    }
}
