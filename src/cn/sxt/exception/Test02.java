package cn.sxt.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 使用try-catch处理异常
 * @author thinkpad
 */
public class Test02 {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = new FileReader("d:/print.txt");
            System.out.println("step1");
            char c1 = (char)reader.read();
            System.out.println(c1);
        } catch (FileNotFoundException e) {
            System.out.println("step2");
            //子类异常在父类异常之前
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("step3");
            try {
                if (reader != null){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
