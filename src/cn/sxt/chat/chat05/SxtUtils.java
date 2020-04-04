package cn.sxt.chat.chat05;

import java.io.Closeable;
import java.io.IOException;

/**
 * ������
 * @author �ƽ���
 */
public class SxtUtils {
    /**
     * �ͷ���Դ
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
