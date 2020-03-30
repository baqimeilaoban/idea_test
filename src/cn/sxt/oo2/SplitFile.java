package cn.sxt.oo2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 面向对象思想封装分割
 * @author 黄建波
 */
public class SplitFile {
    /**
     * 源头
     */
    private File src;
    /**
     * 目的地
     */
    private String destDir;
    /**
     * 所有分割后的文件存储路径
     */
    private List<String> destPaths;
    /**
     * 每块大小
     */
    private int blockSize;
    /**
     * 块数：多少块
     */
    private int size;

    public SplitFile(String srcPath, String destDir, int blockSize) {
        this.src = new File(srcPath);
        this.destDir = destDir;
        this.blockSize = blockSize;
        this.destPaths = new ArrayList<>();
        init();
    }

    private void init() {
        //总长度
        long len = this.src.length();
        //块数：多少块
        this.size = (int)Math.ceil(len*1.0/blockSize);
        //路径
        for (int i = 0;i < size;i++){
            this.destPaths.add(this.destDir + "/" + i + "-" + this.src.getName());
        }
    }

    /**
     * 分割
     * 1.计算每一块的起始位置及大小
     * 2.分割
     */
    private void split() throws IOException {
        //总长度
        long len = src.length();
        //起始位置和实际大小
        int beginPos = 0;
        int actualSize = (int) (blockSize > len ? len : blockSize);
        for (int i = 0;i < size; i++){
            beginPos = i * blockSize;
            if (i==size-1){
                //最后一块
                actualSize = (int)len;
            }else {
                actualSize = blockSize;
                //剩余量
                len -= actualSize;
            }
            spiltDetail(i,beginPos,actualSize);
        }
    }

    /**
     * 指定第i块的起始位置和实际长度
     * @param i
     * @param beginPos
     * @param actualSize
     * @throws IOException
     */
    private void spiltDetail(int i,int beginPos,int actualSize) throws IOException{
        RandomAccessFile raf = new RandomAccessFile(this.src,"r");
        RandomAccessFile raf2 = new RandomAccessFile(this.destPaths.get(i),"rw");
        //随机读取
        raf.seek(beginPos);
        //操作
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len=raf.read(flush))!=-1){
            if (actualSize>len){
                //获取本次读取的所有内容
                raf2.write(flush,0,len);
                actualSize -= len;
            }else {
                raf2.write(flush,0,actualSize);
                break;
            }
        }
        raf2.close();
        raf.close();
    }

    /**
     * 文件的合并
     */
    private void merge(String destPath) throws IOException {
        //输出流
        OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath,true));
        //输入流
        for (int i = 0; i < destPaths.size();i++){
            InputStream is = new BufferedInputStream(new FileInputStream(destPaths.get(i)));
            //拷贝
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len=is.read(flush))!=-1){
                os.write(flush,0,len);
            }
            os.flush();
            is.close();
        }
        os.close();
    }
    public static void main(String[] args) throws IOException {
        SplitFile sf = new SplitFile("src/cn/sxt/io/IO.png","src/cn/sxt/dest",1024*10);
        sf.split();
        sf.merge("iocopy.png");
    }
}
