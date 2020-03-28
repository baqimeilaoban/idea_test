package cn.sxt.io2;

import java.io.*;

/**
 * �ļ�������
 * @author thinkpad
 */
public class FileTest {
    public static void main(String[] args) {
        //����Դ
        File src = new File("src/cn/sxt/io2/abc.txt");
        //ѡ����
        Reader reader = null;
        try {
            reader = new FileReader(src);
            //��������ȡ��
            char[] flush = new char[2];
            //���ܳ���
            int len = -1;
            while ((len = reader.read(flush)) != -1){
                //�ֽ�����-->�ַ���
                String str = new String(flush,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != reader){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
