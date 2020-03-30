package cn.sxt.oo2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * �����ȡ��д����RandomAccessFile
 * @author �ƽ���
 */
public class RandTest01 {
    public static void main(String[] args) throws IOException {
        File src = new File("src/cn/sxt/io3/CopyTest.java");
        //�ܳ���
        long len = src.length();
        //ÿ���С
        int blockSize = 10;
        //���ٿ�
        int size = (int)Math.ceil(len*1.0/blockSize);
        System.out.println(size);
        //��ʼλ�ú�ʵ�ʴ�С
        int beginPos = 0;
        int actualSize = (int)(blockSize > len ? len : blockSize);
        for (int i = 0; i < size; i ++){
            beginPos = i*blockSize;
            if (i == size-1){
                //���һ��
                actualSize = (int) len;
            }else {
                //����
                actualSize = blockSize;
                //ʣ����
                len -= actualSize;
            }
            System.out.println(i + "-->" + beginPos + "-->" + actualSize);
            split(i,beginPos,actualSize);
        }
    }

    /**
     * ָ����ʼλ�ö�ȡ����
     * @throws IOException
     */
    public static void test01()throws IOException{
        RandomAccessFile raf = new RandomAccessFile(new File("src/cn/sxt/io3/CopyTest.java"),"r");
        //�����ȡ
        raf.seek(2);
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len = raf.read(flush)) != -1){
            System.out.println(new String(flush,0,len));
        }

        raf.close();
    }

    /**
     * ָ����ʼλ�ú�ʵ�ʳ���
     * @param i
     * @param beginPos
     * @param actualSize
     * @throws IOException
     */
    public static void split(int i,int beginPos,int actualSize)throws IOException{
        RandomAccessFile raf = new RandomAccessFile(new File("src/cn/sxt/io3/CopyTest.java"),"r");
        //�����ȡ
        raf.seek(beginPos);
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len = raf.read(flush)) != -1){
            if (actualSize > len){
                //��ȡ���ζ�ȡ����������
                System.out.println(new String(flush,0,len));
                actualSize -= len;
            }else {
                System.out.println(new String(flush,0,actualSize));
                break;
            }
        }
    }
}
