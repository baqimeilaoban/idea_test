package cn.sxt.commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import java.io.File;
import java.util.Collection;


/**
 * 列出子孙级
 * @author 黄建波
 */
public class CIOTest02 {
    public static void main(String[] args) {
        Collection<File> files = FileUtils.listFiles(new File("src/cn/sxt/commons"), EmptyFileFilter.NOT_EMPTY,null);
        for (File file:files){
            System.out.println(file.getAbsolutePath());
        }
        System.out.println("---------------------------");
        files = FileUtils.listFiles(new File("src/cn/sxt"),new SuffixFileFilter("java"), DirectoryFileFilter.INSTANCE);
        for (File file:files){
            System.out.println(file.getAbsolutePath());
        }

    }
}
