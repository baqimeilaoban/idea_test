package cn.sxt.io2;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * �ĸ����裺�ֽ�����������
 * 1.����Դ���ֽ����� ��Ҫ̫��
 * 2.ѡ����
 * 3.����
 * 4.�ͷ���Դ
 * @author �ƽ���
 */
public class IOTest07 {
    public static void main(String[] args) {
        //����Դ
        byte[] src = "talk is cheap show me the code".getBytes();
        //ѡ����
        InputStream is = null;
        try {
            //����
            is = new ByteArrayInputStream(src);
            //��������
            byte[] flush = new byte[5];
            //���ܳ���
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                //�ֽ�����-->�ַ��������룩
                String str = new String(flush, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (null != is){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
