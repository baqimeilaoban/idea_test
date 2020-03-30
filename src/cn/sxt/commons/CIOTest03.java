package cn.sxt.commons;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * 写出内容
 * @author 黄建波
 */
public class CIOTest03 {
    public static void main(String[] args) throws IOException {
        //写出文件
        FileUtils.write(new File("src/cn/sxt/commons/happy.txt"),
                "学习是一件伟大得事业\r\n","GBK");
        FileUtils.writeStringToFile(new File("src/cn/sxt/commons/happy.txt"),
                "学习是一件快乐的事\r\n","GBK",true);
        FileUtils.writeByteArrayToFile(new File("src/cn/sxt/commons/happy.txt"),
                "学习是一件辛苦的事情\r\n".getBytes("GBK"),true);

        //写出列表
        List<String> datas = new ArrayList<String>();
        datas.add("马云");
        datas.add("马化腾");
        datas.add("弼马温");
        FileUtils.writeLines(new File("src/cn/sxt/commons/happy.txt")
                ,datas,".....",true);

    }
}
