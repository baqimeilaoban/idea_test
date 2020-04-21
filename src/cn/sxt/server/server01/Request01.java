package cn.sxt.server.server01;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 封装请求协议：获取method uri以及请求参数
 * @author 黄建波
 */
public class Request01 {
    /**
     * 协议信息
     */
    private String requestInfo;
    /**
     * 请求方式
     */
    private String method;
    /**
     * 请求url
     */
    private String url;
    /**
     * 请求参数
     */
    private String queryStr;
    private final String CRLF = "\r\n";

    public Request01(Socket client) throws IOException {
        this(client.getInputStream());
    }

    public Request01(InputStream is){
        byte[] datas = new byte[1024*1024];
        int len;
        try {
            len = is.read(datas);
            this.requestInfo = new String(datas,0,len);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        //分解字符串
        parseRequestInfo();
    }

    private void parseRequestInfo() {
        System.out.println("---分解---");
        System.out.println("---1.获取请求方式：开头到第一个/---");
        this.method = this.requestInfo.substring(0,this.requestInfo.indexOf("/")).toLowerCase();
        this.method = this.method.trim();
        System.out.println("---2.获取请求url：第一个/ 到 HTTP/---");
        System.out.println("---可能包含参数？前面的为url---");
        //1）获取/的位置
        int startIndex = this.requestInfo.indexOf("/") + 1;
        //2）获取HTTP/的位置
        int endIndex = this.requestInfo.indexOf("HTTP/");
        //3）分割字符串
        this.url = this.requestInfo.substring(startIndex,endIndex);
        //4）获取？的位置
        int queryIndex = this.url.indexOf("?");
        if (queryIndex>=0){
            //表示存在请求参数
            String[] urlArry = this.url.split("\\?");
            this.url = urlArry[0];
            queryStr = urlArry[1];
        }
        System.out.println(this.url);

        System.out.println("---3.获取请求参数；如果GET已经获取，如果是POST可能在请求体中---");

        if (method.equals("post")){
            String qStr = this.requestInfo.substring(this.requestInfo.lastIndexOf(CRLF)).trim();
            System.out.println(qStr + "-->");
            if (null==queryStr){
                queryStr = qStr;
            }else {
                queryStr += "&" + qStr;
            }
        }
        queryStr = null==queryStr?"":queryStr;
        System.out.println(method + "-->" + url + "-->" + queryStr);
    }

}
