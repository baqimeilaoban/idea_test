package cn.sxt.io3;

import java.io.*;

/**
 * ת������InputStreamReader OutputStreamWriter
 * 1.�ַ�������ʽ�����ֽ����������ı���
 * 2.ָ���ַ���
 * @author �ƽ���
 */
public class ConvertTest {
    public static void main(String[] args) {
        //����System.in��System.out
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            //ѭ����ȡ���̵�����(exit�˳�)�����������
            String msg = "";
            while (!msg.equals("exit")){
                //ѭ����ȡ
                msg = reader.readLine();
                //ѭ��д��
                writer.write(msg);
                writer.newLine();
                //ǿ��ˢ��
                writer.flush();
            }
        }catch (IOException e){
            System.out.println("�����쳣");
        }


    }
}
