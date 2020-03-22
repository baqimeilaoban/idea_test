package cn.sxt.io;

import java.io.File;

/**
 * �ݹ飺�����Լ������Լ�
 * ��ӡ���ＶĿ¼���ļ�������
 * @author �ƽ���
 */
public class DirDemo04 {
    public static void main(String[] args) {
        File src = new File("D:/idea-workspace");
        printName(src,0);
    }

    /**
     * ��ӡ���ＶĿ¼���ļ�������
     * @param
     */
    public static void printName(File src,int deep){
        for (int i = 0; i < deep; i++){
            //����ǰ����
            System.out.printf("-");
        }
        System.out.println(src.getName());
        if (null == src || !src.exists()){
            return;
        }else if(src.isDirectory()){
            //Ŀ¼
            for (File s:src.listFiles()){
                printName(s,deep+1);
            }
        }
    }
}
