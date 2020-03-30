package cn.sxt.commons;

import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * 大小
 * @author 黄建波
 */
public class CIOTest01 {
    public static void main(String[] args) {
        //文件大小
        long len = FileUtils.sizeOf(new File("src/cn/sxt/commons/CIOTest01.java"));
        System.out.println(len);
        //目录大小
        len = FileUtils.sizeOf(new File("src/cn/sxt/commons"));
        System.out.println(len);

    }
}
