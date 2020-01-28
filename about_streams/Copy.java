package about_streams;

import java.io.*;
//将输入流复制到输出流
public class Copy {
    public static void main(String[] args) throws IOException {
        String src = "D:\\代码\\2020-Practice07-IO\\测试目录\\测试文件.txt";
        String dest = "D:\\代码\\2020-Practice07-IO\\测试目录\\目标文件.txt";

        InputStream is = new FileInputStream(src);
        OutputStream os = new FileOutputStream(dest);
        int b;
        while ((b = is.read()) != -1) {
            os.write(b);
        }
    }
}
