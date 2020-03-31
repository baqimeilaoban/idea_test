package cn.sxt.location;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL:ͳһ��Դ��λ���������������ʯ֮һ(http,html)��������Դ
 * 1.Э��
 * 2.�������������
 * 3.�˿ڣ�Ĭ��80
 * 4.������Դ
 * http://www.baidu.com:80/index.html?uname=shsxt&age=18#a
 */
public class URLTest01 {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://www.baidu.com:80/index.html?uname=shsxt&age=18#a");
        //��ȡ�ĸ�ֵ
        System.out.println("Э�飺" + url.getProtocol());
        System.out.println("����|ip:" + url.getHost());
        System.out.println("�˿ڣ�" + url.getPort());
        System.out.println("������Դ1��" + url.getFile());
        System.out.println("������Դ2��" + url.getPath());

        //����
        System.out.println("������" + url.getQuery());
        //ê��
        System.out.println("ê�㣺" + url.getRef());

    }
}
