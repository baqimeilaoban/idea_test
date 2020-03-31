package cn.sxt.udp;

import java.io.*;

/**
 * 1.图片 读取到字节数组
 * 2.字节数组写出到文件
 */
public class IOUtils {
    /**
     * 图片读取到文件数组
     * @param filePath 图片路径
     * @return 文件数组
     */
    public static byte[] fileToByteArray(String filePath){
        //创建源头与目的地
        File src = new File(filePath);
        byte[] dest = null;
        //选择流
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //操作
            is = new FileInputStream(src);
            baos = new ByteArrayOutputStream();
            //缓冲器
            byte[] flush = new byte[1024*10];
            //接收长度
            int len = -1;
            while ((len = is.read(flush)) != -1){
                //写出到字节数组
                baos.write(flush,0,len);
            }
            baos.flush();
            return baos.toByteArray();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //释放资源
            try {
                if (null != is) {
                    is.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
       return null;

    }

    /**
     * 将字节数组写出到图片
      * @param src 字节数组
     * @param filePath 图片路径
     */
    public static void byteArrayToFile(byte[] src,String filePath){
        //创建源
        File dest = new File(filePath);
        //选择流
        InputStream is = null;
        OutputStream os = null;
        try {
            //操作
            is = new ByteArrayInputStream(src);
            os = new FileOutputStream(dest);
            //缓冲容器
            byte[] flush = new byte[5];
            //接收长度
            int len = -1;
            while ((len = is.read(flush)) != -1){
                //写出到文件
                os.write(flush,0,len);
            }
            os.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //释放资源
            try {
                if (null != is){
                    is.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
