package cn.sxt.io;

import java.io.File;

/**
 * ������Ϣ��
 * length():�ļ����ֽ���
 * @author �ƽ���
 */
public class FileDemo05 {
    public static void main(String[] args) {
        File src = new File("D:/idea-workspace/src/cn/sxt/io/IO.png");
        System.out.println("�ļ����ȣ�" + src.length());
        System.out.println("--------------------");
        src = new File("D:/idea-workspace/src/cn/sxt/io");
        System.out.println("����Ϊ��" + src.length());
        System.out.println("-----------------------");
        src = new File("D:/idea-workspace/src/cn/sxt/io2");
        System.out.println("����Ϊ��" + src.length());
    }
}
