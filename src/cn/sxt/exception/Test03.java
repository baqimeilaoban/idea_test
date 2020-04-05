package cn.sxt.exception;

import java.io.FileReader;
import java.io.IOException;

/**
 * 使用throws声明异常
 * @author thinkpad
 */
public class Test03 {
    public static void main(String[] args) throws IOException {
        readMyFile();
    }

    public static void readMyFile() throws IOException {
        FileReader reader = null;
        reader = new FileReader("print.txt");
        char c1 = (char)reader.read();
        System.out.println(c1);
        if (reader!=null){
            reader.close();
        }
    }
}
