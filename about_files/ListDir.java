package about_files;

import java.io.File;

public class ListDir {
    //遍历一个目录下的所有文件
    public static void listDir(File dir){
        File[] files=dir.listFiles();
        if (files == null) {
            System.out.println(dir.canExecute());
            System.out.println(dir.canWrite());
            System.out.println(dir.canRead());
            System.out.println(dir.isDirectory());
        }
        for(File file:files){
            if(file.isDirectory()){
                listDir(file);//递归调用（深度优先遍历）
            }else {
                System.out.println(file.getAbsolutePath() + ": " + file.length());
            }
        }
    }
    public static void main(String[] args) {
        listDir(new File("C:\\Users"));
    }
}
