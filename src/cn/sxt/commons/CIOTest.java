package cn.sxt.commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 读取内容
 * @author 黄建波
 */
public class CIOTest {
    public static void main(String[] args) throws IOException {
        //读取文件
        String msg = FileUtils.readFileToString(new File("src/cn/sxt/commons/emp.txt"),"GBK");
        System.out.println(msg);
        //读入字节数组中
        byte[] datas = FileUtils.readFileToByteArray(new File("src/cn/sxt/commons/emp.txt"));
        System.out.println(datas.length);
        System.out.println("-------------------------");
        //逐行读取
        List<String> msgs = FileUtils.readLines(new File("src/cn/sxt/commons/emp.txt"),"GBK");
        for (String string:msgs){
            System.out.println(string);
        }
        System.out.println("--------------------------");
        LineIterator it = FileUtils.lineIterator(new File("src/cn/sxt/commons/emp.txt"));
        while (it.hasNext()){
            System.out.println(it.nextLine());
        }
    }
}
