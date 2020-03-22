package cn.sxt.io;

import java.io.File;

/**
 * 名称或路径
 * getName():获取名称
 * getPath()：相对、绝对
 * getAbsolutePath()；绝对
 * getParent():若父路径没有，则返回null
 * @author 黄建波
 */
public class TestFileDemo03 {
    public static void main(String[] args) {
        File src = new File("D:\\idea-workspace\\src\\cn\\sxt\\io\\IO.png");
        //基本信息
        System.out.println("名称" + src.getName());
        System.out.println("路径：" + src.getPath());
        System.out.println("绝对路径：" + src.getAbsolutePath());
        System.out.println("父路径：" + src.getParent());
        System.out.println("父对象：" + src.getParentFile().getName());
    }
}
