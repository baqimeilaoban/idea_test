package cn.sxt.location;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * ���������ԭ��
 * @author �ƽ���
 */
public class SpiderTest01 {
    public static void main(String[] args) throws IOException {
        //��ȡURL
        URL url = new URL("https://www.jd.com");
        //������Դ
        InputStream is = url.openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        String msg;
        while (null!=(msg=br.readLine())){
            System.out.println(msg);
        }
        br.close();
    }
}
