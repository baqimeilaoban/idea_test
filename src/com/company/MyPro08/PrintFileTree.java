package com.company.MyPro08;

import java.io.File;

/**
 * ʹ�õݹ��㷨��ӡĿ¼��
 * @author �ƽ���
 */
public class PrintFileTree {
    public static void main(String[] args) {
        File f = new File("D:\\java\\java\\1-java�����﷨");
        printFile(f,0);
    }

    static void printFile(File file,int level){
        //�������
        for (int i = 0; i < level; i++){
            System.out.print("-");
        }
        System.out.println(file.getName());
        if (file.isDirectory()){
            File[] files = file.listFiles();

            for (File temp:files){
                printFile(temp,level + 1);
            }
        }
    }
}
