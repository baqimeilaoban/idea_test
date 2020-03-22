package cn.sxt.io;

import java.io.File;

/**
 * ����File����
 * ���·���;���·��
 * 1)�������̷�������·��
 * 2)���������̷������·��
 * @author �ƽ���
 */
public class FileDemo02 {
    public static void main(String[] args) {
        String path = "D:/idea-workspace/src/cn/sxt/io/IO.png";

        //����·��
        File src = new File(path);
        System.out.println(src.getAbsolutePath());
        //����û���Ŀ¼
        System.out.println(System.getProperty("user.dir"));
        //���·��
        src = new File("src/cn/sxt/io/IO.png");
        System.out.println(src.getAbsolutePath());
        //����һ�������ڵ��ļ�
        src = new File("aaa/IO2.png");
        System.out.println(src.getAbsolutePath());
    }
}
