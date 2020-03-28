package cn.sxt.io2;

import java.io.*;

/**
 * ��׼д��
 * @author �ƽ���
 */
public class IOTest02 {
    public static void main(String[] args) {
        //����Դ
        File src = new File("src/cn/sxt/io2/abc.txt");
        InputStream is = null;
        //ѡ����
        try {
            is = new FileInputStream(src);
            //��ȡ
            int temp;
            while ((temp=is.read())!=-1){
                System.out.print(((char) temp));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //�ͷ���Դ
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
