package cn.sxt.io3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * �ĸ����裺�ֶζ�ȡ �ļ��ַ������� ���뻺����
 * 1.����Դ
 * 2.ѡ����
 * 3.����
 * 4���ͷ���Դ
 * @author �ƽ���
 */
public class BufferedTest02 {
    public static void main(String[] args) {
        //����Դ
        File src = new File("src/cn/sxt/io2/abc.txt");
        //ѡ����
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(src));
            //����
            String line = null;
            //���ж�ȡ
            while ((line=reader.readLine())!=null){
                //�ַ�����--->�ַ���
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (null != reader){
                    reader.close();
                }
            }catch (IOException E){
                E.printStackTrace();
            }
        }
    }

}
