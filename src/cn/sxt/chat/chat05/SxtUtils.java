package cn.sxt.chat.chat05;

import java.io.Closeable;
import java.io.IOException;

/**
 * 工具类
 * @author 黄建波
 */
public class SxtUtils {
    /**
     * 释放资源
     */
    public static void close(Closeable... targets){
        for (Closeable target:targets){
            try {
                if (null != target){
                    target.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
