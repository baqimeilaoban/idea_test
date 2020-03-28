package cn.sxt.io;

import java.io.UnsupportedEncodingException;

/**
 * 编码：字符串--->编码
 * @author thinkpad
 */
public class ContentEncode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg = "性命生命使命";
        //编码:字节数组，默认使用工程的字符集
        byte[] datas = msg.getBytes();
        System.out.println(datas.length);

        //编码：其他字符集
        datas = msg.getBytes("UTF-16LE");
        System.out.println(datas.length);
    }
}
