package juli;


public class test {
    public static void main(String[] args) {
        //主测试函数
        String[] arg = new String[3];
        arg[0] = "C:\\Users\\92445\\Desktop\\论文查重\\org.txt";
        arg[1] = "C:\\Users\\92445\\Desktop\\论文查重\\org_add.txt";
        arg[2] = "C:\\Users\\92445\\Desktop\\论文查重\\ans.txt";

        Ujjwal.main(arg);

        //测试路径错误
        String[] arg1 = new String[3];
        arg1[0] = "C:\\Users\\92445\\Desktop\\错误的\\before.txt";
        arg1[1] = "C:\\Users\\92445\\Desktop\\论文查重\\after.txt";
        arg1[2] = "C:\\Users\\92445\\Desktop\\论文查重\\ans.txt";

        Ujjwal.main(arg1);

        //测试文件为空
        String[] arg2 = new String[3];
        arg2[0] = "C:\\Users\\92445\\Desktop\\论文查重\\before.txt";
        arg2[1] = "C:\\Users\\92445\\Desktop\\论文查重\\after.txt";
        arg2[2] = "C:\\Users\\92445\\Desktop\\论文查重\\ans.txt";

        Ujjwal.main(arg2);
    }

}
