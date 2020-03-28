package cn.sxt.io2;

import java.io.*;

/**
 * ��һ������:����������
 * 1.����Դ
 * 2.ѡ����
 * 3.����
 * 4.�ͷ���Դ
 * @author �ƽ���
 */
public class IOTest01 {
    public static void main(String[] args) {
        //1.����Դ
        File src = new File("D:/idea-workspace/src/cn/sxt/io2/abc.txt");
        //2.ѡ����
        try {
            InputStream is = new FileInputStream(src);
            //3.��������ȡ��
            //��һ������
            int data1 = is.read();
            //�ڶ�������
            int data2 = is.read();
            //����������
            int data3 = is.read();
            //���ĸ�����,�������ݣ��ļ���ĩβ����-1
            int data4 = is.read();
            System.out.println((char)data1);
            System.out.println((char)data2);
            System.out.println((char)data3);
            System.out.println((char)data4);
            //4.�ͷ���Դ
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
