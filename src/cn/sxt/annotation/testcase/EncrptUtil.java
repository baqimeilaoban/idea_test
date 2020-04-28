package cn.sxt.annotation.testcase;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 加密工具类
 * @author thinkpad
 */
public class EncrptUtil {
    public static void main(String[] args) {
        encrpt("D:\\idea-workspace\\out\\production\\idea-workspace\\cn\\sxt\\annotation\\testcase\\HelloWorld.class","D:\\idea-workspace\\out\\production\\idea-workspace\\cn\\sxt\\annotation\\testcase\\HelloWordEncrpt.class");
    }
    public static void encrpt(String src,String dest){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);
            int temp = -1;
            while ((temp=fis.read())!=-1){
                //取反操作
                fos.write(temp^0xff);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (fis!=null){
                    fis.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            try {
                if (fos!=null){
                    fos.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
