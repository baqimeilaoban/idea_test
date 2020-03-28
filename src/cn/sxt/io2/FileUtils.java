package cn.sxt.io2;

import java.io.*;

/**
 * 1.��װ����
 * 2.��װ�ͷ���Դ
 * @author thinkpad
 */
public class FileUtils {
    public static void main(String[] args) {
        //�ļ����ļ�
        try {
            InputStream is = new FileInputStream("src/cn/sxt/io2/abc.txt");
            OutputStream os = new FileOutputStream("abc-copy.txt");
            copy(is,os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //�ļ����ֽ�����
        byte[] datas = null;
        try {
            InputStream is = new FileInputStream("src/cn/sxt/io/IO.png");
            ByteArrayOutputStream os  = new ByteArrayOutputStream();
            copy(is,os);
            datas = os.toByteArray();
            System.out.println(datas.length);
        }catch (IOException e){
            e.printStackTrace();
        }

        //�ֽ����鵽�ļ�
        try {
            InputStream is = new ByteArrayInputStream(datas);
            OutputStream os = new FileOutputStream("p-copy.png");
            copy(is,os);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * �Խ����������
     * @param is ������
     * @param os �����
     */
    public static void copy(InputStream is, OutputStream os){
       try {
           byte[] flush = new byte[1024];
           int len = -1;
           while ((len = is.read(flush)) != -1){
               os.write(flush,0,len);
           }
           os.flush();
       }catch (IOException e){
           e.printStackTrace();
       }finally {
           //�ͷ���Դ �ֱ�ر� �ȴ򿪵ĺ�ر�
           close(is,os);
       }
    }

    /**
     * ɾ����Դ ���������һ��close����
     * @param is ������
     * @param os �����
     */
    public static void close(InputStream is,OutputStream os){
        try {
            if (null != os){
                os.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        try {
            if (null != is){
                is.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * �ͷ���Դ
     * @param ios ��������
     */
    public static void close(Closeable... ios){
        for (Closeable io:ios){
            try {
                if (null != io){
                    io.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
