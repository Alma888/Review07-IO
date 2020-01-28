package about_files;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        File[] files = File.listRoots();//查看我们所有文件的根结点（盘符）
        for (File file : files) {
            System.out.println(file);
            System.out.println(file.exists());//看盘符是否存在
        }

        /*10
        File file = File.createTempFile("iodemo", ".txt");//给临时文件起名字(生成不重复的名字)
        System.out.println(file.getAbsolutePath());
        */

        //查看我们当前的工作路径9
        //System.out.println(System.getProperty("user.dir"));

        /*8
        String path = "我的相对路径.txt";
        File file = new File(path);
        file.createNewFile();
        */

        /*7
        String path="D:\\代码\\2020-Practice07-IO\\测试目录\\新建文件夹";
        File file = new File(path);
        String destPath = "D:\\代码\\2020-Practice07-IO\\测试目录\\新的文件";
        File dest = new File(destPath);
        file.renameTo(dest);    // 平时的剪切 / 给文件改名
        */

        /*6
        String path="D:\\代码\\2020-Practice07-IO\\测试目录\\隐藏文件";
        File file=new File(path);
        System.out.println(file.isHidden());//查看当前文件是否是隐藏文件
        System.out.println(file.length());//查看当前文件的长度
        */

        /*5
        String path="D:\\代码\\2020-Practice07-IO";
        File file=new File(path);
        File[] files=file.listFiles();//查看path当前目录下有什么文件，并不会去递归
        for(File f:files){
            System.out.println(f.getAbsolutePath());
        }
        */


        /*1
        String parent="D:\\代码\\2020-Practice07-IO\\测试目录";
        File file=new File(parent,"test.txt");//这里只是创建了一个对象，
                                     // 并未真正的在测试目录下创建了test.txt文件或文件夹
        //创建文件夹
       // file.mkdir();  //make directory 的缩写，，创建一个文件夹的意思
        file.mkdirs();// File file=new File(parent,"1\\2\\3\\test.txt");
                       // 在我们的测试目录下分别创建文件夹1，1里面再建2，2里再建3，3里最终建test.txt
        */

        /*2
        //创建文件
        file.createNewFile();//调了这个方法才真正创建成功了
        file.delete();//删除一个文件,执行完，立马会删除指定文件
        file.deleteOnExit();//这个语句只是告诉JVM这个文件最终要删除掉，但不是现在删除，而是在JVM退出时才删除
        */

        //File 的第二个构造方法3
       // File file=new File("D:\\代码\\2020-Practice07-IO\\","测试目录");

        /* File 的第一个构造方法4
        //下面这个语句就是描述的是我们刚刚创建的测试目录
        File file=new File("D:\\代码\\2020-Practice07-IO\\测试目录");
        System.out.println("是否存在：" +file.exists());
        System.out.println("是否是文件夹:" +file.isDirectory());//file相关的是不是一个目录
        System.out.println("该盘符的空闲空间: "+file.getFreeSpace());//该目录所在盘符的一个空闲空间
        System.out.println("该盘符的可用空间: "+file.getUsableSpace());//该目录所在盘符的一个可用空间
        System.out.println("该盘符的总空间: " +file.getTotalSpace());//所在盘符总共有多少空间
        System.out.println("绝对路径: " + file.getAbsolutePath());//绝对路径
        System.out.println("上一级路径:" + file.getParent());//获取当前目录的上一级目录
        System.out.println("可读: " + file.canRead());
        System.out.println("可写: " + file.canWrite());
        System.out.println("可执行: " + file.canExecute());
        */
    }
}
