package file.copyfile;

import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;

public class CopyFileToolTest {
    public static void main(String[] args) throws IOException {
//获取要复制的文件
        File oldfile = new File("D:\\Blog\\source\\_posts\\zuo_9.md");
//要生成的新文件（指定路径如果没有则创建）
        for (int i = 10; i < 48; i++) {
            File newfile = new File("D:\\Blog\\source\\_posts\\zuo_" + i + ".md");
//获取父目录
            File fileParent = newfile.getParentFile();
            System.out.println(newfile);
//判断是否存在
            if (!fileParent.exists()) {
// 创建父目录文件夹
                fileParent.mkdirs();
            }
//判断文件是否存在
            if (!newfile.exists()) {
//创建文件
                newfile.createNewFile();
            }


            FileCopyUtils.copy(oldfile,newfile);

        }
    }
}
