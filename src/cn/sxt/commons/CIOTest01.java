package cn.sxt.commons;

import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * ��С
 * @author �ƽ���
 */
public class CIOTest01 {
    public static void main(String[] args) {
        //�ļ���С
        long len = FileUtils.sizeOf(new File("src/cn/sxt/commons/CIOTest01.java"));
        System.out.println(len);
        //Ŀ¼��С
        len = FileUtils.sizeOf(new File("src/cn/sxt/commons"));
        System.out.println(len);

    }
}
