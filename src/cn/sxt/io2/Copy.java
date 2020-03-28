package cn.sxt.io2;

import java.io.*;

/**
 * �ļ��������ļ��ֽ����롢�����
 * 1.����Դ
 * 2.ѡ����
 * 3.����
 * 4.�ͷ���Դ
 * @author �ƽ���
 */
public class Copy {
    public static void main(String[] args) {
        copy("src/cn/sxt/io2/Copy.java","copy.txt");
    }

    public static void copy(String srcPath, String destPath) {
        //Դͷ
        File src = new File(srcPath);
        //Ŀ�ĵ�
        File dest = new File(destPath);
        //try...with...resource
        try (InputStream is = new FileInputStream(src);
             OutputStream os = new FileOutputStream(dest)) {
            //�������ֶζ�ȡ
            //��������
            byte[] flush = new byte[1024];
            //���ճ���
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                //�ֶ�д��
                os.write(flush, 0, len);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
