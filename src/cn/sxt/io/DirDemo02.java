package cn.sxt.io;

import java.io.File;

/**
 * �г���һ��
 * 1.list():�ҳ��¼�����
 * 2.listFiles():�г��¼�File����
 * 3.�г������̷�
 * @author �ƽ���
 */
public class DirDemo02 {
    public static void main(String[] args) {
        File dir = new File("D:\\Iotest");
        //�г��¼����� list()
        String[] subsName = dir.list();
        for (String s:subsName){
            System.out.println(s);
        }

        //�¼�����listFile()
        File[] subFiles = dir.listFiles();
        for (File s : subFiles){
            System.out.println(s.getAbsolutePath());
        }

        //�����̷�
        File[] roots = File.listRoots();
        for (File r:roots){
            System.out.println(r.getAbsolutePath());
        }
    }
}
