package cn.sxt.oo2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 随机读取和写入流RandomAccessFile
 * @author 黄建波
 */
public class RandTest01 {
    public static void main(String[] args) throws IOException {
        File src = new File("src/cn/sxt/io3/CopyTest.java");
        //总长度
        long len = src.length();
        //每块大小
        int blockSize = 10;
        //多少快
        int size = (int)Math.ceil(len*1.0/blockSize);
        System.out.println(size);
        //起始位置和实际大小
        int beginPos = 0;
        int actualSize = (int)(blockSize > len ? len : blockSize);
        for (int i = 0; i < size; i ++){
            beginPos = i*blockSize;
            if (i == size-1){
                //最后一块
                actualSize = (int) len;
            }else {
                //其他
                actualSize = blockSize;
                //剩余量
                len -= actualSize;
            }
            System.out.println(i + "-->" + beginPos + "-->" + actualSize);
            split(i,beginPos,actualSize);
        }
    }

    /**
     * 指定起始位置读取内容
     * @throws IOException
     */
    public static void test01()throws IOException{
        RandomAccessFile raf = new RandomAccessFile(new File("src/cn/sxt/io3/CopyTest.java"),"r");
        //随机读取
        raf.seek(2);
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len = raf.read(flush)) != -1){
            System.out.println(new String(flush,0,len));
        }

        raf.close();
    }

    /**
     * 指定起始位置和实际长度
     * @param i
     * @param beginPos
     * @param actualSize
     * @throws IOException
     */
    public static void split(int i,int beginPos,int actualSize)throws IOException{
        RandomAccessFile raf = new RandomAccessFile(new File("src/cn/sxt/io3/CopyTest.java"),"r");
        //随机读取
        raf.seek(beginPos);
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len = raf.read(flush)) != -1){
            if (actualSize > len){
                //获取本次读取的所有内容
                System.out.println(new String(flush,0,len));
                actualSize -= len;
            }else {
                System.out.println(new String(flush,0,actualSize));
                break;
            }
        }
    }
}
