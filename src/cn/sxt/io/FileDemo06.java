package cn.sxt.io;

import java.io.File;
import java.io.IOException;

/**
 * ������Ϣ��
 * createNewFile():�����ڲŴ��������ڴ����ɹ����ؿա����ܴ����ļ���
 * delete():ɾ���Ѿ����ڵ��ļ�
 * @author thinkpad
 */
public class FileDemo06 {
    public static void main(String[] args) throws IOException {
        File src = new File("D:\\idea-workspace\\src\\cn\\sxt\\io\\IO.txt");
        boolean flag = src.createNewFile();
        System.out.println(flag);

        flag = src.delete();
        System.out.println(flag);
    }
}
