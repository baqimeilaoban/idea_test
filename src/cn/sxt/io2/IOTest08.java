package cn.sxt.io2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * �ֽ����������
 * 1.����Դ:�ڲ�ά��
 * 2.ѡ������������Դ
 * 3.����
 * 4.�ͷ���Դ�����Բ���Ҫ
 * ��Ҫ��ȡ���ݣ�toByteArray
 * @author �ƽ���
 */
public class IOTest08 {
    public static void main(String[] args) {
        //����Դ
        byte[] dest = null;
        //ѡ������ʹ������������
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            //д��
            String msg = "show me the code";
            //�ַ���-->�ֽ�����
            byte[] datas = msg.getBytes();
            baos.write(datas,0,datas.length);
            baos.flush();
            //��ȡ����
            dest = baos.toByteArray();
            System.out.println(dest.length + "-->" + new String(dest,0,baos.size()));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //�ͷ���Դ
            try {
                if (null != baos){
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
