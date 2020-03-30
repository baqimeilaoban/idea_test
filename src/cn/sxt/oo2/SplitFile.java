package cn.sxt.oo2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * �������˼���װ�ָ�
 * @author �ƽ���
 */
public class SplitFile {
    /**
     * Դͷ
     */
    private File src;
    /**
     * Ŀ�ĵ�
     */
    private String destDir;
    /**
     * ���зָ����ļ��洢·��
     */
    private List<String> destPaths;
    /**
     * ÿ���С
     */
    private int blockSize;
    /**
     * ���������ٿ�
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
        //�ܳ���
        long len = this.src.length();
        //���������ٿ�
        this.size = (int)Math.ceil(len*1.0/blockSize);
        //·��
        for (int i = 0;i < size;i++){
            this.destPaths.add(this.destDir + "/" + i + "-" + this.src.getName());
        }
    }

    /**
     * �ָ�
     * 1.����ÿһ�����ʼλ�ü���С
     * 2.�ָ�
     */
    private void split() throws IOException {
        //�ܳ���
        long len = src.length();
        //��ʼλ�ú�ʵ�ʴ�С
        int beginPos = 0;
        int actualSize = (int) (blockSize > len ? len : blockSize);
        for (int i = 0;i < size; i++){
            beginPos = i * blockSize;
            if (i==size-1){
                //���һ��
                actualSize = (int)len;
            }else {
                actualSize = blockSize;
                //ʣ����
                len -= actualSize;
            }
            spiltDetail(i,beginPos,actualSize);
        }
    }

    /**
     * ָ����i�����ʼλ�ú�ʵ�ʳ���
     * @param i
     * @param beginPos
     * @param actualSize
     * @throws IOException
     */
    private void spiltDetail(int i,int beginPos,int actualSize) throws IOException{
        RandomAccessFile raf = new RandomAccessFile(this.src,"r");
        RandomAccessFile raf2 = new RandomAccessFile(this.destPaths.get(i),"rw");
        //�����ȡ
        raf.seek(beginPos);
        //����
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len=raf.read(flush))!=-1){
            if (actualSize>len){
                //��ȡ���ζ�ȡ����������
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
     * �ļ��ĺϲ�
     */
    private void merge(String destPath) throws IOException {
        //�����
        OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath,true));
        //������
        for (int i = 0; i < destPaths.size();i++){
            InputStream is = new BufferedInputStream(new FileInputStream(destPaths.get(i)));
            //����
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
