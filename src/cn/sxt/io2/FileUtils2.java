package cn.sxt.io2;

import java.io.*;

/**
 * 1.��װ����
 * 2.��װ�ͷ���Դ
 * @author thinkpad
 */
public class FileUtils2 {
    public static void main(String[] args) {
        //�ļ����ļ�
        try {
            InputStream is = new FileInputStream("src/cn/sxt/io2/abc.txt");
            OutputStream os = new FileOutputStream("abc-copy.txt");
            copy(is, os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //�ļ����ֽ�����
        byte[] datas = null;
        try {
            InputStream is = new FileInputStream("src/cn/sxt/io/IO.png");
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            copy(is, os);
            datas = os.toByteArray();
            System.out.println(datas.length);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //�ֽ����鵽�ļ�
        try {
            InputStream is = new ByteArrayInputStream(datas);
            OutputStream os = new FileOutputStream("p-copy.png");
            copy(is, os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * �Խ����������
     * try...with...resource
     * @param is ������
     * @param os �����
     */
    public static void copy(InputStream is, OutputStream os) {
        try {
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                os.write(flush, 0, len);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}