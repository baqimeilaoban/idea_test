package cn.sxt.io;

import java.io.File;

/**
 * ����Ŀ¼
 * 1.mkdir:ȷ���ϼ�Ŀ¼���ڣ������ڴ���ʧ��
 * 2.mkdirs���ϼ�Ŀ¼���Բ����ڣ���������һͬ������
 * @author �ƽ���
 */
public class DirDemo01 {
    public static void main(String[] args) {
        File dir = new File("D:/Iotest/dir/test");
        //����Ŀ¼���Ƽ�ʹ��mkdirs
        boolean flag = dir.mkdirs();
        System.out.println(flag);


    }
}
