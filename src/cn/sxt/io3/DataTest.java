package cn.sxt.io3;

import java.io.*;

/**
 * ������
 * 1.д�����ȡ
 * 2.��ȡ��˳����д������һ��
 *
 * DataOutputStream
 * DataInputStream
 * @author �ƽ���
 */
public class DataTest {
    public static void main(String[] args) throws IOException {
        //д��
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
        //������������
        dos.writeUTF("����������");
        dos.writeInt(18);
        dos.writeBoolean(false);
        dos.writeChar('a');
        dos.flush();
        byte[] datas = baos.toByteArray();
        System.out.println(datas.length);
        //��ȡ
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        //˳����д��һ��
        String msg = dis.readUTF();
        int age = dis.readInt();
        boolean flag = dis.readBoolean();
        char ch = dis.readChar();
        System.out.println(flag);
    }
}
