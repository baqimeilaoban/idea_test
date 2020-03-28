package cn.sxt.io3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * �ļ��ַ������ ���뻺����
 * 1.����Դ
 * 2��ѡ����
 * 3.����
 * 4.�ͷ�����
 * @author �ƽ���
 */
public class BufferedTest03 {
    public static void main(String[] args) {
        //����Դ
        File dest = new File("src/cn/sxt/io2/ab.txt");
        //ѡ����
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(dest));
            writer.append("IO is so easy");
            writer.newLine();
            writer.append("��ѧ�û�ӭ�㣡");
            writer.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (null != writer){
                    writer.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
