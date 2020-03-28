package cn.sxt.io2;

import java.io.*;

/**
 * �ļ��ֽ������
 * 1.����Դ
 * 2.ѡ����
 * 3.������д�����ݣ�
 * 4.�ͷ���Դ
 */
public class IOTest04 {
    public static void main(String[] args) {
        //����Դ
        File src = new File("dest.txt");
        //ѡ����
        OutputStream dest = null;
        try {
            dest = new FileOutputStream(src,false);
            //������д��
            String msg = "IO is so easy";
            //�ַ���-->�ֽ����飨���룩
            byte[] datas = msg.getBytes();
            dest.write(datas,0,datas.length);
            dest.flush();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (null != dest){
                try {
                    //�ͷ���Դ
                    dest.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
