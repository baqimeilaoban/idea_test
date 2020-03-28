package cn.sxt.io3;

import java.io.*;

/**
 * �ĸ����裺�ֶζ�ȡ �ļ��ֽ������� ���뻺����
 * 1.����Դ
 * 2.ѡ����
 * 3.����
 * 4.�ͷ���Դ
 * @author thinkpad
 */
public class BufferedTest01 {
    public static void main(String[] args) {
        //����Դ
        File src = new File("src/cn/sxt/io2/abc.txt");
        //ѡ����
        InputStream is = null;
        BufferedInputStream bis = null;
        try {
            is = new FileInputStream(src);
            bis = new BufferedInputStream(is);
            //����
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1){
                //�ֽ�����--->�ַ���
                String str = new String(flush,0,len);
                System.out.println(str);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
           try {
               if (null != is){
                   is.close();
               }
           }catch (IOException e){
               e.printStackTrace();
           }

           try {
               if (null != bis){
                   bis.close();
               }
           }catch (IOException e){
               e.printStackTrace();
           }
        }
    }
}
