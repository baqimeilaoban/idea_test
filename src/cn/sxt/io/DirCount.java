package cn.sxt.io;

import java.io.File;

/**
 * ʹ���������ͳ���ļ��еĴ�С
 * @author �ƽ���
 */
public class DirCount {
    //��С
    private long len;
    //�ļ���·��
    private String path;
    //�ļ��ĸ���
    private int fileSize;
    //�ļ��еĸ���
    private int dirSzie;
    //Դ
    private File src;

    public DirCount(String path){
        this.path = path;
        this.src = new File(path);
        count(this.src);
    }

    /**
     * ͳ�ƴ�С
     */
    private void count(File src){
        //��ȡ��С
        if (null != src && src.exists()){
            //��С
            if (src.isFile()){
                len += src.length();
                this.fileSize++;
            }else {
                //���Ｖ
                for (File s : src.listFiles()){
                    count(s);
                }
                this.dirSzie++;
            }
        }
    }

    public long getLen() {
        return len;
    }

    public int getFileSize() {
        return fileSize;
    }

    public int getDirSzie() {
        return dirSzie;
    }

    public static void main(String[] args) {
        DirCount dir = new DirCount("D:/idea-workspace/src/cn/sxt/io");
        System.out.println(dir.getLen() + "--->" + dir.getFileSize() + "--->" + dir.getDirSzie());

        DirCount dir2 = new DirCount("D:/idea-workspace");
        System.out.println(dir2.getLen() + "--->" + dir2.getFileSize() + "--->" + dir2.getDirSzie());
    }
}
