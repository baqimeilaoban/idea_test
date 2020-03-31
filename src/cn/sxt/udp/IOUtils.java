package cn.sxt.udp;

import java.io.*;

/**
 * 1.ͼƬ ��ȡ���ֽ�����
 * 2.�ֽ�����д�����ļ�
 */
public class IOUtils {
    /**
     * ͼƬ��ȡ���ļ�����
     * @param filePath ͼƬ·��
     * @return �ļ�����
     */
    public static byte[] fileToByteArray(String filePath){
        //����Դͷ��Ŀ�ĵ�
        File src = new File(filePath);
        byte[] dest = null;
        //ѡ����
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //����
            is = new FileInputStream(src);
            baos = new ByteArrayOutputStream();
            //������
            byte[] flush = new byte[1024*10];
            //���ճ���
            int len = -1;
            while ((len = is.read(flush)) != -1){
                //д�����ֽ�����
                baos.write(flush,0,len);
            }
            baos.flush();
            return baos.toByteArray();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //�ͷ���Դ
            try {
                if (null != is) {
                    is.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
       return null;

    }

    /**
     * ���ֽ�����д����ͼƬ
      * @param src �ֽ�����
     * @param filePath ͼƬ·��
     */
    public static void byteArrayToFile(byte[] src,String filePath){
        //����Դ
        File dest = new File(filePath);
        //ѡ����
        InputStream is = null;
        OutputStream os = null;
        try {
            //����
            is = new ByteArrayInputStream(src);
            os = new FileOutputStream(dest);
            //��������
            byte[] flush = new byte[5];
            //���ճ���
            int len = -1;
            while ((len = is.read(flush)) != -1){
                //д�����ļ�
                os.write(flush,0,len);
            }
            os.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //�ͷ���Դ
            try {
                if (null != is){
                    is.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
