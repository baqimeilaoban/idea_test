package cn.sxt.io;

import java.io.UnsupportedEncodingException;

/**
 * ���룺�ַ���--->����
 * @author thinkpad
 */
public class ContentEncode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg = "��������ʹ��";
        //����:�ֽ����飬Ĭ��ʹ�ù��̵��ַ���
        byte[] datas = msg.getBytes();
        System.out.println(datas.length);

        //���룺�����ַ���
        datas = msg.getBytes("UTF-16LE");
        System.out.println(datas.length);
    }
}
