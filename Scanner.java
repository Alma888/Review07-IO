import java.io.*;
import java.util.Comparator;
//用递归的方法遍历一遍每个文件，将它们的信息保存下来
public class Scanner {
    //扫描文件夹
    public static void scannerDirectory(TreeNode node) {
        File[] files = node.file.listFiles();//这里的node都是父亲结点
        if (files == null) {
            return;
        }

        for (File file : files) {
            TreeNode child = new TreeNode();//这里是孩子结点
            child.file = file;
            if (file.isDirectory()) {
                scannerDirectory(child);//递归
            } else {
                child.totalLength = file.length();
            }
            node.totalLength += child.totalLength;
            node.children.add(child);
        }
    }

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        TreeNode root = new TreeNode();
        root.file = new File("C:\\Users");
        scannerDirectory(root);
        PrintStream out = new PrintStream(
                new FileOutputStream("扫描报告.txt"),
                true, "UTF-8");
        //按降序进行排序
        Comparator<TreeNode> sortByLengthDesc = new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                if (o1.totalLength > o2.totalLength) {
                    return -1;//按降序来
                } else if (o1.totalLength == o2.totalLength) {
                    return 0;
                } else {
                    return 1;
                }
            }
        };

        report(root, 0, sortByLengthDesc, out);

        out.close();//尽量自己关掉
    }
    //直接调用我们自己构造的out.println(),就会打印到我们指定的文件里，
    //而要是调System.out.println()则会打印到屏幕上

    private static void report(TreeNode root, int level, Comparator<TreeNode> sortBy, PrintStream out) {
        for (int i = 0; i < level * 4; i++) {
            out.print(" ");
        }
        if (level == 0) {
            out.print(root.file.getAbsolutePath());
        } else {
            out.print(root.file.getName());
        }
        if (root.file.isDirectory()) {
            out.print("\\");
        }

        String unit = "字节";
        double length = root.totalLength;
        if (length > 1024 * 1024 * 1024) {
            unit = "G字节";
            length = length / 1024 / 1024 / 1024;
        } else if (length > 1024 * 1024) {
            unit = "M字节";
            length = length / 1024 / 1024;
        } else if (length > 1024) {
            unit = "K字节";
            length = length / 1024;
        }
        out.printf("    %.2f%s%n", length, unit);

        root.children.sort(sortBy);
        for (TreeNode node : root.children) {
            report(node, level + 1, sortBy, out);
        }
    }
}
