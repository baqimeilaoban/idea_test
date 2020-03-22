package cn.sxt.io;

import java.io.File;

/**
 * 使用面向对象；统计文件夹的大小
 * @author 黄建波
 */
public class DirCount {
    //大小
    private long len;
    //文件夹路径
    private String path;
    //文件的个数
    private int fileSize;
    //文件夹的个数
    private int dirSzie;
    //源
    private File src;

    public DirCount(String path){
        this.path = path;
        this.src = new File(path);
        count(this.src);
    }

    /**
     * 统计大小
     */
    private void count(File src){
        //获取大小
        if (null != src && src.exists()){
            //大小
            if (src.isFile()){
                len += src.length();
                this.fileSize++;
            }else {
                //子孙级
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
