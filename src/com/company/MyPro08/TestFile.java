package com.company.MyPro08;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * ����File��Ļ����÷�
 * @author thinkpad
 */
public class TestFile {
    public static void main(String[] args) throws IOException {
        File f = new File("D:\\idea-workspace\\src\\com\\company\\MyPro08\\a.txt");

        System.out.println(f);
        f.renameTo(new File("D:\\idea-workspace\\src\\com\\company\\MyPro08\\b.txt"));
        //�õ���Ŀ·��
        System.out.println(System.getProperty("user.dir"));

        //����Ŀ�´������ļ�
        File f2 = new File("gg.txt");
        f2.createNewFile();

        System.out.println("File�Ƿ���ڣ�" + f2.exists());
        System.out.println("File�Ƿ���Ŀ¼��" + f2.isDirectory());
        System.out.println("File�Ƿ����ļ���" + f2.isFile());
        System.out.println("File����޸�ʱ�䣺" + new Date(f2.lastModified()));
        System.out.println("File�ļ��Ĵ�С��" + f2.length());
        System.out.println("File�ļ�����" + f2.getName());
        System.out.println("FileĿ¼·����" + f2.getAbsolutePath());

        File f3 = new File("D:/��Ӱ/����/��½");
        //Ŀ¼�ṹ����һ�������ڣ��򲻻ᴴ������Ŀ¼
        //boolean flag = f3.mkdir();
        //����mkdirs����Ŀ¼������һ�������ڣ�Ҳ�ܴ����ɹ�
        boolean flag = f3.mkdirs();
        //����ʧ��
        System.out.println(flag);
    }
}
