package cn.sxt.io;

import java.io.UnsupportedEncodingException;

/**
 * ���룺�ֽ�--->�ַ���
 * @author �ƽ���
 */
public class ContentDecode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg = "��������ʹ��a";
        //���룻�ֽ����飬Ĭ��ʹ�ù��̵��ַ���
        byte[] datas = msg.getBytes();
        //���룺�ַ���
        msg = new String(datas,0,datas.length,"GBK");
        System.out.println(msg);

        //����ԭ��1���ֽ�������
        msg = new String(datas,0,datas.length-2,"GBK");
        System.out.println(msg);
        //����ԭ��2���ַ�����ͳһ
        msg = new String(datas,0,datas.length,"utf8");
        System.out.println(msg);
    }
}
