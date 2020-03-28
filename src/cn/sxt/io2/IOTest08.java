package cn.sxt.io2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 字节数组输出流
 * 1.创建源:内部维护
 * 2.选择流：不关联源
 * 3.操作
 * 4.释放资源；可以不需要
 * 需要获取数据：toByteArray
 * @author 黄建波
 */
public class IOTest08 {
    public static void main(String[] args) {
        //创建源
        byte[] dest = null;
        //选择流（使用新增方法）
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            //写出
            String msg = "show me the code";
            //字符串-->字节数组
            byte[] datas = msg.getBytes();
            baos.write(datas,0,datas.length);
            baos.flush();
            //获取数据
            dest = baos.toByteArray();
            System.out.println(dest.length + "-->" + new String(dest,0,baos.size()));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            try {
                if (null != baos){
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
