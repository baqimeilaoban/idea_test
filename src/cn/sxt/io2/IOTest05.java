package cn.sxt.io2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * �ļ��ַ������
 * 1.����Դ
 * 2.ѡ����
 * 3.����
 * 4.�ͷ���Դ
 * @author �ƽ���
 */
public class IOTest05 {
    public static void main(String[] args) {
        //ѡ��Դ
        File dest = new File("dest.txt");
        //ѡ����
        Writer writer = null;
        try {
            writer = new FileWriter(dest);
            //����
            String msg = "IO is so easy\r\n��ѧ�û�ӭ��";
            //�ַ���-->�ַ�����
            char[] datas = msg.toCharArray();
            writer.write(datas,0,datas.length);
            writer.flush();
        } catch (IOException e) {
                e.printStackTrace();
        }finally {
             //�ͷ���Դ
            try {
                if (null != writer){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
