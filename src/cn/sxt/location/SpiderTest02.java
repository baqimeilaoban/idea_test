package cn.sxt.location;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * ��������ԭ��+ģ�������
 * @author �ƽ���
 */
public class SpiderTest02 {
    public static void main(String[] args) throws IOException {
        //��ȡURL
        URL url = new URL("https://www.dianping.com");
        //������Դ
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.117 Safari/537.36");
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),StandardCharsets.UTF_8));
        String msg;
        while (null!=(msg=br.readLine())){
            System.out.println(msg);
        }
    }
}
