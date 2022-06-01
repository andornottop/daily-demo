package file.separator;
 
//import com.zte.ums.cnms.pm.load.enums.MppFileDirEnum;
import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) throws IOException {
        String fileName = "photo.bmp";
        System.out.println("File.separator:" + File.separator);
        File testFile = new File("D:" + File.separator + "filepath" + File.separator + "test" + File.separator + fileName);
        File fileParent = testFile.getParentFile();//���ص���File����,���Ե���exsit()�ȷ��� 
        String fileParentPath = testFile.getParent();//���ص���String����
        System.out.println("fileParent:" + fileParent);
        System.out.println("fileParentPath:" + fileParentPath);
        if (!fileParent.exists()) {
            fileParent.mkdirs();// �ܴ����༶Ŀ¼
        }
        if (!testFile.exists())
            testFile.createNewFile();//��·�����ܴ����ļ�
        System.out.println(testFile);
 
        String path = testFile.getPath();
        String absolutePath = testFile.getAbsolutePath();//�õ��ļ�/�ļ��еľ���·��
        String getFileName = testFile.getName();//�õ��ļ�/�ļ��е�����
        System.out.println("path:"+path);
        System.out.println("absolutePath:"+absolutePath);
        System.out.println("getFileName:"+getFileName);
    }
}
