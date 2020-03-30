package cn.sxt.oo2;

import java.io.*;

/**
 * ��ӡ����PrintStream
 * @author �ƽ���
 */
public class PrintTest {
    public static void main(String[] args) throws FileNotFoundException {
        //��ӡ�� System.out
        PrintStream ps = System.out;
        ps.println("��ӡ��");
        ps.println(true);

        ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("print.txt")),true);
        ps.println("��ӡ��");
        ps.println(true);

        //�ض��������
        System.setOut(ps);
        System.out.println("change");

        //�ض���ؿ���̨
        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
        System.out.println("i am backing....");
    }
}
