package cn.sxt.commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * ¿½±´
 * @author »Æ½¨²¨
 */
public class CIOTest05 {
    public static void main(String[] args) throws IOException {
        FileUtils.copyFile(new File("src/cn/sxt/io/IO.png"),new File("src/cn/sxt/commons/p-copy.png"));
        String datas = IOUtils.toString(new URL("http://www.baidu.com"), StandardCharsets.UTF_8);
        System.out.println(datas);
    }
}
