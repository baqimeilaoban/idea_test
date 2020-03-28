package cn.sxt.io2;

import java.io.*;

/**
 * 1.图片 读取到字节数组中
 * 2.将字节数组写出到文件
 * @author thinkpad
 */
public class IOTest09 {
    public static void main(String[] args) {
        //图片转成字节数组
        byte[] datas = fileToByteArray("src/cn/sxt/io/IO.png");
        System.out.println(datas.length);
        byteArrayToFile(datas,"io-byte.png");
    }

    /**
     * 图片读取到字节数组
     * 1.图片到程序 FileInputStream
     * 2.程序到字节数组 ByteArrayOutputStream
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
            //缓冲容器
            byte[] flush = new byte[1024*10];
            //接收长度
            int len = -1;
            while ((len = is.read(flush)) != -1){
                //写出到字节数组中
                baos.write(flush,0,len);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
        return null;
    }

    /**
     * 字节数组写出到图片
     * 1.字节数组读取到程序 ByteArrayInputStream
     * 2.程序写出到文件 FileOutputStream
      */
    public static void byteArrayToFile(byte[] src,String filePath){
        //创建源
        File dest = new File(filePath);
        //选择流
        InputStream is = null;
        OutputStream os = null;
        try {
            //操作
            is= new ByteArrayInputStream(src);
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
        } catch (IOException e) {
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


