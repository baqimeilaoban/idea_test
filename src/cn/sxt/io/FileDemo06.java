package cn.sxt.io;

import java.io.File;
import java.io.IOException;

/**
 * 其他信息：
 * createNewFile():不存在才创建，存在创建成功返回空。不能创建文件夹
 * delete():删除已经存在的文件
 * @author thinkpad
 */
public class FileDemo06 {
    public static void main(String[] args) throws IOException {
        File src = new File("D:\\idea-workspace\\src\\cn\\sxt\\io\\IO.txt");
        boolean flag = src.createNewFile();
        System.out.println(flag);

        flag = src.delete();
        System.out.println(flag);
    }
}
