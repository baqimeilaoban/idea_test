package cn.sxt.io;

import java.io.File;

/**
 * �ļ�״̬
 * 1.�����ڣ�exists
 * 2.���ڣ�
 *      �ļ���isFile
 *      �ļ��У�isDirctory
 * @author thinkpad
 */
public class FileDemo04 {
    public static void main(String[] args) {
        File src = new File("src/cn/sxt/io/IO.png");
        System.out.println("�Ƿ���ڣ�" + src.exists());
        System.out.println("�Ƿ����ļ���" + src.isFile());
        System.out.println("�Ƿ����ļ��У�" + src.isDirectory());
        System.out.println("------------------");
        src = new File("xxx");
        if (!src.exists()){
            System.out.println("�ļ�������");
        }else {
            if (src.isFile()){
                System.out.println("�ļ�����");
            }else {
                System.out.println("�ļ��в���");
            }
        }
    }

}
