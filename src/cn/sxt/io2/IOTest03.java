package cn.sxt.io2;

import java.io.*;

/**
 * �ĸ����裻�ֶζ�ȡ �ļ��ֽ�������
 * 1.����Դ
 * 2.ѡ����
 * 3.����
 * 4.�ͷ���Դ
 */
public class IOTest03 {
    public static void main(String[] args) {
        //����Դ
        File src = new File("src/cn/sxt/io2/abc.txt");
        //ѡ����
        InputStream is = null;
        try {
            is = new FileInputStream(src);
            //��������ȡ��
            byte[] car = new byte[3];
            //���ܳ���
            int len = -1;
            while ((len = is.read(car)) != -1){
                //�ֽ�����-->�ַ���
                String str = new String(car,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
